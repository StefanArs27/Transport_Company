package people;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;


@MappedSuperclass
public  class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Pattern(regexp = "\\b[A-Z][a-z]* [A-Z][a-z]*( [A-Z])?\\b", message = "first and last name should start with capital letter")
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Positive(message = "age cannot be of negative value")
    @Column(name = "age", nullable = false)
    private int age;

    @Size(min = 10, max = 10, message = "phone number must be 10 digits")
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

    @Override
    public String toString() {
        return "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'';
    }
}
