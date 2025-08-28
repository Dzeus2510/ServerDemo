package com.example.ProjectDemo.Repository;

import com.example.ProjectDemo.Models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    Bill findBillById(int id);

    @Query( "SELECT b.id, paymentCode, createdDate, packageCode, customer.customerName, returnStatus, receiveStatus, paymentStatus, COUNT(bp.product.id) as productCount " +
            "FROM Bill b LEFT JOIN BillProduct bp ON b.id = bp.bill.id " +
            "LEFT JOIN Product p ON p.id = bp.product.id " +
            "GROUP BY b.id")
    List<Object[]> getBillsWithProductCount();


}
