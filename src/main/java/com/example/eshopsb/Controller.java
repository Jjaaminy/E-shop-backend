package com.example.eshopsb;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
        Product product1 = new Product(1, "Onigiri", "Reis mit Seegras ", 4.90, "https://media.istockphoto.com/id/892009858/de/foto/frisch-gemachte-japanische-dreieckigen-onigiri.jpg?s=612x612&w=0&k=20&c=k65AAG-H1z7pkxn4JBfttT7kdW4k6m_x79kY2_D16nY=");
        Product product2 = new Product(2, "Taikyaki", "Fisch, Fleisch & Gemüse mariniert", 5.60,"https://media.istockphoto.com/id/1434420080/de/foto/japanisches-taiyaki-fischf%C3%B6rmiger-kuchen-mit-s%C3%BC%C3%9Fer-roter-bohnenpaste.jpg?s=612x612&w=0&k=20&c=XVlQan8aDDKGt1-jynJ7syV2UTI4AywTuoOfECW_E3I=");
        Product product3 = new Product(3, "Dango", "Kloss", 3.40,"https://media.istockphoto.com/id/1477396830/de/foto/mitarashi-kn%C3%B6del.jpg?s=612x612&w=0&k=20&c=myr0uGWi-WugmEuQE4HjeYYNCzvkAnzD74sBr74On-k=");
        Product product4 = new Product(4, "Sushi", "gesäuerte Reis mit vielen Zutaten", 10.30,"https://media.istockphoto.com/id/92406688/de/foto/maki-sushi-auf-schwarzem-teller.jpg?s=612x612&w=0&k=20&c=iQMH6GxYb593lXbB_iw-HJ-lbulAfFW6ERlMQ65p6I4=");
        Product product5 = new Product(5, "Mochi", "Reiskuchen aus Klebreis", 3.40,"https://media.istockphoto.com/id/1395600474/de/foto/gr%C3%BCner-tee-matcha-mochi-eis-isoliert-auf-wei%C3%9Fem-hintergrund.jpg?s=612x612&w=0&k=20&c=D5AtKSWPEZSIvjrfBcuM0sL9iWOjmSSJn2Dc8bTuQHE=");
        Product product6 = new Product(6, "Dorayaki", "Pfannkuchen mit Kastanie", 8.15,"https://media.istockphoto.com/id/155848795/de/foto/dorayaki.jpg?s=612x612&w=0&k=20&c=A-uMZIFxh3e0_gMW3qKiQs37oq5T0shu5uaYLG5ZWkE=");
        Product product7 = new Product(7, "Kare Pan", "Curry-Brötchen", 6.30,"https://media.istockphoto.com/id/466394380/de/foto/curry-brot.jpg?s=612x612&w=0&k=20&c=yPRIO8TwdnsOe0h6HRzFTz8LMDa_QxMEe3uSVRK2QJg=");
        Product product8 = new Product(8, "Nikuman", "gedämpfte Teigtaschen", 2.50,"https://media.istockphoto.com/id/1087117630/de/foto/nikuman.jpg?s=612x612&w=0&k=20&c=MOddRJpfCwqVZ-5pH5hzucleFMk8toQEkEGw5xdS1Mw=");

        repo.saveAll(Arrays.asList(product1, product2, product3, product4, product5, product6, product7, product8));

    }

    /*
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:8080");
            }
        };
        return webMvcConfigurerAdapter;
    }
*/

}

