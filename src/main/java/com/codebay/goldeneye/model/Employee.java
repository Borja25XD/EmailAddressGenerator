package com.codebay.goldeneye.model;

import java.util.Set;

public class Employee {
    private String name;
    private String surname;
    private String office;
    private String department;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getOffice() {
        return office;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
