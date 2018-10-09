package com.shane51.organizationservice.repository;

import com.shane51.organizationservice.model.Organization;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrganizationRepository {

    private List<Organization> organizations = new ArrayList<>();

    public Organization add(Organization organization) {
        organization.setId((long ) (organizations.size() + 1));
        organizations.add(organization);
        return organization;
    }

    public Organization findById(Long id) {
        Optional<Organization> organization = organizations.stream().filter(p -> p.getId().equals(id)).findFirst();
        return organization.orElseGet(null);
    }

    public List<Organization> findAll() {
        return organizations;
    }
}
