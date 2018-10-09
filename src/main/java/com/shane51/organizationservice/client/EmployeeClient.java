package com.shane51.organizationservice.client;

import com.shane51.organizationservice.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name = "employee-service")
public interface EmployeeClient {

    @GetMapping("/organization/{organizationId}")
    List<Employee> findByOrganizaionId(@PathVariable("organizationId") Long organizationId);
}
