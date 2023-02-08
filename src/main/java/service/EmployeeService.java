package service;

import people.Employee;

import java.util.List;

public interface EmployeeService {

    void addEmployee();

    Employee selectEmployee();
    List<Employee> sortEmployeesBySalary();

    void fireEmployee();
}
