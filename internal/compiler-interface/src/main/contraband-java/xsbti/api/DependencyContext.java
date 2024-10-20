/**
 * This code is generated using [[https://www.scala-sbt.org/contraband]].
 */

// DO NOT EDIT MANUALLY
package xsbti.api;
/**
 * Enumeration of existing dependency contexts.
 * Dependency contexts represent the various kind of dependencies that
 * can exist between symbols.
 */
public enum DependencyContext {
    /**
     * Represents a direct dependency between two symbols :
     * object Foo
     * object Bar { def foo = Foo }
     */
    DependencyByMemberRef,
    /**
     * Represents an inheritance dependency between two symbols :
     * class A
     * class B extends A
     */
    DependencyByInheritance,
    /**
     * Represents an inheritance dependency between a local class
     * and a non local class:
     * // A.scala
     * class A
     * // B.scala
     * class B {
         * def foo = {
             * class Local extends A
             * }
             * }
             */
            LocalDependencyByInheritance,
            /** Represents a dependency to symbols inspected during macro expansion */
            DependencyByMacroExpansion;
            
        }
