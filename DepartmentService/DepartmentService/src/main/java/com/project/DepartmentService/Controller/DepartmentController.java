package com.project.DepartmentService.Controller;


import com.project.DepartmentService.Client.EmployeeClient;
import com.project.DepartmentService.Model.Department;
import com.project.DepartmentService.Repository.DepartmentServiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private EmployeeClient employeeClient;

    private static final Logger lg= LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentServiceRepository departmentServiceRepository;

    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department) {
        lg.info("Department added"+department);
        return  departmentServiceRepository.addDepartment(department);
    }

    @GetMapping("/fetchById")
    public Department fetchDepartmentById(@RequestParam Long id) {
        lg.info("Fetching Department with id "+id);
        return departmentServiceRepository.fetchById(id);

    }

    @GetMapping("/test")
    public String print(){
         return "hello via gateway";
    }

    @GetMapping("/fetchAll")
    public List<Department> fetchDepartments() {
        lg.info("Fetching All Departments");
        return departmentServiceRepository.getDepartments();

    }
    @GetMapping
    public List<Department> fetchAllEmployeesWithDepartment() {
        lg.info("Fetching All Department's Employees");
        List<Department> departments=departmentServiceRepository.getDepartments();
        departments.forEach(department->{department.setEmployees(employeeClient.fetchEmployeesByDId(department.getId()));});
        return departments;
    }
}
