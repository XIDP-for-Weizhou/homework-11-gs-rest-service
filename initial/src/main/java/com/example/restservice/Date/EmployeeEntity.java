package com.example.restservice.Date;

public class EmployeeEntity {
    private Long id;

    private Long companyId;

    private String name;

    private String gender;
    private int age;

    public EmployeeEntity(Long id, Long companyId, String name, String gender, int age) {
        this.id = id;
        this.companyId = companyId;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
