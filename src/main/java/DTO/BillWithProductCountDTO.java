package DTO;

import java.util.Date;

public class BillWithProductCountDTO {
    private int id;
    private String paymentCode;
    private Date createdDate;
    private String packageCode;
    private String customerName;
    private String returnStatus;
    private String receiveStatus;
    private String paymentStatus;
    private int productCount;

    public BillWithProductCountDTO() {
    }

    public BillWithProductCountDTO(int id, String paymentCode, Date createdDate, String packageCode, String customerName, String returnStatus, String receiveStatus, String paymentStatus, int productCount) {
        this.id = id;
        this.paymentCode = paymentCode;
        this.createdDate = createdDate;
        this.packageCode = packageCode;
        this.customerName = customerName;
        this.returnStatus = returnStatus;
        this.receiveStatus = receiveStatus;
        this.paymentStatus = paymentStatus;
        this.productCount = productCount;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    public String getReceiveStatus() {
        return receiveStatus;
    }

    public void setReceiveStatus(String receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
}
