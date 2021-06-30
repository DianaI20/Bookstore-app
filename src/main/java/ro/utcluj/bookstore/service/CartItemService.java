package ro.utcluj.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.utcluj.bookstore.model.CartItems;
import ro.utcluj.bookstore.model.CartItems;
import ro.utcluj.bookstore.repository.CartItemsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemService {
    @Autowired
    private CartItemsRepository cartItemsRepository;

    public List<CartItems> getItems(){
        List<CartItems> items = new ArrayList<>();
        Iterable<CartItems> all = cartItemsRepository.findAll();
        all.forEach(items::add);
        return items;
    }

    public CartItems save(CartItems item) {
        return cartItemsRepository.save(item);
    }
}

