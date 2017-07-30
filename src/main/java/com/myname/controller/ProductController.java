package com.myname.controller;

import com.myname.entity.Order;
import com.myname.entity.Product;
import com.myname.service.ProductService;
import com.myname.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(method = RequestMethod.GET, value = "/products/{sort}")
    public List<Product> getProductBySort(@PathVariable(value = "sort") String sort){
        return productService.getProductsOfSort(sort);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/product/{id}")
    public Product getProductById(@PathVariable(value = "id") int id){
        return productService.getProductById(id);
    }

    @RequestMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/products/{id}/orders")
    public List<Order> getProductOrders(@PathVariable(value = "id") int id){
        return productService.getProductOrders(id);
    }
}
