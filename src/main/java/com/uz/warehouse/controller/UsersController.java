package com.uz.warehouse.controller;

import com.uz.warehouse.Dtos.UsersDto;
import com.uz.warehouse.entity.Users;
import com.uz.warehouse.repository.UsersRepository;
import com.uz.warehouse.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UsersController {
    @Autowired
    UsersService service;

    @Autowired
    UsersRepository repository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Users> getAll() {
        return service.getAll();
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Users create(@RequestBody UsersDto dto) {
        return service.create(dto);
    }

    @PutMapping("/put/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Users update(@PathVariable Integer id, @RequestBody UsersDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


 }
