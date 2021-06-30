package ro.utcluj.bookstore.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.utcluj.bookstore.model.Book;
import ro.utcluj.bookstore.repository.AuthorRepository;

import javax.swing.*;

@Component
public class BookDetails extends AppFrame{


    public Book book;
    private String imagePath;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void initialize() {
        this.setTitle("Details");
        this.setSize(400,500);
        this.setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setSize(400,500);
        mainPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(10, 10, 200, 30);
        JLabel titleLabelValue = new JLabel(book.getTitle());
        titleLabelValue.setBounds(50, 10, 200, 30);

        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(10, 40, 200, 30);
      // JLabel authorLabelValue = new JLabel(authorController.findById(book.getAuthorName()).getName());
       // JLabel authorLabelValue = new JLabel(authorRepository.findById(book.getAuthorName()).get().getName());
        //authorLabelValue.setBounds(50, 40, 200, 30);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(10, 70,200, 30);
         JLabel priceLabelValue = new JLabel(book.getPrice() + "$");
        priceLabelValue.setBounds(50, 70,200, 30);

        JLabel plotLabel = new JLabel("Plot: ");
        JLabel plotLabelValue = new JLabel("<html>"+ book.getPlot()+"</html>");
        plotLabel.setBounds(10, 100,200, 30);
        plotLabelValue.setBounds(50,100,200,235);

        mainPanel.add(titleLabel);
        mainPanel.add(titleLabelValue);
        mainPanel.add(authorLabel);
        mainPanel.add(plotLabel);
        mainPanel.add(plotLabelValue);
       // mainPanel.add(authorLabelValue);
        mainPanel.add(priceLabel);
        mainPanel.add(priceLabelValue);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        this.setContentPane(scrollPane);
        this.setVisible(true);
    }




    public BookDetails() {
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
