package com.uz.warehouse.service;

import com.uz.warehouse.Dtos.ClientDto;
import com.uz.warehouse.Dtos.UsersDto;
import com.uz.warehouse.entity.Clients;
import com.uz.warehouse.entity.Users;
import com.uz.warehouse.repository.UsersRepository;
import com.uz.warehouse.service.interfaces.UsersServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements UsersServiceInterface {
    @Autowired
    UsersRepository repository;

    @Override
    public List<Users> getAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @Override
    public Users create(UsersDto dto) {
        Users users = new Users();
        if (!repository.existsByFullName(dto.getFullName())){
            users.setFullName(dto.getFullName());
            users.setPhoneNumber(dto.getPhoneNumber());
            repository.save(users);

        } else {
            new Exception("Bunday malumot mavjud");
        }
        return users;
    }

    @Override
    public Users update(Integer id, UsersDto dto) {
        Users user = new Users();
        if (!repository.existsByFullNameEqualsIgnoreCaseAndIdNot(dto.getFullName(), dto.getId())) {
            user.setFullName(dto.getFullName());
            user.setPhoneNumber(dto.getPhoneNumber());
            repository.save(user);
        } else {
            new Exception("Bunday malumot mavjud emas");
        }
        return user;
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            new Exception("bunday malumot mavjud");
        } else {
            repository.deleteById(id);
        }
    }
}
