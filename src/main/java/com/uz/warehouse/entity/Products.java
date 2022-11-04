package com.uz.warehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Products extends AbsEntity{

    private String name;

    private float price;

    @ManyToOne
    ProductsType productsType;

    @ManyToOne
    Brand brand;
}
