package service;

import company.Vehicle;

import java.util.List;

public interface VehicleService {

    void addVehicle();

    void modifyVehicle();
    Vehicle selectVehicle();
    List<Vehicle> sortVehiclesByDistance();

    void removeVehicle();
}
