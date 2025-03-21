package com.example.demo.repository;

import com.example.demo.entities.Motorbike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Motorbike, Integer> {
    @Override
    void deleteById(Integer integer);
}
