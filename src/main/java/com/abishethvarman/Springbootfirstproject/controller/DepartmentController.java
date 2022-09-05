package com.abishethvarman.Springbootfirstproject.controller;


import com.abishethvarman.Springbootfirstproject.entity.Department;
import com.abishethvarman.Springbootfirstproject.service.DepartmentService;
import com.abishethvarman.Springbootfirstproject.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments") //Sending data to the db
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        //        DepartmentService service = new DepartmentServiceImpl();
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments") //Getting data from db
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartment of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}") //Getting particular data of the db bsed on ID
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}") //Delete data from db particular on id
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
