package service.implement;

import company.TypeOfPackage;
import company.TypeOfVehicle;
import company.Vehicle;
import dao.CompanyDAO;
import dao.DriverDAO;
import dao.VehicleDAO;
import service.VehicleService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleImplementService implements VehicleService {
    private Scanner scanner;

    public VehicleImplementService() {
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void addVehicle() {
        Vehicle vehicle = new Vehicle();

        System.out.println("Select type of vehicle: ");
        System.out.println("1 - BUS");
        System.out.println("2 - VAN");
        System.out.println("3 - TRUCK");
        System.out.println("0 - Exit");

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                vehicle.setTypeOfVehicle(TypeOfVehicle.BUS);
                break;
            case 2:
                vehicle.setTypeOfVehicle(TypeOfVehicle.VAN);
                break;
            case 3:
                vehicle.setTypeOfVehicle(TypeOfVehicle.TRUCK);
                break;
            default:
                System.out.println("Nothing was chosen.");
                break;
        }

        System.out.println("Enter brand of vehicle:");
        vehicle.setBrand(scanner.nextLine());

        System.out.println("Enter destination of vehicle:");
        vehicle.setDestinationPoint(scanner.nextLine());

        System.out.println("Enter distance to destination:");
        vehicle.setDistance(BigDecimal.valueOf(Float.parseFloat(scanner.nextLine())));

        vehicle.setStartDate(LocalDate.now());

        //System.out.println("Enter end date:");
        vehicle.setEndDate(LocalDate.of(2001,12,1));

        System.out.println("Enter company id for vehicle:");
        vehicle.setCompany(CompanyDAO.getCompany(Long.parseLong(scanner.nextLine())));

        VehicleDAO.saveVehicle(vehicle);
        System.out.println("Vehicle -> " + vehicle.getId() + " " + vehicle.getBrand() + " was successfully added.");
    }

    @Override
    public void modifyVehicle() {
        System.out.println("Enter id of vehicle:");

        Vehicle vehicle = VehicleDAO.getVehicle(Long.parseLong(scanner.nextLine()));

        System.out.println("Choose what to modify:");
        System.out.println("1 -> type of vehicle");
        System.out.println("2 -> brand");
        System.out.println("3 -> destination");
        System.out.println("4 -> distance");
        System.out.println("5 -> End date");
        System.out.println("0 -> return");

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                System.out.println("Choose type of vehicle:");
                System.out.println("1 - BUS");
                System.out.println("2 - VAN");
                System.out.println("3 - TRUCK");
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        vehicle.setTypeOfVehicle(TypeOfVehicle.BUS);
                        break;
                    case 2:
                        vehicle.setTypeOfVehicle(TypeOfVehicle.VAN);
                        break;
                    case 3:
                        vehicle.setTypeOfVehicle(TypeOfVehicle.TRUCK);
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                vehicle.setBrand(scanner.nextLine());
                break;
            case 3:
                vehicle.setDestinationPoint(scanner.nextLine());
                break;
            case 4:
                vehicle.setDistance(BigDecimal.valueOf(Float.parseFloat(scanner.nextLine())));
                break;
            case 5:
                vehicle.setEndDate(LocalDate.parse(scanner.nextLine()));
                break;
            default:
                break;
        }

        VehicleDAO.saveOrUpdateVehicle(vehicle);
    }

    @Override
    public Vehicle selectVehicle() {
        System.out.println("Enter id of vehicle:");

        return VehicleDAO.getVehicle(Long.parseLong(scanner.nextLine()));
    }

    @Override
    public List<Vehicle> sortVehiclesByDistance() {

        System.out.println("Choose options: ");
        System.out.println("1 - ascending");
        System.out.println("2 - descending");
        System.out.println("0 - exit");

        List<Vehicle> vehicles = new ArrayList<>();

        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                vehicles = VehicleDAO.VehicleDestinationAscending();
                break;
            case 2:
                vehicles = VehicleDAO.VehicleDestinationDescending();
                break;
            default:
                System.out.println("Nothing will be done to the driver table.");
                break;
        }

        return vehicles;
    }

    @Override
    public void removeVehicle() {
        System.out.println("Enter id of vehicle:");
        Vehicle vehicle = VehicleDAO.getVehicle(Long.parseLong(scanner.nextLine()));
        VehicleDAO.deleteVehicle(vehicle);
        System.out.println("Vehicle -> " + vehicle.getId() + " " + vehicle.getBrand() + " was successfully removed.");
    }
}
