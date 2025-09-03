//package com.company.payroll;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class EmployeePayrollSystemApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(EmployeePayrollSystemApplication.class, args);
//	}
//
//}
package com.company.payroll;

import com.company.payroll.entity.Employee;
import com.company.payroll.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeePayrollSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeePayrollSystemApplication.class, args);
    }

    // Test Repositories at Startup
    @Bean
    public CommandLineRunner demo(EmployeeRepository employeeRepository) {
        return (args) -> {
            // Save an employee
        	Employee emp = new Employee();
        	emp.setName("apple");
        	emp.setEmail("tejas@example.com");
        	emp.setPosition("Developer");
        	emp.setSalary(80000.0);
        	employeeRepository.save(emp);
        	Employee emp1 = new Employee();
        	emp1.setName("patil");
        	emp1.setEmail("sakshi@example.com");
        	emp1.setPosition("Designer");
        	emp1.setSalary(90000.0);
        	employeeRepository.save(emp1);



            // Fetch all employees
            System.out.println("Employees in DB:");
            employeeRepository.findAll().forEach(System.out::println);
        };
    }
}

