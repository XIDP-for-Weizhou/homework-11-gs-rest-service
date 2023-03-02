package com.example.restservice.Controller;

import com.example.restservice.Date.CompanyEntity;
import com.example.restservice.Date.EmployeeEntity;
import com.example.restservice.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("/companies")
    public Map<Long, CompanyEntity> fetchAllCompanies() {
        return companyService.findAll();
    }

    @GetMapping("/companies/{companyId}")
    public CompanyEntity fetchCompanyByCompanyId(@PathVariable Long companyId) {
        return companyService.findById(companyId);
    }

    @GetMapping("/companies/{companyId}/employees")
    public List<EmployeeEntity> fetchAllEmployeesByCompanyId(@PathVariable Long companyId) {
        return companyService.findAllEmployees(companyId);
    }

    @GetMapping("/companies/page/{pageNem}/pageSize/{pageSize}")
    public List<CompanyEntity> fetchCompanyByPage(@PathVariable int pageNem, @PathVariable int pageSize) {
        return companyService.findByPage(pageNem, pageSize);
    }

    @PostMapping("/companies")
    public CompanyEntity createCompany(@RequestBody CompanyEntity company) {
        return companyService.create(company);
    }

    @PutMapping("/companies/{companyId}")
    public boolean updateCompany(@PathVariable Long companyId, @RequestBody CompanyEntity company) {
        return companyService.update(companyId, company);
    }

    @DeleteMapping("/companies/{companyId}")
    public boolean deleteCompany(@PathVariable Long companyId) {
        return companyService.delete(companyId);
    }

}
