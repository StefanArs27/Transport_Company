package people;

import company.Company;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Employee")
public class Employee extends Person {
    @Column(name = "salary")
    private BigDecimal salary;

    //foreign key
    @ManyToOne
    @JoinColumn(name = "company")
    private Company company;

    public Employee() {super();}

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

    public BigDecimal getSalary() {
        return salary;
    }
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }


    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                ", salary=" + salary +
                "}" ;
    }
}
