package dto;

import company.TypeOfVehicle;
import java.time.LocalDate;

public class VehicleDTO {
    private TypeOfVehicle typeOfVehicle;
    private String brand;
    private String startingPoint;
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;

    public VehicleDTO(TypeOfVehicle typeOfVehicle, String brand, String startingPoint, String destination, LocalDate startDate, LocalDate endDate) {
        this.typeOfVehicle = typeOfVehicle;
        this.brand = brand;
        this.startingPoint = startingPoint;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TypeOfVehicle getTypeOfVehicle() {
        return this.typeOfVehicle;
    }

    public void setTypeOfVehicle(TypeOfVehicle typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStartingPoint() {
        return this.startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String toString() {
        return "VehicleDTO{typeOfVehicle=" + this.typeOfVehicle + ", brand='" + this.brand + "', startingPoint='" + this.startingPoint + "', destination='" + this.destination + "', startDate=" + this.startDate + ", endDate=" + this.endDate + "}";
    }
}
