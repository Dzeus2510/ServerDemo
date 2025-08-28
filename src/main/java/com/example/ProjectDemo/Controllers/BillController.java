package com.example.ProjectDemo.Controllers;

import DTO.BillWithProductCountDTO;
import com.example.ProjectDemo.Models.Bill;
import com.example.ProjectDemo.Services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/bill")
public class BillController {
    private BillService billService;

    @Autowired
    public BillController(BillService billService){
        this.billService = billService;
    }

    @GetMapping("")
    public List<Bill> getAllBill(){
        return billService.getAllBills();
    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable int id){
        return billService.getBillById(id);
    }

    @PostMapping("")
    public Bill addBill(Bill bill){
        return billService.addBill(bill);
    }

    @PutMapping("/{id}")
    public Bill updateBill(@PathVariable int id, Bill bill){
        return billService.editBill(id, bill);
    }

    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable int id){
        billService.removeBill(id);
    }

    @GetMapping("/count")
    public List<Object[]> getBillsWithCount(){
        return billService.getBillsWithCount();
    }

}
