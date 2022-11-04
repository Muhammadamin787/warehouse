package com.uz.warehouse.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandDto {
    private Integer id;
    private String name;

    private BrandDto(String name) {
        this.name = name;
    }
}
