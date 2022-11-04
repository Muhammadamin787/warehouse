package com.uz.warehouse.repository;

import com.uz.warehouse.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Integer> {
    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByFullNameEqualsIgnoreCaseAndPhoneNumber(String fullName, String phoneNumber);


}
