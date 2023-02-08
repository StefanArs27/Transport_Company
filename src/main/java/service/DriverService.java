package service;

import company.Company;
import people.Driver;

import java.util.List;

public interface DriverService {

    void addDriver();

    Driver selectDriver();
    List<Driver> sortDriversByQualification();
    List<Driver> sortDriversBySalary();

    void fireDriver();
}
