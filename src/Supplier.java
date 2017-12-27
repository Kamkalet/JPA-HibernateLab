import javax.persistence.*;
import java.util.List;

@Entity
@SecondaryTable(name="ADDRESS")
class Supplier {

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

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.PERSIST)
    private List<Product> productSet;

    public Supplier(String companyName, String street, String city, String zipCode) {
        this.companyName = companyName;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    public Supplier() {
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

    public void setProductSet(List<Product> productSet) {
        this.productSet = productSet;
    }

    public List<Product> getProductSet() {
        return productSet;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", productSet=" + productSet +
                '}';
    }
}
