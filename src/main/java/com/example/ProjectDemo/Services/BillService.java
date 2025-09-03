package com.example.ProjectDemo.Services;

import com.example.ProjectDemo.DTO.BillAddDTO;
import com.example.ProjectDemo.DTO.BillEditDTO;
import com.example.ProjectDemo.DTO.BillWithProductCountDTO;
import com.example.ProjectDemo.Models.Bill;
import com.example.ProjectDemo.Models.BillProduct;
import com.example.ProjectDemo.Models.Customer;
import com.example.ProjectDemo.Models.Product;
import com.example.ProjectDemo.Repository.BillProductRepository;
import com.example.ProjectDemo.Repository.BillRepository;
import com.example.ProjectDemo.Repository.CustomerRepository;
import com.example.ProjectDemo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BillService {
    private final BillRepository billRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final BillProductRepository billProductRepository;

    @Autowired
    public BillService(BillRepository billRepository, CustomerRepository customerRepository, ProductRepository productRepository, BillProductRepository billProductRepository){
        this.billRepository = billRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.billProductRepository = billProductRepository;
    }

    public List<Bill> getAllBills(){
        return billRepository.findAll();
    }

    public Bill getBillById(int id) throws Exception {
        return billRepository.findBillWithDetailsById(id)
                .orElseThrow(() -> new Exception("Bill không tồn tại với ID: " + id));
    }

    @Transactional
    public Bill addBill(BillAddDTO dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId());

        Bill bill = new Bill();
        bill.setCustomer(customer);
        bill.setPaymentCode(dto.getPaymentCode());
        bill.setPackageCode(dto.getPackageCode());
        bill.setCreatedDate(new Date());
        bill.setPaymentStatus(false);
        bill.setReceiveStatus(false);
        bill.setReturnStatus(false);

        List<BillProduct> billProducts = dto.getProductIds()
                .stream()
                .map(productId -> {
                    Product product = productRepository.findById(productId)
                            .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
                    return new BillProduct(0, product, bill);
                })
                .collect(Collectors.toList());

        bill.setBillProducts(billProducts);

        return billRepository.save(bill);
    }

    @Transactional
    public Bill editBill(int id, BillEditDTO billDto) throws Exception {
        Optional<Bill> optionalBill = billRepository.findById(id);
        if (!optionalBill.isPresent()) {
            throw new Exception("Bill không tồn tại với ID: " + id);
        }

        Bill existingBill = optionalBill.get();

        existingBill.setPackageCode(billDto.getPackageCode() != null ? billDto.getPackageCode() : existingBill.getPackageCode());
        existingBill.setPaymentCode(billDto.getPaymentCode() != null ? billDto.getPaymentCode() : existingBill.getPaymentCode());
        existingBill.setPaymentStatus(billDto.getPaymentStatus() != null ? billDto.getPaymentStatus() : existingBill.isPaymentStatus());
        existingBill.setReturnStatus(billDto.getReturnStatus() != null ? billDto.getReturnStatus() : existingBill.isReturnStatus());
        existingBill.setReceiveStatus(billDto.getReceiveStatus() != null ? billDto.getReceiveStatus() : existingBill.isReceiveStatus());

        if (billDto.getCustomerId() != null) {
            Customer customer = customerRepository.findById(billDto.getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Customer với ID: " + billDto.getCustomerId()));
            existingBill.setCustomer(customer);
        }

        if (billDto.getProductIds() != null) {
            if(existingBill.getBillProducts() != null) {
                existingBill.getBillProducts().clear();
            }

            for (Integer productId : billDto.getProductIds()) {
                Product product = productRepository.findById(productId)
                        .orElseThrow(() -> new Exception("Product không tồn tại với ID: " + productId));
                BillProduct billProduct = new BillProduct();
                billProduct.setBill(existingBill);
                billProduct.setProduct(product);
                existingBill.getBillProducts().add(billProduct);
            }

        }
        return billRepository.save(existingBill);
    }

    public void removeBill(int id){
        billRepository.deleteById(id);
    }

    public List<BillWithProductCountDTO> getBillsWithCount(){
        return billRepository.getBillsWithProductCount();
    }
}
