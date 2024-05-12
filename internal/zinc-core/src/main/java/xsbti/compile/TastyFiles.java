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

package xsbti.compile;

/**
 * Can be added to `IncOptions.auxiliaryClassFiles` so that the TASTy files are
 * managed by the ClassFileManager.
 */
public class TastyFiles extends AuxiliaryClassFileExtension {
    private static final TastyFiles _instance = new TastyFiles();

    public static TastyFiles instance() {
        return _instance;
    }

    private TastyFiles() {
        super("tasty");
    }
}
