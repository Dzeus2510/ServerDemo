package com.example.ProjectDemo.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "idcustomer", nullable = false)
    private int id;

    @Column(name= "customername", nullable = false)
    private String customerName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Customer() {
    }

    public Customer(int id, String customerName) {
        this.id = id;
        this.customerName = customerName;
    }
}
