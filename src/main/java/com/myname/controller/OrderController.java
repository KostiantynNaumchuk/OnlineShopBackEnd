package com.myname.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myname.entity.Manager;
import com.myname.entity.Order;
import com.myname.entity.Product;
import com.myname.service.ManagerService;
import com.myname.service.OrderService;

import com.myname.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class OrderController {


    @Autowired
    private OrderService orderService;


  /*  @RequestMapping("/order/{id}")
    public Order getOrderById(@PathVariable(value = "id") int id){
       return orderService.getOrderById(id);
    }*/

    @RequestMapping(method = RequestMethod.GET, value = "/orders")
    public @ResponseBody List<Order> getAllOrders(){
        return orderService.getAll();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/order")
    public ResponseEntity<?> addOrder(@RequestBody String orderString){
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        Order order;
        HttpStatus status=HttpStatus.OK;
        try{
            order=objectMapper.readValue(orderString,Order.class);
            orderService.saveOrder(order);
        }catch (Exception e){
            e.printStackTrace();
            status=HttpStatus.BAD_REQUEST;
        }

        finally {
            return new ResponseEntity<>(status);
        }
    }

}
