/**
 * This code is generated using [[https://www.scala-sbt.org/contraband]].
 */

// DO NOT EDIT MANUALLY
package xsbti.api;
public final class EmptyType extends xsbti.api.Type implements java.io.Serializable {
    
    public static EmptyType create() {
        return new EmptyType();
    }
    public static EmptyType of() {
        return new EmptyType();
    }
    
    protected EmptyType() {
        super();
        
    }
    
    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof EmptyType)) {
            return false;
        } else {
            EmptyType o = (EmptyType)obj;
            return true;
        }
    }
    public int hashCode() {
        return 37 * (17 + "xsbti.api.EmptyType".hashCode());
    }
    public String toString() {
        return "EmptyType("  + ")";
    }
}
