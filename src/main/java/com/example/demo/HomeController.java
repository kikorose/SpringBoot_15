package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String index(Model model){
//        create a employee
        Employee employee = new Employee();
        employee.setName("Stephen Bullock");
         employee.setSsn("555-12-1234");

//        create a laptop
       Laptop laptop = new Laptop();
       laptop.setBrand("Dell");
       laptop.setModel("Latitude XL");

//        add the laotop to the employee
        employee.setLaptop(laptop);


//       save employee to database
        employeeRepository.save(employee);

//        grab all the employees from the database and send them to the template
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }
}

