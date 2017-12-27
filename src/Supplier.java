import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
class Supplier extends Company {

    private String bankAccountNumber;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.PERSIST)
    private List<Product> productSet;

    Supplier(String companyName, String street, String city, String zipCode, String bankAccountNumber) {
        super(companyName, street, city, zipCode);
        this.bankAccountNumber = bankAccountNumber;
    }

    Supplier() {
    }

    void setProductSet(List<Product> productSet) {
        this.productSet = productSet;
    }

    public List<Product> getProductSet() {
        return productSet;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "bankAccountNumber='" + bankAccountNumber + '\'' +
                ", productSet=" + productSet +
                '}';
    }
}
