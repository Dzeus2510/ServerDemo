package com.example.ProjectDemo.DTO;

import java.util.Date;
import java.util.List;

public class OptionDTO {
    private int id;
    private String name;
    private Integer position;
    private Date createdOn;
    private Date modifiedOn;
    private List<OptionValueDTO> values;

    private int productId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public List<OptionValueDTO> getValues() {
        return values;
    }

    public void setValues(List<OptionValueDTO> values) {
        this.values = values;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
