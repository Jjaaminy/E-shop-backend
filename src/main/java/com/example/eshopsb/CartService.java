package com.example.eshopsb;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService {

    private final Map<Integer, Cart> carts;

    public CartService() {
        this.carts = new HashMap<>();
    }

    public void addItemToCart(Product product) {
        int cartId = 1; // Assuming a single cart for simplicity
        Cart cart = carts.getOrDefault(cartId, new Cart(cartId));
        cart.addItem(product);
        carts.put(cartId, cart);
    }

    public void removeItemFromCart(Product product) {
        int cartId = 1; // Assuming a single cart for simplicity
        Cart cart = carts.get(cartId);
        if (cart != null) {
            cart.removeItem(product);
        }
    }

    public Cart getCartById(int cartId) {
        return carts.get(cartId);
    }

    public void clearCart(int cartId) {
        carts.remove(cartId);
    }

    public List<Product> getCartItems(int cartId) {
        Cart cart = carts.get(cartId);
        if (cart != null) {
            return cart.getItems();
        } else {
            return Collections.emptyList();
        }
    }
}

