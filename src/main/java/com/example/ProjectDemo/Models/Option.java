package com.example.ProjectDemo.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "option")
public class Option {

    @Id
    private int id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;


    private String name;
    private Integer position;
    private Date createdOn;
    private Date modifiedOn;


    @OneToMany(mappedBy = "option", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id ASC")
    private List<OptionValue> values = new ArrayList<>();
}
