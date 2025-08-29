package com.example.ProjectDemo.Repository;

import com.example.ProjectDemo.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findProductById(int id);

    @Query("SELECT p.productName FROM Product p JOIN BillProduct bp ON p.id = bp.product.id WHERE bp.bill.id = ?1")
    List<String> findProductByBill(int id);
}
