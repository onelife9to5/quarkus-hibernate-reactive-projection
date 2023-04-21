package org.acme.db.projections;

import java.util.List;

public class CompanyProjection {
    private String name;
    private List<DepartmentProjection> departments;

    public CompanyProjection(String name, List<DepartmentProjection> departments) {
        this.name = name;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DepartmentProjection> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentProjection> departments) {
        this.departments = departments;
    }
}
