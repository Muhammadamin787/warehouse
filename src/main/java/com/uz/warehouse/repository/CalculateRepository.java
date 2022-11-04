package com.uz.warehouse.repository;

import com.uz.warehouse.entity.Calculate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculateRepository extends JpaRepository<Calculate, Integer> {


    List<Calculate> findAllByOrderByIdAsc();
}
