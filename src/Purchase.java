import javax.persistence.*;
import java.util.List;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int purchaseNumber;

    private int quantity;

    @ManyToMany(mappedBy = "purchases")
    private List<Product> products;

    public Purchase(int quantity) {
        this.quantity = quantity;
    }

    public Purchase() {
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getTransactionNumber() {
        return purchaseNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "transactionNumber=" + purchaseNumber +
                ", quantity=" + quantity +
                '}';
    }
}
