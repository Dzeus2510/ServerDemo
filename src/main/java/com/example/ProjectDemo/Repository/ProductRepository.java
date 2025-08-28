package com.example.ProjectDemo.Repository;

import com.example.ProjectDemo.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findProductById(int id);
}
