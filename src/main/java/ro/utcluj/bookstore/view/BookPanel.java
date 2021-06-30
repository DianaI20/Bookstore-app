package ro.utcluj.bookstore.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.utcluj.bookstore.model.Book;
import ro.utcluj.bookstore.model.CartItems;
import ro.utcluj.bookstore.model.ShoppingCart;
import ro.utcluj.bookstore.repository.CartItemsRepository;
import ro.utcluj.bookstore.view.BookDetails;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Component
public class BookPanel extends JPanel{

    private BookDetails bookDetails = new BookDetails();
    private Book book;
    private Integer itemsInTheCart;
    private String imagePath;
    private String title;
    private ShoppingCart shoppingCart = new ShoppingCart();

    @Autowired
    CartItemsRepository cartItemsRepository;

    public void initialize(){
        this.setVisible(true);
        this.setLayout(new BorderLayout());

        imagePath = book.getImagePath();
        title = book.getTitle();
        JLabel bookTitle = new JLabel(title);
        bookTitle.setSize(100,150);
        bookTitle.setFont(new Font("Times New Roman", Font.BOLD,15));
        bookTitle.setBackground(Color.white);
        bookTitle.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(200,250,
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        JLabel imageLabel = new JLabel(imageIcon);

        JButton buyButton = new JButton("Add to cart");
        buyButton.setBackground(Color.BLUE);
        buyButton.setBounds(20,20,150,150);
//        buyButton.addActionListener(e->{
//
//            CartItems cartItem = new CartItems();
//            cartItem.setBookId(book.getId());
//            cartItem.setShoppingCartId(shoppingCart.getId());
//            cartItemsRepository.save(cartItem);
//        });

        JButton detailsButton = new JButton("Details");
        detailsButton.setBackground(Color.RED);
        detailsButton.setBounds(20,20,150,150);
        detailsButton.addActionListener(e->{
            bookDetails = new BookDetails();
            bookDetails.setBook(book);
            bookDetails.initialize();

        });

        JPanel pageEnd = new JPanel(new BorderLayout());

        pageEnd.add(buyButton,BorderLayout.CENTER);
        pageEnd.add(detailsButton,BorderLayout.WEST);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(bookTitle,BorderLayout.PAGE_START);
        this.add(imageLabel,BorderLayout.CENTER);
        this.add(pageEnd,BorderLayout.PAGE_END);
        this.setVisible(true);
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    public BookPanel(){
    }
}
