package ro.utcluj.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.utcluj.bookstore.model.Customer;
import ro.utcluj.bookstore.repository.CustomerRepository;
import ro.utcluj.bookstore.validator.UserValidator;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
   private CustomerRepository customerRepository;
    @Autowired
    private UserValidator customerValidator;

    public List<Customer> getUsers() {
        List<Customer> customers = new ArrayList<>();
        Iterable<Customer> all = customerRepository.findAll();
        all.forEach(customers::add);
        return customers;
    }

    public Customer save(Customer customer) {

        return customerRepository.save(customer);
    }
}
