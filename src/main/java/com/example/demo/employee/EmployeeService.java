package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElse(null);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(int id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        }
        return null;
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}

