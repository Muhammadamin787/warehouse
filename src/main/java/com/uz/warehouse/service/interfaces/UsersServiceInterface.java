package com.uz.warehouse.service.interfaces;

import com.uz.warehouse.Dtos.ClientDto;
import com.uz.warehouse.Dtos.UsersDto;
import com.uz.warehouse.entity.Clients;
import com.uz.warehouse.entity.Users;

import java.util.List;

public interface UsersServiceInterface {

    List<Users> getAll();

    Users create(UsersDto dto);

    Users update(Integer id, UsersDto dto);

    void delete(Integer id);
}
