import javax.persistence.*;
import java.util.List;

@Entity
class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String productName;
    private int unitsInStock;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="SUPPLIER_FK")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name="CATEGORY_FK")
    private Category category;

    @ManyToMany
    private List<Purchase> purchases;

    public Product(String productName, int unitsInStock) {
        this.productName = productName;
        this.unitsInStock = unitsInStock;
    }

    public Product() {
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", unitsInStock=" + unitsInStock +
                ", supplier=" + supplier.getCompanyName() +
                ", category=" + category.getName() +
                ", transaction=" + purchases +
                '}';
    }
}
