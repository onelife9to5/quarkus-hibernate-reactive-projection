package org.acme.db.repositories;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.db.entities.CompanyEntity;
import org.acme.db.entities.DepartmentEntity;
import org.acme.db.projections.CompanyProjection;

import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class CompanyRepository implements PanacheRepository<CompanyEntity> {


    @WithSession
    public Uni<List<CompanyEntity>> getCompanyEntities() {
        return findAll().list();
    }

    @WithSession
    public Uni<List<CompanyProjection>> getCompanyProjections() {
        return findAll().project(CompanyProjection.class).list();
    }

    @WithTransaction
    public Uni<CompanyEntity> createCompanies() {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setName("Apple");
        companyEntity.setAddress("California");

        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setName("Developers");
        departmentEntity.setDescription("iOS developers");
        departmentEntity.setCompany(companyEntity);

        companyEntity.setDepartments(Collections.singletonList(departmentEntity));

        return persist(companyEntity).map(unused -> companyEntity);
    }
}
