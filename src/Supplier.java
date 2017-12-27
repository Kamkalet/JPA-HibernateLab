import javax.persistence.*;
import java.util.List;

@Entity
class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String companyName;
    private String street;
    private String city;

    @OneToMany(mappedBy = "supplier")
    private List<Product> productSet;

    public Supplier(String companyName, String street, String city) {
        this.companyName = companyName;
        this.street = street;
        this.city = city;
    }

    public Supplier() {
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

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", productSet=" + productSet +
                '}';
    }
}
