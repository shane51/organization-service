package com.shane51.organizationservice.controller;

import com.shane51.organizationservice.client.DepartmentClient;
import com.shane51.organizationservice.client.EmployeeClient;
import com.shane51.organizationservice.model.Organization;
import com.shane51.organizationservice.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganizationController {

    @Autowired
    OrganizationRepository repository;

    @Autowired
    DepartmentClient departmentClient;

    @Autowired
    EmployeeClient employeeClient;

    @PostMapping("/")
    public Organization add(@RequestBody Organization organization) {
        return repository.add(organization);
    }

    @GetMapping("/{id}")
    public Organization findById(@PathVariable("id") Long id) {
        return repository.findById(id);
    }

    @GetMapping("/")
    public List<Organization> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}/with-departments")
    public Organization findByIdWithDepartments(@PathVariable("id") Long id) {
        Organization organization = repository.findById(id);
        organization.setDepartments(departmentClient.findByOrganizationId(organization.getId()));
        return organization;
    }

    @GetMapping("/{id}/with-employees")
    public Organization findByIdWithEmployee(@PathVariable("id") Long id) {
        Organization organization = repository.findById(id);
        organization.setEmployees(employeeClient.findByOrganizaionId(organization.getId()));
        return organization;
    }
}
