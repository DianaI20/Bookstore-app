package ro.utcluj.bookstore.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.utcluj.bookstore.model.Author;
import ro.utcluj.bookstore.service.AuthorService;
import java.util.List;

@RestController
 public class AuthorController {

    @Autowired
   AuthorService authorService;
    public Author save(Author author ) {
        //userValidator.validate(customer);
        return authorService.save(author);
    }

    public List<Author> findAll() {
        return authorService.getAuthors();
    }

    public Author findById(Long id){
       return authorService.findById(id).get();
    }
}

