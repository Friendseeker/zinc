/**
 * This code is generated using [[https://www.scala-sbt.org/contraband]].
 */

// DO NOT EDIT MANUALLY
package xsbti.api;
public final class IdQualifier extends xsbti.api.Qualifier implements java.io.Serializable {
    
    public static IdQualifier create(String _value) {
        return new IdQualifier(_value);
    }
    public static IdQualifier of(String _value) {
        return new IdQualifier(_value);
    }
    private String value;
    protected IdQualifier(String _value) {
        super();
        value = _value;
    }
    
    public String value() {
        return this.value;
    }
    public IdQualifier withValue(String value) {
        return new IdQualifier(value);
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof IdQualifier)) {
            return false;
        } else {
            IdQualifier o = (IdQualifier)obj;
            return this.value().equals(o.value());
        }
    }
    public int hashCode() {
        return 37 * (37 * (17 + "xsbti.api.IdQualifier".hashCode()) + value().hashCode());
    }
    public String toString() {
        return "IdQualifier("  + "value: " + value() + ")";
    }
}
