package com.uz.warehouse.repository;


import com.uz.warehouse.entity.Brand;
import com.uz.warehouse.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {


    boolean existsByFullNameEqualsIgnoreCaseAndIdNot(String name, Integer id);

    boolean existsByFullName(String name);

    List<Users> findAllByOrderByIdAsc();
}
