package ro.utcluj.bookstore.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart_items")
public class CartItems extends AbstractEntity {

   @Column(name = "book")
    private Long bookId;

   @Column(name = "shopping_cart")
    private Long shoppingCartId;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }
}
