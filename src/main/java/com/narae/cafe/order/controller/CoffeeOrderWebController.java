package com.narae.cafe.order.controller;

import com.narae.cafe.order.domain.CoffeeOrder;
import com.narae.cafe.order.store.CoffeeOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by existmaster on 2016. 12. 8..
 */
@Controller
@RequestMapping("/web")
public class CoffeeOrderWebController {

    @Autowired
    private CoffeeOrderRepository repository;

    @RequestMapping(path = "/order", method = RequestMethod.GET)
    public String order(Model model) {
        model.addAttribute("name", "Springboot");
        return "hello";
    }

    @RequestMapping(path = "ordermanager", method = RequestMethod.GET)
    public String orderManage(Model model) {
        Iterable<CoffeeOrder> coffeeOrders = repository.findByOrderByDateDesc();
        model.addAttribute("order", coffeeOrders);
        return "order";
    }
}
