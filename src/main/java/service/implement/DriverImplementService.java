package service.implement;

import company.Company;
import dao.DriverDAO;
import people.Driver;
import people.DriverQualification;
import service.DriverService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DriverImplementService implements DriverService {

    private Scanner scanner;

    public DriverImplementService() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void addDriver() {
        Driver driver = new Driver();
        System.out.println("Enter full name: ");
        driver.setFullName(scanner.nextLine());

        System.out.println("Enter age: ");
        driver.setAge(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter phone number: ");
        driver.setPhoneNumber(scanner.nextLine());

        System.out.println("Select driver qualification: ");
        System.out.println("1 - bus");
        System.out.println("2 - dangerous-packages");
        System.out.println("3 - truck");
        System.out.println("4 - van");
        System.out.println("0 - Exit");

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                driver.setDriverQualification(DriverQualification.BUS);
                break;
            case 2:
                driver.setDriverQualification(DriverQualification.SPECIAL_PACKAGES);
                break;
            case 3:
                driver.setDriverQualification(DriverQualification.TRUCK);
                break;
            case 4:
                driver.setDriverQualification(DriverQualification.VAN);
                break;
            default:
                System.out.println("Nothing was chosen.");
                break;
        }

        System.out.println("Enter salary: ");
        driver.setSalary(BigDecimal.valueOf(Long.parseLong(scanner.nextLine())));

        DriverDAO.saveDriver(driver);
        System.out.println("Driver " + driver.getId() + " " + driver.getFullName() + " was successfully added.");
    }

    @Override
    public Driver selectDriver() {
        System.out.println("Enter id of driver:");
        System.out.println(DriverDAO.getDriver(Long.parseLong(scanner.nextLine())) + " was selected.");
        return DriverDAO.getDriver(Long.parseLong(scanner.nextLine()));
    }

    @Override
    public List<Driver> sortDriversByQualification() {
        List<Driver> drivers = new ArrayList<>();

        System.out.println("Choose options: ");
        System.out.println("1 - ascending");
        System.out.println("2 - descending");
        System.out.println("0 - exit");

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                drivers = DriverDAO.driversByQualificationAsc();
                break;
            case 2:
                drivers = DriverDAO.driversByQualificationDesc();
                break;
            default:
                System.out.println("Nothing will be done to the driver table.");
                break;
        }

        return drivers;
    }

    @Override
    public List<Driver> sortDriversBySalary() {
        List<Driver> drivers = new ArrayList<>();

        System.out.println("Choose options: ");
        System.out.println("1 - ascending");
        System.out.println("2 - descending");
        System.out.println("0 - exit");

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                drivers = DriverDAO.driversBySalaryAsc();
                break;
            case 2:
                drivers = DriverDAO.driversBySalaryDesc();
                break;
            default:
                System.out.println("Nothing will be done to the driver table.");
                break;
        }

        return drivers;
    }

    @Override
    public void fireDriver() {
        System.out.println("Select driver ID: ");
        Driver driver = DriverDAO.getDriver(Long.parseLong(scanner.nextLine()));
        DriverDAO.deleteDriver(driver);
        System.out.println("Driver -> " + driver.getId() + " " + driver.getFullName() + " was successfully removed.");
    }
}
