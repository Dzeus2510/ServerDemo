package com.example.ProjectDemo.Repository;

import com.example.ProjectDemo.Models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
