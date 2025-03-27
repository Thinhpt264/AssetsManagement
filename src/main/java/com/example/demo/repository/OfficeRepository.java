package com.example.demo.repository;

import com.example.demo.entities.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, Long> {
    boolean existsById(Long id);
}
