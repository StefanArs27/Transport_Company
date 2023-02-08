package dto;

import people.Employee;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CompanyDTO {

    private String name;
    private String address;

    public CompanyDTO() {
    }

    public CompanyDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
