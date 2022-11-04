package com.uz.warehouse.service;

import com.uz.warehouse.Dtos.BrandDto;
import com.uz.warehouse.Dtos.ProductsTypeDto;
import com.uz.warehouse.entity.Brand;
import com.uz.warehouse.entity.ProductsType;
import com.uz.warehouse.repository.BrandRepository;
import com.uz.warehouse.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeService implements ProductTypeServiceInterface {
    @Autowired
    ProductTypeRepository repository;

    @Override
    public List<ProductsType> find() {
        return repository.findAllByOrderByIdAsc();
    }

    @Override
    public ProductsType create(ProductsTypeDto brandDto) throws Exception {
        ProductsType brand = new ProductsType();
        if (!repository.existsByName(brandDto.getName())) {
            brand.setName(brandDto.getName());
        } else {
            throw new Exception("Bunday Brand Mavjud");
        }
        return repository.save(brand);
    }

    @Override
    public ProductsType update(Integer id, ProductsTypeDto brand) {
        ProductsType brandNew = new ProductsType();

        Optional<ProductsType> optional = repository.findById(id);
        if (optional.isPresent()) {
            if (repository.existsByNameEqualsIgnoreCaseAndIdNot(brand.getName(), brand.getId())) {
                brandNew.setId(brand.getId());
                brandNew.setName(brand.getName());
            } else {
                return null;
            }
        } else {
            return null;
        }
        return repository.save(brandNew);
    }

    @Override
    public void delete(Integer id) {
        Optional<ProductsType> byId = repository.findById(id);
        if (byId.isPresent())
            repository.deleteById(id);
    }
}
