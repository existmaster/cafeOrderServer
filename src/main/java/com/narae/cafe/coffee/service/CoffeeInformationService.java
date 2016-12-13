package com.narae.cafe.coffee.service;

import com.narae.cafe.coffee.domain.CoffeeInformation;
import com.narae.cafe.coffee.store.CoffeeInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by existmaster on 2016. 11. 27..
 */
@Service
public class CoffeeInformationService {

    @Autowired
    private CoffeeInformationRepository repository;

    public Iterable<CoffeeInformation> viewCoffeeInformation(){
        return repository.findAll();
    }
}
