package service.implement;

import dao.DriverDAO;
import people.Driver;
import people.DriverQualification;
import service.DriverService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverImplementService implements DriverService {

    private Scanner scanner;

    public DriverImplementService() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void addDriver() {
        Driver driver = new Driver();
        System.out.println("\nEnter full name: ");
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
                break;
        }

        System.out.println("Enter salary: ");
        driver.setSalary(BigDecimal.valueOf(Long.parseLong(scanner.nextLine())));

        DriverDAO.saveDriver(driver);
        System.out.println("Driver " + driver.getId() + " " + driver.getFullName() + " was successfully added.");
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }

    @Override
    public void modifyDriver() {
        System.out.println("\nEnter id of driver:");
        Driver driver = DriverDAO.getDriver(Long.parseLong(scanner.nextLine()));

        System.out.println("Choose option to modify:");
        System.out.println("1 -> name");
        System.out.println("2 -> age");
        System.out.println("3 -> phone number");
        System.out.println("4 -> driver qualification");
        System.out.println("5 -> salary");
        System.out.println("0 -> return");

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                System.out.println("Enter new name:");
                driver.setFullName(scanner.nextLine());
                break;
            case 2:
                System.out.println("Enter new age:");
                driver.setAge(Integer.parseInt(scanner.nextLine()));
                break;
            case 3:
                System.out.println("Enter new phone number:");
                driver.setPhoneNumber(scanner.nextLine());
                break;
            case 4:
                System.out.println("Choose new driver qualification:");
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
                        break;
                }
            case 5:
                System.out.println("Enter new salary:");
                driver.setSalary(BigDecimal.valueOf(Float.parseFloat(scanner.nextLine())));
                break;
            default:
                break;
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }

    @Override
    public void selectDriver() {
        System.out.println("\nEnter id of driver:");
        System.out.println(DriverDAO.getDriver(Long.parseLong(scanner.nextLine())) + " was selected.");
    }

    @Override
    public void readDrivers() {
        List<Driver> driverList = DriverDAO.readDrivers();
        System.out.println("\nList of drivers:");
        driverList.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }

    @Override
    public void sortDriversByQualification() {
        List<Driver> drivers = new ArrayList<>();

        System.out.println("\nChoose options: ");
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

        System.out.println("Sorted list of drivers:");
        drivers.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }

    @Override
    public void sortDriversBySalary() {
        List<Driver> drivers = new ArrayList<>();

        System.out.println("\nChoose options: ");
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
        System.out.println("Sorted list of drivers:");
        drivers.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }

    @Override
    public void fireDriver() {
        System.out.println("\nSelect driver ID: ");
        Driver driver = DriverDAO.getDriver(Long.parseLong(scanner.nextLine()));
        DriverDAO.deleteDriver(driver);
        System.out.println("Driver -> " + driver.getId() + " " + driver.getFullName() + " was successfully removed.");
        System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
    }
}
