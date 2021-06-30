package ro.utcluj.bookstore.repository;


import org.springframework.data.repository.CrudRepository;
import ro.utcluj.bookstore.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
