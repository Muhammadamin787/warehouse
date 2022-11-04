package com.uz.warehouse.Dtos;

import com.uz.warehouse.entity.Clients;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculateDto {
    Integer id;

    BigDecimal sum;
    String debit;
    Clients client_id;

    public CalculateDto(BigDecimal sum, String debit, Clients client_id) {
        this.sum = sum;
        this.debit = debit;
        this.client_id = client_id;
    }
}
