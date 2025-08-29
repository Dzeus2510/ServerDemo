package DTO;

import java.util.List;

public class BillAddDTO {
    private String paymentCode;
    private String packageCode;
    private Integer customerId;
    private List<Integer> productIds;

    public BillAddDTO(String paymentCode, String packageCode, Integer customerId, List<Integer> productIds) {
        this.paymentCode = paymentCode;
        this.packageCode = packageCode;
        this.customerId = customerId;
        this.productIds = productIds;
    }

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

    public int getCustomerId() {
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
}
