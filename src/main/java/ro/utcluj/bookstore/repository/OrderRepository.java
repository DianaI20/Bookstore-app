package ro.utcluj.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import ro.utcluj.bookstore.model.Order;

public interface OrderRepository extends CrudRepository <Order,Long> {
}
