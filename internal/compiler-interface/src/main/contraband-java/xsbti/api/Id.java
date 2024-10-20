/**
 * This code is generated using [[https://www.scala-sbt.org/contraband]].
 */

// DO NOT EDIT MANUALLY
package xsbti.api;
public final class Id extends xsbti.api.PathComponent implements java.io.Serializable {
    
    public static Id create(String _id) {
        return new Id(_id);
    }
    public static Id of(String _id) {
        return new Id(_id);
    }
    private String id;
    protected Id(String _id) {
        super();
        id = _id;
    }
    
    public String id() {
        return this.id;
    }
    public Id withId(String id) {
        return new Id(id);
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Id)) {
            return false;
        } else {
            Id o = (Id)obj;
            return this.id().equals(o.id());
        }
    }
    public int hashCode() {
        return 37 * (37 * (17 + "xsbti.api.Id".hashCode()) + id().hashCode());
    }
    public String toString() {
        return "Id("  + "id: " + id() + ")";
    }
}
