package com.uz.warehouse.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersDto {
    private Integer id;
    private String fullName;
    private String phoneNumber;

}
