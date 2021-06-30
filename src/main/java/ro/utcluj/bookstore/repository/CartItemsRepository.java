package ro.utcluj.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.utcluj.bookstore.model.CartItems;

@Repository
public interface CartItemsRepository extends CrudRepository<CartItems,Long> {
}
