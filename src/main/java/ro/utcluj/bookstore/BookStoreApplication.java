package ro.utcluj.bookstore;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import ro.utcluj.bookstore.repository.BooksRepository;
import ro.utcluj.bookstore.service.BookService;
import ro.utcluj.bookstore.view.Dashboard;

@SpringBootApplication
public class BookStoreApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(BookStoreApplication.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
        Dashboard dashboard = context.getBean(Dashboard.class);
        dashboard.initialize();

    }
}
