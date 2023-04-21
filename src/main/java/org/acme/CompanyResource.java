package org.acme;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.acme.db.entities.CompanyEntity;
import org.acme.db.projections.CompanyProjection;
import org.acme.db.repositories.CompanyRepository;

import java.util.List;

@Path("/companies")
public class CompanyResource {

    private final CompanyRepository companyRepository;

    public CompanyResource(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GET
    @Path("/entities")
    public Uni<List<CompanyEntity>> getCompanyEntities() {
        return companyRepository.getCompanyEntities();
    }

    @GET
    @Path("/projections")
    public Uni<List<CompanyProjection>> getCompanyProjections() {
        return companyRepository.getCompanyProjections();
    }

    @POST
    public Uni<CompanyEntity> createCompany() {
        return companyRepository.createCompanies();
    }
}
