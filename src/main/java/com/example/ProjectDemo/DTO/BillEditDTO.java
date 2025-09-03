package com.example.ProjectDemo.DTO;

import java.util.List;

public class BillEditDTO {
    private String paymentCode;
    private String packageCode;
    private Integer customerId;
    private List<Integer> productIds;
    private Boolean paymentStatus;
    private Boolean receiveStatus;
    private Boolean returnStatus;

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Boolean getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(Boolean returnStatus) {
        this.returnStatus = returnStatus;
    }

    public Boolean getReceiveStatus() {
        return receiveStatus;
    }

    public void setReceiveStatus(Boolean receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    public BillEditDTO(String paymentCode, String packageCode, Integer customerId, List<Integer> productIds, Boolean paymentStatus, Boolean receiveStatus, Boolean returnStatus) {
        this.paymentCode = paymentCode;
        this.packageCode = packageCode;
        this.customerId = customerId;
        this.productIds = productIds;
        this.paymentStatus = paymentStatus;
        this.receiveStatus = receiveStatus;
        this.returnStatus = returnStatus;
    }
}
