package com.codebay.goldeneye;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codebay.goldeneye.model.Company;
import com.codebay.goldeneye.model.Employee;
import com.codebay.goldeneye.model.Office;

@Controller
public class WebController {  
    public final String separator = ".";
    public final String at = "@";
    public final String domain = "goldeneye.com";

    @GetMapping("/")
    public String index(Model model) 
    {
        Company.clearOffices();
        new Office("Milan",new ArrayList<>(Arrays.asList("Desing", "Business", "Advertising")));
        new Office("Spain",new ArrayList<>(Arrays.asList("Research & development", "Business")));
        new Office("New York",new ArrayList<>(Arrays.asList("Business", "Advertising")));

        model.addAttribute("offices", Company.getOffices());

        return "index";
    }

    @PostMapping(value = "/") 
    public String emailGeneratorSubmit(@ModelAttribute Employee employee, Model model) 
    {;    

        String generatedEmail = "";
        if (!employee.getName().isEmpty() && !employee.getSurname().isEmpty() &&
        !employee.getOffice().isEmpty() && !employee.getDepartment().isEmpty()) {
            if (departmentCombinationValidator(employee.getOffice(), employee.getDepartment())) {
            generatedEmail += "The generated email is: ";
            generatedEmail +=  employee.getName().toLowerCase().charAt(0) +
            employee.getSurname().toLowerCase().replaceAll(" ", "") + 
            separator +
            employee.getDepartment().replaceAll(" ", "").toLowerCase() +
            at +
            employee.getOffice().toLowerCase().replaceAll(" ", "") +
            separator +
            domain;
            
            // Set your api call here to strip undesired characters

            } else {
                generatedEmail += "Error generating email: bad office|department combination";
            }
        } else {
            generatedEmail += "Error generating email: some parametters were not filled";
        }

        model.addAttribute("generatedEmail", generatedEmail);
        model.addAttribute("offices", Company.getOffices());

    
        return "index";
    }

    public boolean departmentCombinationValidator(String office, String department) 
    {
        ArrayList<String> milan = new ArrayList<>(Arrays.asList("Desing", "Business", "Advertising"));
        ArrayList<String> spain = new ArrayList<>(Arrays.asList("Research & development", "Business"));
        ArrayList<String> newYork = new ArrayList<>(Arrays.asList("Business", "Advertising"));
        if(office.equals("Milan")) {
            return milan.contains(department);
        } else if (office.equals("Spain")) {
            return spain.contains(department);
        } else if (office.equals("New York")){
            return newYork.contains(department);
        } else {
            return false;
        }
    }
}