package com.project.EmployeeService.Repository;

import com.project.EmployeeService.Model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class EmployeeRepository {


    private List<Employee> employees=new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }


    public List<Employee> getEmployees() {
        return employees;
    }


    public List<Employee> fetchByDepartmentId(Long id) {
        return employees.stream()
                .filter(e -> e.DepartmentId().equals(id))
                .toList();

    }



}
