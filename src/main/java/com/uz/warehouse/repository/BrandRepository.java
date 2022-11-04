package com.uz.warehouse.repository;


import com.uz.warehouse.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {


    boolean existsByNameEqualsIgnoreCaseAndIdNot(String name, Integer id);
    boolean existsByName(String name);

    List<Brand> findAllByOrderByIdAsc();
}
