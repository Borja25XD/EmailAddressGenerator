package com.codebay.goldeneye.model;

import java.util.ArrayList;

public class Company {
    public static ArrayList<Office> offices = new ArrayList<>();

    public static void addOffice(Office office) 
    {
        Company.offices.add(office);
    }

    public static ArrayList<Office> getOffices() 
    {
        return offices;
    }

    public static void clearOffices() 
    {
        Company.offices = new ArrayList<>();
    }
    
}
