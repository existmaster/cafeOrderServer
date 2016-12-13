package com.narae.cafe.order.domain;

/**
 * Created by existmaster on 2016. 11. 26..
 */
public enum OrderStatus {
    ORDER, ACCEPT, MAKING, COMPLETE;

    public OrderStatus nextOrder(){
        if(this==OrderStatus.ORDER) return OrderStatus.ACCEPT;
        if(this==OrderStatus.ACCEPT) return OrderStatus.MAKING;
        if(this==OrderStatus.MAKING) return OrderStatus.COMPLETE;
        return OrderStatus.COMPLETE;
    }
}
