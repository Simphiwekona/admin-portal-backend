package com.example.backend.repo;

import com.example.backend.entity.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Quotation, Long> {
}
