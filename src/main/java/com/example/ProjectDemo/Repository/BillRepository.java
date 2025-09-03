package com.example.ProjectDemo.Repository;

import com.example.ProjectDemo.DTO.BillWithProductCountDTO;
import com.example.ProjectDemo.Models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    @Query("SELECT b FROM Bill b LEFT JOIN FETCH b.billProducts bp LEFT JOIN FETCH b.customer WHERE b.id = ?1")
    Optional<Bill> findBillWithDetailsById(Integer id);

    @Query( "SELECT new com.example.ProjectDemo.DTO.BillWithProductCountDTO(" +
            "b.id, createdDate, packageCode, paymentCode, customer.customerName, receiveStatus, returnStatus, paymentStatus, COUNT(bp.product.id))" +
            "FROM Bill b LEFT JOIN BillProduct bp ON b.id = bp.bill.id " +
            "LEFT JOIN Product p ON p.id = bp.product.id " +
            "GROUP BY b.id, createdDate, packageCode, paymentCode, customer.customerName, receiveStatus, returnStatus, paymentStatus")
    List<BillWithProductCountDTO> getBillsWithProductCount();

}
