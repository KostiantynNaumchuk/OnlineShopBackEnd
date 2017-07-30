package com.myname.service;

import com.myname.entity.Manager;
import com.myname.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    void saveOrder(Order order);
    Order getOrderById(int id);
}
