package service;

public interface DriverService {

    void addDriver();
    void modifyDriver();
    void selectDriver();
    void readDrivers();
    void sortDriversByQualification();
    void sortDriversBySalary();

    void fireDriver();
}
