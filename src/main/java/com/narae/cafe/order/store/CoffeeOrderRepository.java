package com.narae.cafe.order.store;

import com.narae.cafe.order.domain.CoffeeOrder;
import com.narae.cafe.order.domain.OrderStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by existmaster on 2016. 11. 26..
 */
@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface CoffeeOrderRepository extends CrudRepository<CoffeeOrder, Long>{

    List<CoffeeOrder> findByUserId(String userId);
    List<CoffeeOrder> findByUserIdOrderByDateDesc(String userId);
    CoffeeOrder findByUserIdAndOrderStatus(String userId, OrderStatus orderStatus);
    CoffeeOrder findByUserIdAndOrderStatusNot(String userId, OrderStatus orderStatus);
    CoffeeOrder findFirstByUserIdOrderByDateDesc(String userId);
    List<CoffeeOrder> findByOrderByDateDesc();

}
