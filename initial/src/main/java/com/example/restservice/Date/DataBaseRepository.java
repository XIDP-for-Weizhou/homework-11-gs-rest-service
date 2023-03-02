package com.example.restservice.Date;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class DataBaseRepository {
    private HashMap<Long, CompanyEntity> companyDataBase = new HashMap<>();
    private HashMap<Long, EmployeeEntity> employeeDataBase = new HashMap<>();


    public void init() {
        CompanyEntity companyEntity1 = new CompanyEntity(1L, "Thoughtworks", "西安");
        CompanyEntity companyEntity2 = new CompanyEntity(2L, "Bilibili", "上海");
        companyDataBase.put(companyEntity1.getId(), companyEntity1);
        companyDataBase.put(companyEntity2.getId(), companyEntity2);

        EmployeeEntity employeeEntity1 = new EmployeeEntity(1L, 1L, "张三", "male", 33);
        EmployeeEntity employeeEntity2 = new EmployeeEntity(2L, 1L, "李四", "male", 18);
        EmployeeEntity employeeEntity3 = new EmployeeEntity(3L, 1L, "张逸", "female", 18);
        EmployeeEntity employeeEntity4 = new EmployeeEntity(4L, 2L, "张二", "male", 33);
        EmployeeEntity employeeEntity5 = new EmployeeEntity(5L, 2L, "李五", "male", 20);
        EmployeeEntity employeeEntity6 = new EmployeeEntity(6L, 2L, "王麻子", "female", 22);
        employeeDataBase.put(employeeEntity1.getId(),employeeEntity1);
        employeeDataBase.put(employeeEntity2.getId(),employeeEntity2);
        employeeDataBase.put(employeeEntity3.getId(),employeeEntity3);
        employeeDataBase.put(employeeEntity4.getId(),employeeEntity4);
        employeeDataBase.put(employeeEntity5.getId(),employeeEntity5);
        employeeDataBase.put(employeeEntity6.getId(),employeeEntity6);

    }

    public HashMap<Long, CompanyEntity> getCompanyDataBase() {
        return companyDataBase;
    }

    public HashMap<Long, EmployeeEntity> getEmployeeDataBase() {
        return employeeDataBase;
    }
}
