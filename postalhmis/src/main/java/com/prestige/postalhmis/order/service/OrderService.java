package com.prestige.postalhmis.order.service;

import com.prestige.postalhmis.order.entity.Order;

import java.util.List;

public interface OrderService {
   List<Order> findOrders();
   Order findOrderById(int id);
   Order save(Order order);
   void deleteById(int id);
}
