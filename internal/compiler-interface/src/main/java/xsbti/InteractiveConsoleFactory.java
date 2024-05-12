/*
 * Zinc - The incremental compiler for Scala.
 * Copyright Scala Center, Lightbend, and Mark Harrah
 *
 * Licensed under Apache License 2.0
 * SPDX-License-Identifier: Apache-2.0
 *
 * See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 */

package xsbti;

import java.util.Optional;

/** Interface for running console interactively.
 * An implementation is loaded using java.util.ServiceLoader.
 */
public interface InteractiveConsoleFactory {
  InteractiveConsoleInterface createConsole(
      String[] args,
      String bootClasspathString,
      String classpathString,
      String initialCommands,
      String cleanupCommands,
      Optional<ClassLoader> loader,
      String[] bindNames,
      Object[] bindValues,
      Logger log
  );
}
