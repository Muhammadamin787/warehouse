package com.uz.warehouse.controller;

import com.uz.warehouse.Dtos.CalculateDto;
import com.uz.warehouse.entity.Calculate;
import com.uz.warehouse.repository.CalculateRepository;
import com.uz.warehouse.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/calculate")
public class CalculateController {

    @Autowired
    CalculateService service;

    @Autowired
    CalculateRepository repository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Calculate> getAllCalculate() {
        return service.getAllCalculate();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Calculate create(@RequestBody CalculateDto dto) {
        return service.create(dto);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Calculate update(@PathVariable Integer id, CalculateDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void delete(@PathVariable Integer id) {
         service.delete(id);
    }
}
