package com.example.ProjectDemo.Repository;

import com.example.ProjectDemo.Models.BillProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillProductRepository extends JpaRepository<BillProduct, Integer> {
    @Query("DELETE FROM BillProduct bp WHERE bp.bill.id = ?1")
    BillProduct deleteByBillId(int id);
}
