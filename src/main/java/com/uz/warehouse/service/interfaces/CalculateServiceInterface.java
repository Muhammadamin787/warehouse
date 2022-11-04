package com.uz.warehouse.service.interfaces;

import com.uz.warehouse.Dtos.CalculateDto;
import com.uz.warehouse.entity.Calculate;

import java.util.List;

public interface CalculateServiceInterface {

    List<Calculate> getAllCalculate();

    Calculate create(CalculateDto dto);

    Calculate update(Integer id, CalculateDto dto);

    void delete(Integer id);
}
