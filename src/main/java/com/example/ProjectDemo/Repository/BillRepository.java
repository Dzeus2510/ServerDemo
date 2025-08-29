package com.example.ProjectDemo.Repository;

import DTO.BillWithProductCountDTO;
import com.example.ProjectDemo.Models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    Bill findBillById(int id);

    @Query( "SELECT new DTO.BillWithProductCountDTO(" +
            "b.id, createdDate, packageCode, paymentCode, customer.customerName, receiveStatus, returnStatus, paymentStatus, COUNT(bp.product.id))" +
            "FROM Bill b LEFT JOIN BillProduct bp ON b.id = bp.bill.id " +
            "LEFT JOIN Product p ON p.id = bp.product.id " +
            "GROUP BY b.id, createdDate, packageCode, paymentCode, customer.customerName, receiveStatus, returnStatus, paymentStatus")
    List<BillWithProductCountDTO> getBillsWithProductCount();

}
