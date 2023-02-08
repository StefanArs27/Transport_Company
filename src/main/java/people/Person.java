package people;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@MappedSuperclass
public  class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "age", nullable = false)
    private int age;


    @Column(name = "phone_number",length = 10)
    private String phoneNumber;

    public Person() {
    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
