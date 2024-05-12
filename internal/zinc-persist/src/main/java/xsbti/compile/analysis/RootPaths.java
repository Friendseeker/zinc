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

package xsbti.compile.analysis;

import java.io.File;

/**
 * Defines an interface to model all the root paths.
 *
 * This interface is required to be used for {@link ReadMapper} and {@link WriteMapper}.
 */
public interface RootPaths {
    /**
     * Returns a default implementation that can be used from the Java side.
     *
     * @param sourcesRootPath The common root to all the sources.
     * @param librariesRootPath The common root to all the libraries (jars).
     * @param productsRootPath The common root to all the products (class files).
     * @return An instance of {@link RootPaths}.
     */
    static RootPaths getPaths(File sourcesRootPath, File librariesRootPath, File productsRootPath) {
        return new sbt.internal.inc.ConcreteRootPaths(sourcesRootPath, librariesRootPath, productsRootPath);
    }

    /**
     * @return The common root directory for all the compiled source files.
     */
    File getSourcesRootPath();

    /**
      * @return The common root directory for all the library files (jars and dependencies).
     */
    File getLibrariesRootPath();

    /**
     * @return The common root directory for all the generated products by a compiler iteration.
     */
    File getProductsRootPath();
}
