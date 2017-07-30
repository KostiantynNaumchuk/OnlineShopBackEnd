package com.myname.service.impl;

import com.myname.entity.Manager;
import com.myname.entity.Order;
import com.myname.repository.ManagerRepository;
import com.myname.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerRepository managerRepository;


    public void assignManagerToOrder(){

    }

    @Override
    public List<Manager> getAll() {
        List<Manager> managers=new ArrayList<>();
        managerRepository.findAll().forEach(managers::add);
        return managers;
    }

    @Override
    public Manager getFreeManager() {
        List<Manager> managers=new ArrayList<>();
        managerRepository.findAll().forEach(managers::add);
        managers.sort((a, b) -> a.getOrders().size()-b.getOrders().size());
        if (managers.size()>0){return managers.get(0);}
        else {throw new NullPointerException();}
    }

    @Override
    public List<Order> getManagersOrders(int id) {
        Manager manager=managerRepository.findOne(id);
        return manager.getOrders();
    }
}
