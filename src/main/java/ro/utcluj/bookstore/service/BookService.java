package ro.utcluj.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.utcluj.bookstore.model.Book;
import ro.utcluj.bookstore.repository.BooksRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

@Autowired
    BooksRepository booksRepository;

    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        Iterable<Book> all = booksRepository.findAll();
        all.forEach(books::add);
        return books;
    }

    public Book save(Book book) {
        return booksRepository.save(book);
    }


}
