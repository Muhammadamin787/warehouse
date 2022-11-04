package com.uz.warehouse.service;

import com.uz.warehouse.Dtos.BrandDto;
import com.uz.warehouse.Dtos.ProductsTypeDto;
import com.uz.warehouse.entity.Brand;
import com.uz.warehouse.entity.ProductsType;

import java.util.List;

public interface ProductTypeServiceInterface {

    List<ProductsType> find();

    ProductsType create(ProductsTypeDto brandDto) throws Exception;

    ProductsType update(Integer id, ProductsTypeDto brandDto);

    void delete(Integer id);
}
