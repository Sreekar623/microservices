package com.project.EmployeeService.Controller;


import com.project.EmployeeService.Model.Employee;
import com.project.EmployeeService.Repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    Logger log= LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        log.info("addEmployee");
        return employeeRepository.addEmployee(employee);
    }
    @GetMapping("/getallemps")
    public List<Employee> getAllEmployees() {
        log.info("getAllEmployees");
        return employeeRepository.getEmployees();
    }

    @GetMapping("/getempbydid")
    public List<Employee> getEmployeesByDeptId(@RequestParam Long deptId) {
      log.info("getEmployeesByDeptId");
        return employeeRepository.fetchByDepartmentId(deptId);
    }
}
