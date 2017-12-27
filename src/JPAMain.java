import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JPAMain {

    public static void main(final String[] args) throws Exception {

        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("myDatabaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
//object creation
        Product product1 = new Product("dzwig", 65456);
        Product product2 = new Product("świeżak z biedronki", 50);
        Product product3 = new Product("paprika", 100);
        Category category1 = new Category("zabawki");
        Category category2 = new Category("warzywa");
        Supplier supplier1 = new Supplier("Biedronka", "Biedronkowa", "Biedronki", "32=098");

        //for suppliers binding
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product3);
        products.add(product2);
        for(Product product : products){
            product.setSupplier(supplier1);
        }
        supplier1.setProductSet(products);

        //categories binding
        List<Product> products2 = new ArrayList<>();
        products2.add(product1);
        products2.add(product2);
        for(Product product : products2){
            product.setCategory(category1);
        }
        product3.setCategory(category2);
        category1.setProducts(products2);

        List<Product> products3 = new ArrayList<>();
        products3.add(product3);
        category2.setProducts(products3);

        // purchases
        List<Purchase> purchases = new ArrayList<>();
        List<Purchase> transactions2 = new ArrayList<>();
        List<Purchase> transactions3 = new ArrayList<>();
        Purchase purchase1 = new Purchase(44);
        Purchase purchase2 = new Purchase(11);
        Purchase purchase3 = new Purchase(13);
        purchases.add(purchase1);
        transactions2.add(purchase1);
        transactions2.add(purchase2);
        transactions3.add(purchase1);
        transactions3.add(purchase2);
        transactions3.add(purchase3);
        product1.setPurchases(purchases);
        product2.setPurchases(transactions2);
        product3.setPurchases(transactions3);
        purchase1.setProducts(products);
        purchase2.setProducts(new ArrayList<>(Arrays.asList(product2,product3)));
        purchase3.setProducts(new ArrayList<>(Collections.singletonList(product1)));


        try {


            em.persist(supplier1);

            // cascading..
//            em.persist(product1);
//            em.persist(product2);
//            em.persist(product3);


            em.persist(category1);
            em.persist(category2);

            em.persist(purchase1);
            em.persist(purchase2);
            em.persist(purchase3);

            etx.commit();

        } finally {
            em.close();
        }
    }
}