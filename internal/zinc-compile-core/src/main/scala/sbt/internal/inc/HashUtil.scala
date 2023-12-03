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

package sbt
package internal
package inc

import net.openhft.hashing.LongHashFunction

import java.nio.file.{ Files, Path }

object HashUtil {
  def toFarmHashString(digest: Long): String =
    s"farm64-${digest.toHexString}"

  def farmHash(bytes: Array[Byte]): Long =
    LongHashFunction.farmNa().hashBytes(bytes)

  def farmHash(path: Path): Long = {
    import sbt.io.Hash

    //allocating many byte arrays for large files may lead to OOME
    //but it is more efficient for small files
    val largeFileLimit = 10 * 1024 * 1024

    if (Files.size(path) < largeFileLimit)
      farmHash(Files.readAllBytes(path))
    else
      farmHash(Hash(path.toFile))
  }
}
