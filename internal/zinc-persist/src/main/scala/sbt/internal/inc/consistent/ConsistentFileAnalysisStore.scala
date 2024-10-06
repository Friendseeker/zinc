// Based on zinc's FileAnalysisStore:
package sbt.internal.inc.consistent

/*
 * Zinc - The incremental compiler for Scala.
 * Copyright Lightbend, Inc. and Mark Harrah
 *
 * Licensed under Apache License 2.0
 * (http://www.apache.org/licenses/LICENSE-2.0).
 *
 * See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 */

import java.io.{ File, FileInputStream, FileOutputStream, IOException }
import java.util.Optional
import sbt.io.{ IO, Using }
import xsbti.compile.{ AnalysisContents, AnalysisStore => XAnalysisStore }

import scala.util.control.Exception.allCatch
import xsbti.compile.analysis.ReadWriteMappers

import java.util.zip.{ GZIPInputStream, GZIPOutputStream }
import scala.concurrent.ExecutionContext
import org.xerial.snappy.{ SnappyInputStream, SnappyOutputStream }
import sbt.internal.inc.consistent.Compression._

object Compression extends Enumeration {
  type Compression = Value
  val Snappy, ParallelGZIP, StandardGZIP = Value
}

object ConsistentFileAnalysisStore {
  def text(
      file: File,
      mappers: ReadWriteMappers,
      sort: Boolean = true,
      ec: ExecutionContext = ExecutionContext.global,
      parallelism: Int = Runtime.getRuntime.availableProcessors()
  ): XAnalysisStore =
    new AStore(
      file,
      new ConsistentAnalysisFormat(mappers, sort),
      SerializerFactory.text,
      ec,
      parallelism
    )

  def binary(file: File): XAnalysisStore =
    binary(
      file,
      mappers = ReadWriteMappers.getEmptyMappers(),
      sort = true,
    )

  def binary(
      file: File,
      mappers: ReadWriteMappers
  ): XAnalysisStore =
    binary(
      file,
      mappers,
      sort = true,
    )

  def binary(
      file: File,
      mappers: ReadWriteMappers,
      sort: Boolean,
      ec: ExecutionContext = ExecutionContext.global,
      parallelism: Int = Runtime.getRuntime.availableProcessors(),
      compression: Compression = ParallelGZIP,
  ): XAnalysisStore =
    new AStore(
      file,
      new ConsistentAnalysisFormat(mappers, sort),
      SerializerFactory.binary,
      ec,
      parallelism,
      compression,
    )

  private final class AStore[S <: Serializer, D <: Deserializer](
      file: File,
      format: ConsistentAnalysisFormat,
      sf: SerializerFactory[S, D],
      ec: ExecutionContext = ExecutionContext.global,
      parallelism: Int = Runtime.getRuntime.availableProcessors(),
      compression: Compression = ParallelGZIP,
  ) extends XAnalysisStore {

    def set(analysisContents: AnalysisContents): Unit = {
      val analysis = analysisContents.getAnalysis
      val setup = analysisContents.getMiniSetup
      val tmpAnalysisFile = File.createTempFile(file.getName, ".tmp")
      if (!file.getParentFile.exists()) file.getParentFile.mkdirs()
      val fout = new FileOutputStream(tmpAnalysisFile)
      try {
        val gout = compression match {
          case Snappy       => new SnappyOutputStream(fout)
          case ParallelGZIP => new ParallelGzipOutputStream(fout, ec, parallelism)
          case StandardGZIP => new GZIPOutputStream(fout)
        }
        val ser = sf.serializerFor(gout)
        format.write(ser, analysis, setup)
        gout.close()
      } finally fout.close
      IO.move(tmpAnalysisFile, file)
    }

    def get(): Optional[AnalysisContents] = {
      import sbt.internal.inc.JavaInterfaceUtil.EnrichOption
      allCatch.opt(unsafeGet()).toOptional
    }

    def unsafeGet(): AnalysisContents =
      Using.resource(compression match {
        case Snappy       => new SnappyInputStream(_: FileInputStream)
        case ParallelGZIP => new GZIPInputStream(_: FileInputStream)
        case StandardGZIP => new GZIPInputStream(_: FileInputStream)
      })(
        new FileInputStream(file)
      ) { in =>
        val deser = sf.deserializerFor(in)
        val (analysis, setup) = format.read(deser)
        AnalysisContents.create(analysis, setup)
      }
  }
}
