package people;

import company.Company;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client extends Person{
    @ManyToOne
    private Company company;

    public Client() {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return
                ", company=" + company +
                '}';
    }

    //many to many with company
}
