package ro.utcluj.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.utcluj.bookstore.model.CartItems;
import ro.utcluj.bookstore.model.Customer;
import ro.utcluj.bookstore.model.Order;
import ro.utcluj.bookstore.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getOrders(){
        List<Order> orders = new ArrayList<>();
        Iterable<Order> all = orderRepository.findAll();
        all.forEach(orders::add);
        return orders;
    }
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
