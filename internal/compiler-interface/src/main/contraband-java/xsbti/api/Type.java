/**
 * This code is generated using [[https://www.scala-sbt.org/contraband]].
 */

// DO NOT EDIT MANUALLY
package xsbti.api;
public abstract class Type implements java.io.Serializable {
    
    
    protected Type() {
        super();
        
    }
    
    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Type)) {
            return false;
        } else {
            Type o = (Type)obj;
            return true;
        }
    }
    public int hashCode() {
        return 37 * (17 + "xsbti.api.Type".hashCode());
    }
    public String toString() {
        return "Type("  + ")";
    }
}
