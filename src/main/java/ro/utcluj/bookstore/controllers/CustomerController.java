package ro.utcluj.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.utcluj.bookstore.model.Customer;
import ro.utcluj.bookstore.service.CustomerService;
import ro.utcluj.bookstore.validator.UserValidator;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
   private CustomerService customerService;
    @Autowired
   private UserValidator userValidator;

    public Customer save(Customer customer) {
        userValidator.validate(customer);
        return customerService.save(customer);
    }

    public List<Customer> findAll() {
        return customerService.getUsers();
    }
}
