package ro.utcluj.bookstore.view;

import net.miginfocom.swing.MigLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.utcluj.bookstore.controllers.BookController;
import ro.utcluj.bookstore.controllers.CartItemController;
import ro.utcluj.bookstore.controllers.CustomerController;
import ro.utcluj.bookstore.model.Book;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class Dashboard extends AppFrame {

    @Autowired
     CustomerController customerController;
    @Autowired
    private FinishOrder finishOrderFrame;
    @Autowired
    private CartFrame cartFrame;
    @Autowired
    private BookController bookController;
    @Autowired
    private CartItemController cartItemController;




    JPanel titlePanel = new JPanel();
    JPanel viewPanel = new JPanel();


    public Dashboard() {

    }

    @Override
    public void initialize() {

        this.setTitle("Bookstore");
        this.setSize(1200, 600);
        this.setResizable(false);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setPreferredSize(new Dimension(1200, 600));

        titlePanel.setPreferredSize(new Dimension(1080, 60));
        titlePanel.setMinimumSize(new Dimension(1080, 60));
        JLabel appTitle = new JLabel("Bookstore");
        appTitle.setFont(new Font("Edwardian Script ITC", Font.BOLD, 50));

        JButton cartButton = new JButton("Cart:");
        String imagePath = "C:\\Users\\Diana\\IdeaProjects\\BookStoreApp\\Icons\\favorite-cart.png";

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(50, 35,
                Image.SCALE_SMOOTH);
        Icon cartIcon = new ImageIcon(dimg);
        cartButton.setIcon(cartIcon);
        cartButton.addActionListener(e -> {
            cartFrame.initialize();
        });



        titlePanel.setLayout(new MigLayout("", "[]push[]", ""));
        titlePanel.add(appTitle);
        titlePanel.add(cartButton, "top,left");

        titlePanel.setBackground(Color.BLUE);
        contentPane.add(BorderLayout.PAGE_START, titlePanel);

        viewPanel.setLayout(new MigLayout("wrap 5"));


        List<Book> books = bookController.findAll();
        for (Book book : books) {

            BookPanel bookPanel = new BookPanel();
            bookPanel.setBook(book);
            bookPanel.initialize();
            viewPanel.add(bookPanel,"gapleft 20 ");
        }


        JScrollPane scrollPane = new JScrollPane(viewPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        contentPane.add(BorderLayout.CENTER, scrollPane);

        this.setContentPane(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

}
