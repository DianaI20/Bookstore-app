package ro.utcluj.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import ro.utcluj.bookstore.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
