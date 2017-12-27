import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SecondaryTable(name="ADDRESS")
abstract class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String companyName;
    @Column(table="ADDRESS")
    private String street;
    @Column(table="ADDRESS")
    private String city;
    @Column(table="ADDRESS")
    private String zipCode;

    public Company(String companyName, String street, String city, String zipCode) {
        this.companyName = companyName;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    public Company() {
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCompanyName() {
        return companyName;
    }

}
