package com.example.eshopsb;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository  extends JpaRepository<Product, Integer> {
}
