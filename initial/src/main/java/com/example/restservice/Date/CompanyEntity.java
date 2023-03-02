package com.example.restservice.Date;

public class CompanyEntity {

    private Long id;

    private String name;

    private String location;

    public CompanyEntity(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

}
