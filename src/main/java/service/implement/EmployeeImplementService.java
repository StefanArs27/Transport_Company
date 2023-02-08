package service.implement;

import dao.CompanyDAO;
import dao.EmployeeDAO;
import people.Employee;
import service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeImplementService implements EmployeeService {

    private Scanner scanner;

    public EmployeeImplementService() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void addEmployee() {
        Employee employee = new Employee();
        System.out.println("Enter full name: ");
        employee.setFullName(scanner.nextLine());

        System.out.println("Enter age: ");
        employee.setAge(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter phone number: ");
        employee.setPhoneNumber(scanner.nextLine());

        System.out.println("Enter salary: ");
        employee.setPhoneNumber(scanner.nextLine());

        EmployeeDAO.saveEmployee(employee);
    }

    @Override
    public Employee selectEmployee() {
        System.out.println("Enter id of employee:");
        System.out.println(EmployeeDAO.getEmployee(Long.parseLong(scanner.nextLine())) + " was selected");
        return EmployeeDAO.getEmployee(Long.parseLong(scanner.nextLine()));
    }

    @Override
    public List<Employee> sortEmployeesBySalary() {
        List<Employee> employees = new ArrayList<>();

        System.out.println("Choose options: ");
        System.out.println("1 - ascending");
        System.out.println("2 - descending");
        System.out.println("0 - exit");

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                employees = EmployeeDAO.EmployeesBySalaryAsc();
                break;
            case 2:
                employees = EmployeeDAO.EmployeesBySalaryDesc();
                break;
            default:
                System.out.println("Nothing will be done to the employee table.");
                break;
        }
        return employees;
    }

    @Override
    public void fireEmployee() {
        Employee employee;

        System.out.println("Enter the id of the employee you want to remove: ");
        employee = EmployeeDAO.getEmployee(Long.parseLong(scanner.nextLine()));

        System.out.println("Employee -> " + employee.getId() + " " + employee.getFullName() + " is removed.");
        EmployeeDAO.deleteEmployee(employee);
    }
}
