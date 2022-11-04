package com.uz.warehouse.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Clients extends AbsEntity{

    private String fullName;
    private String phoneNumber;
    private String address;


}


//done