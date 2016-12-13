package com.narae.cafe.order.domain;

import com.narae.cafe.coffee.domain.Coffee;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by existmaster on 2016. 11. 26..
 */
@Entity @Data
public class CoffeeOrder {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coffee_order_seq")
    private long seq;

    @Column(name = "user_id")
    private String userId;

    private Date date = new Date();

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.ORDER;

    @ElementCollection
    @CollectionTable(
            name="coffee",
            joinColumns=@JoinColumn(name="ordered_coffee_id")
    )
    private List<Coffee> coffees;



}
