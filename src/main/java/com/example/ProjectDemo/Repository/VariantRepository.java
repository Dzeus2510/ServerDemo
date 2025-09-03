package com.example.ProjectDemo.Repository;

import com.example.ProjectDemo.Models.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariantRepository extends JpaRepository<Variant, Integer> {
}
