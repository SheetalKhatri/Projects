package com.prestige.postalhmis.order.repository;

import com.prestige.postalhmis.enums.Status;
import com.prestige.postalhmis.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.net.ssl.SSLSession;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findOrderByStatus(Status status);
    Order findOrderById(int id);
    void deleteById(int id);
}
