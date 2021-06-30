package ro.utcluj.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity{

    @Column(name ="customer_id")
     private Long customerId;

    @Column(name = "shopping_cart")
    private Long  shoppingCart;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Long shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
