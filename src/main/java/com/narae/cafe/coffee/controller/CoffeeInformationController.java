package com.narae.cafe.coffee.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.narae.cafe.coffee.domain.CoffeeInformation;
import com.narae.cafe.coffee.service.CoffeeInformationService;
import com.narae.cafe.coffee.store.CoffeeInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by existmaster on 2016. 11. 27..
 */
@RestController
public class CoffeeInformationController {

    @Autowired
    private CoffeeInformationService service;

    @Autowired
    private CoffeeInformationRepository repository;

    @RequestMapping(path = "/coffeeinfo")
    public Iterable<CoffeeInformation> findAllCoffeeInformation(){
        return service.viewCoffeeInformation();
    }

    @RequestMapping(path = "/coffeeinfo/top5")
    public Iterable<CoffeeInformation> top5CoffeeInformation() {
        return repository.findTop5ByOrderBySellCountDesc();
    }
}
