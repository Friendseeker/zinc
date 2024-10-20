/**
 * This code is generated using [[https://www.scala-sbt.org/contraband]].
 */

// DO NOT EDIT MANUALLY
package xsbti.compile;
/** Configures a single compilation of a single set of sources. */
public final class Inputs implements java.io.Serializable {
    
    public static Inputs create(xsbti.compile.Compilers _compilers, xsbti.compile.CompileOptions _options, xsbti.compile.Setup _setup, xsbti.compile.PreviousResult _previousResult) {
        return new Inputs(_compilers, _options, _setup, _previousResult);
    }
    public static Inputs of(xsbti.compile.Compilers _compilers, xsbti.compile.CompileOptions _options, xsbti.compile.Setup _setup, xsbti.compile.PreviousResult _previousResult) {
        return new Inputs(_compilers, _options, _setup, _previousResult);
    }
    private xsbti.compile.Compilers compilers;
    private xsbti.compile.CompileOptions options;
    private xsbti.compile.Setup setup;
    private xsbti.compile.PreviousResult previousResult;
    protected Inputs(xsbti.compile.Compilers _compilers, xsbti.compile.CompileOptions _options, xsbti.compile.Setup _setup, xsbti.compile.PreviousResult _previousResult) {
        super();
        compilers = _compilers;
        options = _options;
        setup = _setup;
        previousResult = _previousResult;
    }
    /** Return the Scala and Java compilers to use for compilation. */
    public xsbti.compile.Compilers compilers() {
        return this.compilers;
    }
    /** Return the compilation options, such as the sources and classpath to use. */
    public xsbti.compile.CompileOptions options() {
        return this.options;
    }
    /** Represent the configuration of incremental compilation. */
    public xsbti.compile.Setup setup() {
        return this.setup;
    }
    /** Represent tha latest result of incremental compilation. */
    public xsbti.compile.PreviousResult previousResult() {
        return this.previousResult;
    }
    public Inputs withCompilers(xsbti.compile.Compilers compilers) {
        return new Inputs(compilers, options, setup, previousResult);
    }
    public Inputs withOptions(xsbti.compile.CompileOptions options) {
        return new Inputs(compilers, options, setup, previousResult);
    }
    public Inputs withSetup(xsbti.compile.Setup setup) {
        return new Inputs(compilers, options, setup, previousResult);
    }
    public Inputs withPreviousResult(xsbti.compile.PreviousResult previousResult) {
        return new Inputs(compilers, options, setup, previousResult);
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Inputs)) {
            return false;
        } else {
            Inputs o = (Inputs)obj;
            return this.compilers().equals(o.compilers()) && this.options().equals(o.options()) && this.setup().equals(o.setup()) && this.previousResult().equals(o.previousResult());
        }
    }
    public int hashCode() {
        return 37 * (37 * (37 * (37 * (37 * (17 + "xsbti.compile.Inputs".hashCode()) + compilers().hashCode()) + options().hashCode()) + setup().hashCode()) + previousResult().hashCode());
    }
    public String toString() {
        return "Inputs("  + "compilers: " + compilers() + ", " + "options: " + options() + ", " + "setup: " + setup() + ", " + "previousResult: " + previousResult() + ")";
    }
}
