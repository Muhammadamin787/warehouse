package com.uz.warehouse.service;

import com.uz.warehouse.Dtos.BrandDto;
import com.uz.warehouse.entity.Brand;

import java.util.List;

public interface BrandServiceInterface {

    List<Brand> find();

    Brand create(BrandDto brandDto) throws Exception;

    Brand update(Integer id, BrandDto brandDto);

    void delete(Integer id);
}
