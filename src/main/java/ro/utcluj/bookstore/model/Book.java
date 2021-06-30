package ro.utcluj.bookstore.model;

import org.springframework.beans.factory.annotation.Autowired;
import ro.utcluj.bookstore.controllers.AuthorController;
import ro.utcluj.bookstore.repository.AuthorRepository;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "books")
public class Book extends  AbstractEntity{


    @Column(name ="title")
    private String title;

    @Column(name = "author")
    private Long authorName;

    @Column(name = "publishing_year")
    private Integer year;

    @Column(name = "price")
    private Float price;

    @Column(name = "plot")
    private String plot;

    @Column(name = "imagePath")
    private String imagePath;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long sgetAuthorName() {
        return authorName;
    }

    public void setAuthorName(Long authorName) {
        this.authorName = authorName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Book() {
    }

}
