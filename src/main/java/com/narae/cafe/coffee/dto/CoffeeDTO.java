package com.narae.cafe.coffee.dto;

import com.narae.cafe.coffee.domain.CoffeeSize;
import com.narae.cafe.coffee.domain.CoffeeTemp;
import com.narae.cafe.coffee.domain.CoffeeType;
import lombok.Data;

/**
 * Created by existmaster on 2016. 12. 7..
 */
@Data
public class CoffeeDTO {
    private String keyName;
    private int count;
    private int totalPrice;
    private CoffeeSize size;
    private CoffeeTemp temperature;

    private CoffeeType coffeeType;
    private String korName;
    private String engName;
}
