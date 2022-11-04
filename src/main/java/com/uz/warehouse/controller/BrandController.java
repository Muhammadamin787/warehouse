package com.uz.warehouse.controller;

import com.uz.warehouse.Dtos.BrandDto;
import com.uz.warehouse.entity.Brand;
import com.uz.warehouse.repository.BrandRepository;
import com.uz.warehouse.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;
import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    BrandService brandService;
    @Autowired
    BrandRepository brandRepository;

    @GetMapping("/get")
    public List<Brand> getAllBrand() {
        return brandService.find();
    }
    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Brand addNewBrand(@RequestBody BrandDto brandDto) throws Exception {
        Brand brand = brandService.create(brandDto);
        return brand;
    }

    @PutMapping("/brand/{id}")
    public Brand update(@PathVariable Integer id, @RequestBody BrandDto dto) {
        return brandService.update(id, dto);
    }

    @DeleteMapping("/brand/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id){
        brandService.delete(id);
    }
}
