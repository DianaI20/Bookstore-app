package ro.utcluj.bookstore.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class CartFrame extends AppFrame {

    @Override
    public void initialize() {
        this.setTitle("Cart Items");
        this.setSize(300,400);
        this.setResizable(false);

        JPanel mainPanel = new JPanel();
        JLabel label = new JLabel("Shopping list:");
        label.setFont(new Font("Edwardian Script ITC", Font.BOLD, 50));
        label.setVisible(true);

        JButton completeButton = new JButton("Complete order");
        completeButton.setBounds(10, 200, 120, 30);
        completeButton.addActionListener(e -> {
            FinishOrder finishOrder = new FinishOrder();
            finishOrder.initialize();
        });
        completeButton.setBackground(Color.blue);
        completeButton.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,12));
        mainPanel.add(completeButton);
        mainPanel.add(label);
        mainPanel.setVisible(true);
        this.add(mainPanel);
        this.setVisible(true);
    }
}
