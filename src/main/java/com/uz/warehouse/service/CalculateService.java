package com.uz.warehouse.service;

import com.uz.warehouse.Dtos.CalculateDto;
import com.uz.warehouse.entity.Calculate;
import com.uz.warehouse.repository.CalculateRepository;
import com.uz.warehouse.service.interfaces.CalculateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculateService implements CalculateServiceInterface {
    @Autowired
    CalculateRepository repository;

    @Override
    public List<Calculate> getAllCalculate() {
        return repository.findAllByOrderByIdAsc();
    }

    @Override
    public Calculate create(CalculateDto dto) {
        Calculate calculate = new Calculate();
        calculate.setSum(dto.getSum());
        calculate.setDebit(dto.getDebit());
        calculate.setClients(null);
        repository.save(calculate);
        return calculate;
    }

    @Override
    public Calculate update(Integer id, CalculateDto dto) {
        Calculate calculate = new Calculate();
        if (repository.existsById(id)) {
            calculate.setDebit(dto.getDebit());
            calculate.setSum(dto.getSum());
            calculate.setClients(null);
            repository.save(calculate);
        } else {
            new Exception("Bunday narsa topilmadi");
        }
        return calculate;
    }

    @Override
    public void delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            new Exception("Bunday id yo'q");
        }
    }
}
