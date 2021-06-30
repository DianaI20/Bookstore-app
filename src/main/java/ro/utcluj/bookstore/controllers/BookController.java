package ro.utcluj.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.utcluj.bookstore.model.Book;
import ro.utcluj.bookstore.model.Customer;
import ro.utcluj.bookstore.repository.BooksRepository;
import ro.utcluj.bookstore.service.BookService;

import java.util.List;

@RestController
public class BookController {

@Autowired
    BookService bookService;
    public Book save(Book book ) {
        return bookService.save(book);
    }


    public List<Book> findAll() {
    return bookService.getBooks();
    }
}
