package com.example.ProjectDemo.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import com.example.ProjectDemo.Models.Bill;
import com.example.ProjectDemo.Models.Product;

@Entity
@Table(name = "billproduct")
public class BillProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbillproduct", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "productid", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "billid", nullable = false)
    @JsonBackReference
    private Bill bill;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public BillProduct() {
    }

    public BillProduct(int id, Product product, Bill bill) {
        this.id = id;
        this.product = product;
        this.bill = bill;
    }
}
