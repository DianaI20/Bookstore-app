package ro.utcluj.bookstore.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.utcluj.bookstore.controllers.CustomerController;
import ro.utcluj.bookstore.exception.ValidationFailedException;
import ro.utcluj.bookstore.model.Customer;

import javax.swing.*;

@Component
class FinishOrder extends AppFrame {

    @Autowired
    CustomerController customerController;

    private JButton sendOrder;
    private JTextField personFullNameTextField;
    private JTextField personAdressTextField;
    private JTextField personPhoneTextField;

    JPanel panel = new JPanel();

    public FinishOrder() {

    }

    @Override
    public void initialize(){

        this.setTitle("Order Details");
        this.setSize(400,600);
        this.setResizable(false);
        panel.setLayout(null);

        JLabel userFullNameLabel = new JLabel("Full name:");
        userFullNameLabel.setBounds(10, 10, 200, 30);
        personFullNameTextField = new JTextField();
        personFullNameTextField.setBounds(10, 40, 200, 30);

        JLabel adressLabel = new JLabel("Adress:");
        adressLabel.setBounds(10, 80, 200, 30);
        personAdressTextField = new JTextField();
        personAdressTextField.setBounds(10, 110, 200, 30);

        JLabel personPhoneLabel = new JLabel("Phone Number:");
        personPhoneLabel.setBounds(10, 150, 200, 30);
        personPhoneTextField = new JTextField();
        personPhoneTextField.setBounds(10, 180, 200, 30);


        sendOrder = new JButton("Complete");
        sendOrder.setBounds(0, 400, 100, 30);
        sendOrder.addActionListener(e->{
            Customer newCustomer = createUser(personFullNameTextField.getText(),
                                            personAdressTextField.getText(),
                                personPhoneTextField.getText()) ;
            try {
                customerController.save(newCustomer);
                displayInformationMessage("Order completed");

            } catch (ValidationFailedException exception) {
                displayErrorMessage(exception);
            }
            personPhoneTextField.setText("");
            personAdressTextField.setText("");
            personFullNameTextField.setText("");
        });

        panel.add(sendOrder);
        panel.add(userFullNameLabel);
        panel.add(personFullNameTextField);
        panel.add(adressLabel);
        panel.add(personAdressTextField);
        panel.add(personPhoneLabel);
        panel.add(personPhoneTextField);
        this.add(panel);
        this.setVisible(true);
    }

    private Customer createUser(String fullName, String adress, String phoneNumber){
        Customer newCustomer = new Customer();
        newCustomer.setName(fullName);
        newCustomer.setAdress(adress);
        newCustomer.setPhoneNumber(phoneNumber);
        return newCustomer;
    }
}
