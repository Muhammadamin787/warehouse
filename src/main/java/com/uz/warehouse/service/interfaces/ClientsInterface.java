package com.uz.warehouse.service.interfaces;

import com.uz.warehouse.Dtos.ClientDto;
import com.uz.warehouse.entity.Clients;

import java.util.List;

public interface ClientsInterface {

    List<Clients> getAllClients();

    Clients create(ClientDto dto);

    Clients update(Integer id, ClientDto dto);

    void delete(Integer id);
}
