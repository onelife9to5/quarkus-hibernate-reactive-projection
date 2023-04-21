package org.acme.db.projections;

public class DepartmentProjection {
    private String description;

    public DepartmentProjection(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
