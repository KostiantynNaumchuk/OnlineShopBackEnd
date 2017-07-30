package com.myname.service;

import com.myname.entity.Manager;
import com.myname.entity.Order;

import java.util.List;

public interface ManagerService {

    List<Manager> getAll();
    Manager getFreeManager();

    List<Order> getManagersOrders(int id);
}
