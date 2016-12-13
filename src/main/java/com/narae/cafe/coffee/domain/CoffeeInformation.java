package com.narae.cafe.coffee.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 * Created by existmaster on 2016. 11. 26..
 */
@Entity @Data
public class CoffeeInformation {

    @Id
    private String keyName;
    private String engName;
    private String korName;

    @Enumerated(EnumType.STRING)
    private CoffeeType coffeeType;
    private int price;

    private int sellCount;

    public void addCount(int count){
        this.sellCount = this.sellCount + count;
    }
}
