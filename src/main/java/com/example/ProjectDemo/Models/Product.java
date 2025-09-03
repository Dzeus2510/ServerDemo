package com.example.ProjectDemo.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduct", nullable = false)
    private int id;

    @Column(name = "productname", nullable = false)
    private String productName;

    @Column(name = "alias")
    private String alias;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "meta_title")
    private String metaTitle;

    @Column(name = "meta_description")
    private String metaDescription;

    @Column(name = "summary")
    private String summary;

    @Column(name = "template_layout")
    private String templateLayout;

    @Column(name = "published_on")
    private Date publishedOn;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_on")
    private Date modifiedOn;

    @Column(name = "content")
    private String content;

    @Column(name = "tags")
    private String tags;

    @Column (name = "status")
    private Boolean status;

    @Column(name = "type")
    private String type;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getTemplateLayout() {
        return templateLayout;
    }

    public void setTemplateLayout(String templateLayout) {
        this.templateLayout = templateLayout;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(Date publishedOn) {
        this.publishedOn = publishedOn;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product(int id, String productName, String alias, String productType, String vendor, String metaTitle, String metaDescription, String summary, String templateLayout, Date publishedOn, Date createdOn, Date modifiedOn, String content, String tags, Boolean status, String type) {
        this.id = id;
        this.productName = productName;
        this.alias = alias;
        this.productType = productType;
        this.vendor = vendor;
        this.metaTitle = metaTitle;
        this.metaDescription = metaDescription;
        this.summary = summary;
        this.templateLayout = templateLayout;
        this.publishedOn = publishedOn;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.content = content;
        this.tags = tags;
        this.status = status;
        this.type = type;
    }
}
