package com.narae.cafe.coffee.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by existmaster on 2016. 11. 26..
 */
@Embeddable
@Data
public class Coffee {

    @Column(name = "key_name")
    private String keyName;

    @Column(name = "count")
    private int count;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "size")
    @Enumerated(EnumType.STRING)
    private CoffeeSize size;

    @Column(name = "temperature")
    @Enumerated(EnumType.STRING)
    private CoffeeTemp temperature;
}
