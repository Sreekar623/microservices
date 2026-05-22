package com.project.DepartmentService.Client;
import com.project.DepartmentService.Model.Employee;
import com.project.DepartmentService.Model.Department;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {


    @GetExchange("/getempbydid")
    public List<Employee> fetchEmployeesByDId(@RequestParam Long deptId);



}
