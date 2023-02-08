package company;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Package")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    private TypeOfPackage typeOfPackage;

    @Column(name = "packageWeight")
    private BigDecimal packageWeight;

    @Column(name = "packagePrice")
    private BigDecimal packagePrice;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    public Package() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeOfPackage getTypeOfPackage() {
        return typeOfPackage;
    }

    public void setTypeOfPackage(TypeOfPackage typeOfPackage) {
        this.typeOfPackage = typeOfPackage;
    }

    public BigDecimal getPackageWeight() {
        return packageWeight;
    }

    public void setPackageWeight(BigDecimal packageWeight) {
        this.packageWeight = packageWeight;
    }

    public BigDecimal getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(BigDecimal packagePrice) {
        this.packagePrice = packagePrice;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeOfPackage=" + typeOfPackage +
                ", packageWeight=" + packageWeight +
                ", packagePrice=" + packagePrice +
                '}';
    }
}
