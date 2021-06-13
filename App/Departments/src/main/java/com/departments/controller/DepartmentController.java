package com.departments.controller;

import com.departments.service.DepartmentService;
import com.departments.entity.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/departments")
@Slf4j
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Department saved :" + department);
        return departmentService.saveDepartment(department);

    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("finding Department.......");
        return departmentService.findByDepartmentId(departmentId);

    }
}
