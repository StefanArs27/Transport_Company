package people;

import company.Company;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "driver")
public class Driver extends Person {
    @Enumerated(EnumType.STRING)
    @Column(name = "qualification")
    private DriverQualification qualification;

    @ManyToOne
    @JoinColumn(name = "company")
    private Company company;

    @Column(name = "salary")
    private BigDecimal salary;


    public Driver() {
        super();
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }

    @Override
    public void setFullName(String name) {
        super.setFullName(name);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }


    public DriverQualification getDriverQualification() {
        return qualification;
    }

    public void setDriverQualification(DriverQualification qualification) {
        this.qualification = qualification;
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
