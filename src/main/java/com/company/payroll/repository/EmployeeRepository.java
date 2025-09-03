package com.company.payroll.repository;

import com.company.payroll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // You can add custom query methods later if needed
    // Example: List<Employee> findByDepartment(String department);
}
