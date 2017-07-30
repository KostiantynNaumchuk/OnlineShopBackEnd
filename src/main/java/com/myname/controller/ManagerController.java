package com.myname.controller;

import com.myname.entity.Manager;
import com.myname.entity.Order;
import com.myname.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping(method = RequestMethod.GET,value = "/managers")
    public List<Manager> getAllManagers(){
        return managerService.getAll();
    }
    @RequestMapping(method = RequestMethod.GET,value = "/managers/{id}/orders")
    public List<Order> getManagersOrders(@PathVariable (value = "id") int id){
        return managerService.getManagersOrders(id);
    }
}
