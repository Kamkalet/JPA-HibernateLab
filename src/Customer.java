import javax.persistence.Entity;

@Entity
public class Customer extends Company{

    private float discount;

    public Customer(String companyName, String street, String city, String zipCode, float discount) {
        super(companyName, street, city, zipCode);
        this.discount = discount;
    }

    Customer(){

    }

    public float getDiscount() {
        return discount;
    }
}
