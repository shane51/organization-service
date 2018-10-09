package com.shane51.organizationservice.client;

import com.shane51.organizationservice.model.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name = "department-service")
public interface DepartmentClient {

    @GetMapping("/organization/{organizationId}")
    List<Department> findByOrganizationId(@PathVariable("organizationId") Long organizationId);
}
