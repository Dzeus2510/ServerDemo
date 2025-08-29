package com.example.ProjectDemo.Models;

import jakarta.persistence.*;
import com.example.ProjectDemo.Models.Customer;

import java.util.Date;
import java.util.List;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billid", nullable = false)
    private int id;

    @Column(name= "paymentcode", nullable = false)
    private String paymentCode;

    @Column(name = "createddate", nullable = false)
    private Date createdDate;

    @Column(name= "packagecode", nullable = false)
    private String packageCode;

    @ManyToOne
    @JoinColumn(name = "customerid", nullable = false)
    private Customer customer;

    @Column(name = "returnstatus")
    private boolean returnStatus;

    @Column(name = "receivestatus")
    private boolean receiveStatus;

    @Column(name = "paymentstatus")
    private boolean paymentStatus;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<BillProduct> billProducts;

    public List<BillProduct> getBillProducts() {
        return billProducts;
    }

    public void setBillProducts(List<BillProduct> billProducts) {
        this.billProducts = billProducts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(boolean returnStatus) {
        this.returnStatus = returnStatus;
    }

    public boolean isReceiveStatus() {
        return receiveStatus;
    }

    public void setReceiveStatus(boolean receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Bill() {
    }

    public Bill(String paymentCode, int id, Date createdDate, String packageCode, Customer customer, boolean returnStatus, boolean receiveStatus, boolean paymentStatus) {
        this.paymentCode = paymentCode;
        this.id = id;
        this.createdDate = createdDate;
        this.packageCode = packageCode;
        this.customer = customer;
        this.returnStatus = returnStatus;
        this.receiveStatus = receiveStatus;
        this.paymentStatus = paymentStatus;
    }
}
