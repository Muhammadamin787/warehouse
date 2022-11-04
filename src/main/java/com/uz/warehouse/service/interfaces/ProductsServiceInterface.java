package com.uz.warehouse.service.interfaces;

import com.uz.warehouse.Dtos.ProductsDto;
import com.uz.warehouse.entity.Products;

import java.util.List;

public interface ProductsServiceInterface {

    List<Products> getAllProducts();

    Products create(ProductsDto dto) throws Exception;

    Products update(Integer id,ProductsDto dto) throws Exception;

    void delete(Integer id);
}
