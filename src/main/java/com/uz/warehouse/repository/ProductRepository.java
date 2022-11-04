package com.uz.warehouse.repository;


import com.uz.warehouse.entity.Brand;
import com.uz.warehouse.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {


    boolean existsByNameEqualsIgnoreCaseAndIdNot(String name, Integer id);
    boolean existsByName(String name);

    List<Products> findAllByOrderByIdAsc();
}
