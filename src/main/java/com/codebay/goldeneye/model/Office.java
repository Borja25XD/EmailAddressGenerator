package com.codebay.goldeneye.model;

import java.util.ArrayList;

public class Office {
    public String name;
    public ArrayList<String> departments;

    public Office(String name, ArrayList<String> departments) 
    {
        this.setName(name);
        this.setDepartments(departments);
        Company.addOffice(this);
    }

    public String getName() 
    {
        return name;
    }

    public ArrayList<String> getDepartments() 
    {
        return departments;
    }
    
    public void setName(String name) 
    {
        this.name = name;
    }

    public void setDepartments(ArrayList<String> departments) 
    {
        this.departments = departments;
    }

    @Override
    public String toString() 
    {
        return this.getName();
    }
}
