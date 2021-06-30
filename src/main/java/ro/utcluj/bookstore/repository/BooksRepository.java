package ro.utcluj.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import ro.utcluj.bookstore.model.Book;

public interface BooksRepository  extends CrudRepository<Book, Long> {
}
