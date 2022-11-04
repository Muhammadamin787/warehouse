package com.uz.warehouse.controller;

import com.uz.warehouse.Dtos.ProductsTypeDto;
import com.uz.warehouse.entity.ProductsType;
import com.uz.warehouse.repository.ProductTypeRepository;
import com.uz.warehouse.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productType")
public class ProductTypeController {

    @Autowired
    ProductTypeService service;
    @Autowired
    ProductTypeRepository repository;

    @GetMapping("/get")
    public List<ProductsType> getAllProductsType() {
        return service.find();
    }
    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductsType addNewProductsType(@RequestBody ProductsTypeDto brandDto) throws Exception {
        ProductsType brand = service.create(brandDto);
        return brand;
    }

    @PutMapping("/brand/{id}")
    public ProductsType update(@PathVariable Integer id, @RequestBody ProductsTypeDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
