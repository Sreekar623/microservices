package com.project.DepartmentService.Repository;


import com.project.DepartmentService.Model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentServiceRepository {

    private List<Department> departments=new ArrayList<>();

    public Department addDepartment(Department department) {
        departments.add(department);
        return department;
    }


    public List<Department> getDepartments() {
        return departments;
    }
    public Department fetchById(Long id) {
        return departments.stream().filter(d->d.getId().equals(id)).findFirst().orElseThrow();
    }


}
