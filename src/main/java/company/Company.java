package company;

import people.Client;
import people.Driver;
import people.Employee;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "Company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "earnings")
    private BigDecimal earnings;

    @OneToMany(mappedBy = "company")
    private List<Client> clients;

    //foreign key
    @OneToMany(mappedBy = "company")
    private List<Employee> employees;

    //foreign key
    @OneToMany(mappedBy = "company")
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "company")
    private List<Driver> drivers;

    //will need a list of packages
    public Company() {
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Client> getClients() {
        return clients;
    }
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public BigDecimal getEarnings() {
        return earnings;
    }
    public void setEarnings(BigDecimal earnings) {
        this.earnings = earnings;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }
    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    //    @Override
//    public String toString() {
//        return "Company{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", earnings=" + earnings +
//                '}';
//    }
}
