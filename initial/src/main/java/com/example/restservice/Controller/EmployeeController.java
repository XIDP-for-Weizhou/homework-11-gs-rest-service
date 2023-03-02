package com.example.restservice.Controller;

import com.example.restservice.Date.EmployeeEntity;
import com.example.restservice.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public HashMap<Long, EmployeeEntity> fetchAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employId}")
    public EmployeeEntity fetchEmployeeByEmployeeId(@PathVariable Long employId) {
        return employeeService.findById(employId);
    }

    @GetMapping("/employees/male")
    public List<EmployeeEntity> fetchEmployeesByGenger() {
        return employeeService.findEmployeesByGender("male");
    }

    @GetMapping("/employees/page/{pageNem}/pageSize/{pageSize}")
    public List<EmployeeEntity> fetchCompanyByPage(@PathVariable int pageNem, @PathVariable int pageSize) {
        return employeeService.findByPage(pageNem, pageSize);
    }

    @PostMapping("/employees")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.create(employee);
    }

    @PutMapping("/employees/{employId}")
    public boolean updateEmployee(@PathVariable Long employId, @RequestBody EmployeeEntity employee) {
        return employeeService.update(employId, employee);
    }

    @DeleteMapping("/employees/{employId}")
    public boolean deleteEmployee(@PathVariable Long employId) {
        return employeeService.delete(employId);
    }

}
