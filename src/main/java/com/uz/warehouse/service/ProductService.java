package com.uz.warehouse.service;

import com.uz.warehouse.Dtos.ProductsDto;
import com.uz.warehouse.entity.Brand;
import com.uz.warehouse.entity.Products;
import com.uz.warehouse.entity.ProductsType;
import com.uz.warehouse.repository.BrandRepository;
import com.uz.warehouse.repository.ProductRepository;
import com.uz.warehouse.repository.ProductTypeRepository;
import com.uz.warehouse.service.interfaces.ProductsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductsServiceInterface {
    @Autowired
    ProductRepository repository;
    @Autowired
    ProductTypeRepository productTypeRepository;

    @Autowired
    BrandRepository repositoryBrand;


    @Override
    public List<Products> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Products create(ProductsDto dto) throws Exception {
        Products products = new Products(
                dto.getName(),
                dto.getPrice(),
                (dto.getTypeId() != null ? productTypeRepository.findById(dto.getTypeId()).orElseThrow(()-> new Exception("ProductType")) : null),
                (dto.getBrandId()!= null ? repositoryBrand.findById(dto.getBrandId()).orElseThrow(() -> new Exception("Brand")) : null)
        );
        repository.save(products);
        return products;
    }

    @Override
    public Products update(Integer id, ProductsDto dto) throws Exception {
        Products products = new Products();
        if (repository.existsById(dto.getId())) {
            products.setName(dto.getName());
            products.setPrice(dto.getPrice());
            products.setBrand(dto.getTypeId() != null ? repositoryBrand.findById(dto.getTypeId()).orElseThrow(() ->new Exception("Brand")) : null);
            products.setProductsType(dto.getTypeId() != null ? productTypeRepository.findById(dto.getTypeId()).orElseThrow(() -> new Exception("Product Type")) : null);
            repository.save(products);
        } else {
            new Exception("Bunday Product nomi bor!");
        }
        return products;
    }

    @Override
    public void delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            new Exception("Bunday Product yo'q Tirrancha!");
        }
    }
    //asefsd
}
