package com.uz.warehouse.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Data
public class Calculate extends AbsEntity {

    @ManyToOne
    Clients clients;

    private BigDecimal sum;

    private String debit;

}
