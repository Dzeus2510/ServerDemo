package DTO;

import java.util.Date;

public class BillWithProductCountDTO {
    private int id;
    private String paymentCode;
    private Date createdDate;
    private String packageCode;
    private String customerName;
    private boolean returnStatus;
    private boolean receiveStatus;
    private boolean paymentStatus;
    private long productCount;

    public BillWithProductCountDTO() {
    }

    public BillWithProductCountDTO(int id, Date createdDate, String packageCode, String paymentCode, String customerName, boolean receiveStatus, boolean returnStatus, boolean paymentStatus, long productCount) {
        this.id = id;
        this.createdDate = createdDate;
        this.packageCode = packageCode;
        this.paymentCode = paymentCode;
        this.customerName = customerName;
        this.receiveStatus = receiveStatus;
        this.returnStatus = returnStatus;
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

    public boolean getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(boolean returnStatus) {
        this.returnStatus = returnStatus;
    }

    public boolean getReceiveStatus() {
        return receiveStatus;
    }

    public void setReceiveStatus(boolean receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public long getProductCount() {
        return productCount;
    }

    public void setProductCount(long productCount) {
        this.productCount = productCount;
    }
}
