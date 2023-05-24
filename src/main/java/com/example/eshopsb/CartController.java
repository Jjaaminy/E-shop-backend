package com.example.eshopsb;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add-item")
    public ResponseEntity<?> addItemToCart(@RequestBody Product product) {
        cartService.addItemToCart(product);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/remove-item")
    public ResponseEntity<?> removeItemFromCart(@RequestBody Product product) {
        cartService.removeItemFromCart(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable int cartId) {
        Cart cart = cartService.getCartById(cartId);
        if (cart != null) {
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{cartId}/clear")
    public ResponseEntity<?> clearCart(@PathVariable int cartId) {
        cartService.clearCart(cartId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{cartId}/items")
    public ResponseEntity<List<Product>> getCartItems(@PathVariable int cartId) {
        List<Product> items = cartService.getCartItems(cartId);
        return ResponseEntity.ok(items);
    }
}
