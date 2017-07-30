package com.myname.service.impl;

import com.myname.entity.*;
import com.myname.repository.OrderRepository;
import com.myname.service.ManagerService;
import com.myname.service.OrderService;
import com.myname.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private ProductService productService;

    private Manager manager;
    private Product product;

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAll() {
        List<Order> orders=new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    @Override
    public void saveOrder(Order order) throws NullPointerException {
        manager = managerService.getFreeManager();            //get free manager
        order.setManager(manager);                            //assign manager to order
        order.getProducts().forEach(product -> productService.decreaseQuantityOfProduct(product));
        orderRepository.save(order);
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.findOne(id);
    }

}
