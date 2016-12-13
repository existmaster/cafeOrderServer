package com.narae.cafe.order.dto;

import com.narae.cafe.coffee.dto.CoffeeDTO;
import com.narae.cafe.order.domain.OrderStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by existmaster on 2016. 12. 7..
 */
@Data
public class CoffeeOrderDTO {

    private long seq;

    private String userId;

    private Date date;

    private OrderStatus orderStatus;

    private List<CoffeeDTO> coffees;

}
