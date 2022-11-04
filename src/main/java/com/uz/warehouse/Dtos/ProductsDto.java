package com.uz.warehouse.Dtos;

import com.uz.warehouse.entity.Brand;
import com.uz.warehouse.entity.ProductsType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDto {
    Integer id;
    String name;
    float price;
    ProductsType type;
    private Integer typeId;
    Brand brand;
    private Integer brandId;


}
