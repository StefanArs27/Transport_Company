package company;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
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

    @NotBlank(message = "brand should not be empty")
    @Column(name = "brand", nullable = false)
    private String brand;

    @NotBlank(message = "destination point should not be empty")
    @Column(name = "destinationPoint")
    private String destinationPoint;

    @Positive(message = "distance cannot be of negative value")
    @Column(name = "distance")
    private BigDecimal distance;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Pattern(regexp = "^\\\\d{4}-\\\\d{2}-\\\\d{2}$", message = "end date should follow the specific pattern: yyyy-mm-dd")
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

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", typeOfVehicle=" + typeOfVehicle +
                ", brand='" + brand + '\'' +
                ", destinationPoint='" + destinationPoint + '\'' +
                ", distance=" + distance +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}