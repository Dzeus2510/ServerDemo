package com.example.ProjectDemo.Controllers;

import com.example.ProjectDemo.DTO.BillAddDTO;
import com.example.ProjectDemo.DTO.BillEditDTO;
import com.example.ProjectDemo.DTO.BillWithProductCountDTO;
import com.example.ProjectDemo.Models.Bill;
import com.example.ProjectDemo.Services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Bill getBillById(@PathVariable int id) throws Exception {
        return billService.getBillById(id);
    }

    @PostMapping("")
    public Bill addBill(@RequestBody BillAddDTO billDto){
        return billService.addBill(billDto);
    }

    @PutMapping("/{id}")
    public Bill updateBill(@PathVariable int id, @RequestBody BillEditDTO billDto) throws Exception {
        return billService.editBill(id, billDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable int id){
        billService.removeBill(id);
    }

    @GetMapping("/count")
    public List<BillWithProductCountDTO> getBillsWithCount(){
        return billService.getBillsWithCount();
    }

}
