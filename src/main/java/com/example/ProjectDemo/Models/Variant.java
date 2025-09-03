package com.example.ProjectDemo.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "variant")
public class Variant {
    @Id
    private int id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;


    private Long inventoryItemId;
    private String barcode;
    private String sku;


    @Column(precision = 15, scale = 2)
    private BigDecimal price;
    @Column(precision = 15, scale = 2)
    private BigDecimal compareAtPrice;


    private String option1;
    private String option2;
    private String option3;


    private Boolean taxable;
    private String inventoryManagement;
    private String inventoryPolicy;
    private Integer inventoryQuantity;


    private Boolean lotManagement;
    private Boolean requiresShipping;


    @Column(precision = 10, scale = 3)
    private BigDecimal weight;
    private String weightUnit;
    private String unit;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;


    private Integer position;
    private Date createdOn;
    private Date modifiedOn;
    private String title;
    private Integer grams;
    private String type; // combo, normal, packsize
    private Boolean requiresComponents;
}
