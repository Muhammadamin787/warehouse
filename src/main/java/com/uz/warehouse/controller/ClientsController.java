package com.uz.warehouse.controller;

import com.uz.warehouse.Dtos.ClientDto;
import com.uz.warehouse.entity.Clients;
import com.uz.warehouse.repository.ClientsRepository;
import com.uz.warehouse.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientsController {
    @Autowired
    ClientsService service;

    @Autowired
    ClientsRepository repository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Clients> getAllClients() {
        return service.getAllClients();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Clients create(@RequestBody ClientDto dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Clients update(@RequestBody ClientDto dto, @PathVariable Integer id) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
