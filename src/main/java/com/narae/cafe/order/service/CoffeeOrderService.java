package com.narae.cafe.order.service;

import com.narae.cafe.order.domain.CoffeeOrder;
import com.narae.cafe.order.store.CoffeeOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by existmaster on 2016. 11. 27..
 */
@Service
public class CoffeeOrderService {

    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    public void CreateOrder(){
        CoffeeOrder order = new CoffeeOrder();
    }

}
