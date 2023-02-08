package company;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    //Will I need data like fuel and covered distance
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private TypeOfVehicle typeOfVehicle;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "destinationPoint")
    private String destinationPoint;

    @Column(name = "distance")
    private BigDecimal distance;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;

    //foreign key
    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "vehicle")
    private List<Package> Packages;

    public Vehicle() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public TypeOfVehicle getTypeOfVehicle() {
        return typeOfVehicle;
    }
    public void setTypeOfVehicle(TypeOfVehicle typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }
    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public BigDecimal getDistance() {
        return distance;
    }
    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }

}