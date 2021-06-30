package ro.utcluj.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.utcluj.bookstore.model.Author;
import ro.utcluj.bookstore.model.Book;
import ro.utcluj.bookstore.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAuthors(){
        List<Author> authors = new ArrayList<>();
        Iterable<Author> all = authorRepository.findAll();
        all.forEach(authors::add);
        return authors;
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }
    public Optional < Author > findById(Long id) {
        return authorRepository.findById(id);
    }


}
