package com.example.ProjectDemo.DTO;

import java.util.Date;
import java.util.List;

public class ResponseProductDTO {
    private Integer id;
    private String productName;
    private String alias;
    private String vendor;
    private String productType;
    private String metaTitle;
    private String metaDescription;
    private String summary;
    private String templateLayout;
    private Date publishedOn;
    private Date createdOn;
    private Date modifiedOn;
    private String content;
    private String tags;
    private Boolean status;
    private String type;

    private List<ImageDTO> images;
    private ImageDTO image;   // main image
    private List<VariantDTO> variants;
    private List<OptionDTO> options;

    public ResponseProductDTO() {}

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }

    public String getVendor() { return vendor; }
    public void setVendor(String vendor) { this.vendor = vendor; }

    public String getProductType() { return productType; }
    public void setProductType(String productType) { this.productType = productType; }

    public String getMetaTitle() { return metaTitle; }
    public void setMetaTitle(String metaTitle) { this.metaTitle = metaTitle; }

    public String getMetaDescription() { return metaDescription; }
    public void setMetaDescription(String metaDescription) { this.metaDescription = metaDescription; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public String getTemplateLayout() { return templateLayout; }
    public void setTemplateLayout(String templateLayout) { this.templateLayout = templateLayout; }

    public Date getPublishedOn() { return publishedOn; }
    public void setPublishedOn(Date publishedOn) { this.publishedOn = publishedOn; }

    public Date getCreatedOn() { return createdOn; }
    public void setCreatedOn(Date createdOn) { this.createdOn = createdOn; }

    public Date getModifiedOn() { return modifiedOn; }
    public void setModifiedOn(Date modifiedOn) { this.modifiedOn = modifiedOn; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getTags() { return tags; }
    public void setTags(String tags) { this.tags = tags; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public List<ImageDTO> getImages() {
        return images;
    }

    public void setImages(List<ImageDTO> images) {
        this.images = images;
    }

    public ImageDTO getImage() {
        return image;
    }

    public void setImage(ImageDTO image) {
        this.image = image;
    }

    public List<VariantDTO> getVariants() {
        return variants;
    }

    public void setVariants(List<VariantDTO> variants) {
        this.variants = variants;
    }

    public List<OptionDTO> getOptions() {
        return options;
    }

    public void setOptions(List<OptionDTO> options) {
        this.options = options;
    }
}
