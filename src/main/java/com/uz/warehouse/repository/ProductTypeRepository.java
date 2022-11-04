package com.uz.warehouse.repository;


import com.uz.warehouse.entity.ProductsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductsType, Integer> {

    Optional<ProductsType> findById(Integer id);


    boolean existsByNameEqualsIgnoreCaseAndIdNot(String name, Integer id);
    boolean existsByName(String name);

    List<ProductsType> findAllByOrderByIdAsc();
}
