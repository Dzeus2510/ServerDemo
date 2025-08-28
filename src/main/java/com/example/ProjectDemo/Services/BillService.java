package com.example.ProjectDemo.Services;

import DTO.BillWithProductCountDTO;
import com.example.ProjectDemo.Models.Bill;
import com.example.ProjectDemo.Repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BillService {
    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository){
        this.billRepository = billRepository;
    }

    public List<Bill> getAllBills(){
        return billRepository.findAll();
    }

    public Bill getBillById(int id){
        return billRepository.findBillById(id);
    }

    public Bill addBill(Bill bill){
        return billRepository.save(bill);
    }

    public Bill editBill(int id, Bill bill){
        return billRepository.findById(id).map(billEdit ->{
            billEdit.setPackageCode(bill.getPackageCode());
            billEdit.setCreatedDate(bill.getCreatedDate());
            billEdit.setPaymentCode(bill.getPaymentCode());
            billEdit.setPaymentStatus(bill.isPaymentStatus());
            billEdit.setReturnStatus(bill.isReturnStatus());
            billEdit.setReceiveStatus(bill.isReceiveStatus());
            return billRepository.save(billEdit);
        }).orElseThrow(() -> new RuntimeException("Bill with Id: " + id + " is not found!" ));
    }

    public void removeBill(int id){
        billRepository.deleteById(id);
    }

    public List<Object[]> getBillsWithCount(){
        return billRepository.getBillsWithProductCount();
    }
}
