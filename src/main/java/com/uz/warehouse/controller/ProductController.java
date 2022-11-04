package com.uz.warehouse.controller;

import com.uz.warehouse.Dtos.ProductsDto;
import com.uz.warehouse.entity.Products;
import com.uz.warehouse.repository.ProductRepository;
import com.uz.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService service;

    @Autowired
    ProductRepository repository;


    @GetMapping
    public List<Products> getAllProducts() {
        return service.getAllProducts();

    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Products create(@RequestBody ProductsDto productsDto) {
        return service.create(productsDto);

    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Products update(@PathVariable Integer id, @RequestBody ProductsDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
