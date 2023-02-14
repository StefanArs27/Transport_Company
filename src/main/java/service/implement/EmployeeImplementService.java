package service.implement;

import company.Company;
import dao.CompanyDAO;
import dao.EmployeeDAO;
import people.Employee;
import service.EmployeeService;

import java.math.BigDecimal;
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
        System.out.println("\nEnter full name: ");
        employee.setFullName(scanner.nextLine());

        System.out.println("Enter age: ");
        employee.setAge(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter phone number: ");
        employee.setPhoneNumber(scanner.nextLine());

        System.out.println("Enter salary: ");
        employee.setSalary(BigDecimal.valueOf(Float.parseFloat(scanner.nextLine())));

        EmployeeDAO.saveEmployee(employee);
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }

    @Override
    public void modifyEmployee() {
        System.out.println("\nEnter id of employee:");
        Employee employee = EmployeeDAO.getEmployee(Long.parseLong(scanner.nextLine()));

        System.out.println("Choose what to modify:");
        System.out.println("1 -> name");
        System.out.println("2 -> age");
        System.out.println("3 -> phone number");
        System.out.println("4 -> salary");
        System.out.println("0 -> return");

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                System.out.println("Enter new name:");
                employee.setFullName(scanner.nextLine());
                break;
            case 2:
                System.out.println("Enter new age:");
                employee.setAge(Integer.parseInt(scanner.nextLine()));
                break;
            case 3:
                System.out.println("Enter new phone number:");
                employee.setPhoneNumber(scanner.nextLine());
                break;
            case 4:
                System.out.println("Enter new salary:");
                employee.setSalary(BigDecimal.valueOf(Float.parseFloat(scanner.nextLine())));
            default:
                break;
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }

    @Override
    public void selectEmployee() {
        System.out.println("\nEnter id of employee:");
        System.out.println(EmployeeDAO.getEmployee(Long.parseLong(scanner.nextLine())) + " was selected");
    }

    @Override
    public void readEmployees() {
    List<Employee> employeeList = EmployeeDAO.readEmployees();

        System.out.println("\nList of employees:");
        employeeList.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }

    @Override
    public void sortEmployeesBySalary() {
        List<Employee> employees = new ArrayList<>();

        System.out.println("\nChoose options: ");
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
        System.out.println("Sorted list of employees:");
        employees.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }

    @Override
    public void fireEmployee() {
        Employee employee;

        System.out.println("\nEnter the id of the employee you want to remove: ");
        employee = EmployeeDAO.getEmployee(Long.parseLong(scanner.nextLine()));

        System.out.println("Employee -> " + employee.getId() + " " + employee.getFullName() + " is removed.");
        EmployeeDAO.deleteEmployee(employee);
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }
}
