package com.uz.warehouse.service;

import com.uz.warehouse.Dtos.ClientDto;
import com.uz.warehouse.entity.Clients;
import com.uz.warehouse.repository.ClientsRepository;
import com.uz.warehouse.service.interfaces.ClientsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsService implements ClientsInterface {
    @Autowired
    ClientsRepository repository;


    @Override
    public List<Clients> getAllClients() {
        return repository.findAll();
    }

    @Override
    public Clients create(ClientDto dto) {
        Clients clients = new Clients();
        if (!repository.existsByPhoneNumber(dto.getPhoneNumber())) {
            clients.setFullName(dto.getFullName());
            clients.setAddress(dto.getAddress());
            clients.setPhoneNumber(dto.getPhoneNumber());
            repository.save(clients);
        } else {
            new Exception("Bunday malumot mavjud");
        }
        return clients;
    }

    @Override
    public Clients update(Integer id, ClientDto dto) {
        Clients clients = new Clients();
        if (repository.existsById(dto.getId())) {
            clients.setId(dto.getId());
            clients.setFullName(dto.getFullName());
            clients.setPhoneNumber(dto.getPhoneNumber());
            clients.setAddress(dto.getAddress());
            repository.save(clients);
        } else {
            new Exception("Bundam Client mavjud");
        }
        return clients;
    }

    @Override
    public void delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            new Exception("Malumot o'chirildi");
        }
    }
}
