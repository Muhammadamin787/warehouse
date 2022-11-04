package com.uz.warehouse.service;

import com.uz.warehouse.Dtos.BrandDto;
import com.uz.warehouse.entity.Brand;
import com.uz.warehouse.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService implements BrandServiceInterface {
    @Autowired
    BrandRepository brandRepository;

    @Override
    public List<Brand> find() {
        return brandRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Brand create(BrandDto brandDto) throws Exception {
        Brand brand = new Brand();
        if (!brandRepository.existsByName(brandDto.getName())) {
            brand.setName(brandDto.getName());
        } else {
            throw new Exception("Bunday Brand Mavjud");
        }
        return brandRepository.save(brand);
    }

    @Override
    public Brand update(Integer id, BrandDto brand) {
        Brand brandNew = new Brand();

        Optional<Brand> optional = brandRepository.findById(id);
        if (optional.isPresent()) {
            if (brandRepository.existsByNameEqualsIgnoreCaseAndIdNot(brand.getName(), brand.getId())) {
                brandNew.setId(brand.getId());
                brandNew.setName(brand.getName());
            } else {
                return null;
            }
        } else {
            return null;
        }
        return brandRepository.save(brandNew);
    }

    @Override
    public void delete(Integer id) {
        Optional<Brand> byId = brandRepository.findById(id);
        if (byId.isPresent())
            brandRepository.deleteById(id);
    }
}
