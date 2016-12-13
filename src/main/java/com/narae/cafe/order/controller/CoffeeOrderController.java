package com.narae.cafe.order.controller;

import com.narae.cafe.coffee.domain.*;
import com.narae.cafe.coffee.dto.CoffeeDTO;
import com.narae.cafe.coffee.store.CoffeeInformationRepository;
import com.narae.cafe.exception.OrderNotProcessException;
import com.narae.cafe.order.domain.CoffeeOrder;
import com.narae.cafe.order.domain.OrderStatus;
import com.narae.cafe.order.dto.CoffeeOrderDTO;
import com.narae.cafe.order.store.CoffeeOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by existmaster on 2016. 12. 4..
 */
@RestController
@RequestMapping(path = "/orders")
public class CoffeeOrderController {

    @Autowired
    private CoffeeOrderRepository repository;

    @Autowired
    private CoffeeInformationRepository ciRepository;

    @RequestMapping(method = RequestMethod.POST)
    public CoffeeOrder newOrder(@RequestBody CoffeeOrder order){
        CoffeeOrder val = repository.findByUserIdAndOrderStatusNot(order.getUserId(), OrderStatus.COMPLETE);
        if(val != null) throw new OrderNotProcessException(order.getUserId());
        List<Coffee> coffees = order.getCoffees();
        for(Coffee coffee : coffees){
            ciRepository.findOne(coffee.getKeyName()).addCount(coffee.getCount());
        }
        return repository.save(order);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<CoffeeOrder> getAllOrders(){
        return repository.findAll();
    }

    @RequestMapping(path = "/current", method = RequestMethod.GET)
    public CoffeeOrderDTO getCurrentOrder(@RequestParam(value="userId") String userId){
        CoffeeOrder coffeeOrder = repository.findFirstByUserIdOrderByDateDesc(userId);
        return convertCoffeeOrderToDTO(coffeeOrder);
    }

    @RequestMapping(path = "/search_history", method = RequestMethod.GET)
    public List<CoffeeOrderDTO> getOrder(@RequestParam(value="userId") String userId){
        List<CoffeeOrder> coffeeOrders = repository.findByUserIdOrderByDateDesc(userId);
        return convertCoffeeOrdersToDTO(coffeeOrders);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public CoffeeOrder modifyOrderStatus(@RequestParam(value="userId") String userId, @RequestBody CoffeeOrder order){
        CoffeeOrder baseOrder = repository.findFirstByUserIdOrderByDateDesc(userId);
        baseOrder.setOrderStatus(order.getOrderStatus());
        return repository.save(baseOrder);
    }

    private List<CoffeeOrderDTO> convertCoffeeOrdersToDTO(List<CoffeeOrder> coffeeOrders) {
        List<CoffeeOrderDTO> coffeeOrderDTOList = new ArrayList<>();
        for(CoffeeOrder coffeeOrder : coffeeOrders){
            coffeeOrderDTOList.add(convertCoffeeOrderToDTO(coffeeOrder));
        }
        return coffeeOrderDTOList;
    }
    private CoffeeOrderDTO convertCoffeeOrderToDTO(CoffeeOrder coffeeOrder) {
        CoffeeOrderDTO dto = new CoffeeOrderDTO();
        dto.setSeq(coffeeOrder.getSeq());
        dto.setUserId(coffeeOrder.getUserId());
        dto.setDate(coffeeOrder.getDate());
        dto.setOrderStatus(coffeeOrder.getOrderStatus());

        List<CoffeeDTO> coffees = new ArrayList<>();
        for(Coffee coffee : coffeeOrder.getCoffees()){
            CoffeeDTO coffeeDTO = new CoffeeDTO();
            CoffeeInformation coffeeInformation = ciRepository.findOne(coffee.getKeyName());
            coffeeDTO.setKeyName(coffee.getKeyName());
            coffeeDTO.setCount(coffee.getCount());
            coffeeDTO.setTotalPrice(coffee.getTotalPrice());
            coffeeDTO.setSize(coffee.getSize());
            coffeeDTO.setTemperature(coffee.getTemperature());
            coffeeDTO.setCoffeeType(coffeeInformation.getCoffeeType());
            coffeeDTO.setKorName(coffeeInformation.getKorName());
            coffeeDTO.setEngName(coffeeInformation.getEngName());
            coffees.add(coffeeDTO);
        }

        dto.setCoffees(coffees);

        return dto;
    }

}
