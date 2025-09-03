package com.example.ProjectDemo.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer position;
    private Date createdOn;
    private Date modifiedOn;

    private String src;
    private String alt;
    private String filename;
    private Integer size;
    private Integer width;
    private Integer height;
}
