package com.example.eshopsb;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class Controller {

    @Autowired
    private final ProductRepository repo;

    public Controller(ProductRepository repo) {
        this.repo = repo;
    }


    @GetMapping
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Optional<Product> product = repo.findById(id);
        return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    @PostConstruct
    public void init() {
        // Creating and saving some sample products
        Product product1 = new Product(1,"Product 1", "Description 1", 10.20);
        Product product2 = new Product(2,"Product 2", "Description 2", 20.27);
        Product product3 = new Product(3,"Product 3", "Description 3", 30.20);

        repo.saveAll(Arrays.asList(product1,product2,product3 ));
    }
}
