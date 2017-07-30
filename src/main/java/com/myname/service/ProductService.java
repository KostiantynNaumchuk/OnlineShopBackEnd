package com.myname.service;

import com.myname.entity.Order;
import com.myname.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductsOfSort(String sort);

    Product getProductById(int id);

    List<Product> getAllProducts();

    void decreaseQuantityOfProduct  (Product product) throws NullPointerException;

    List<Order> getProductOrders(int id);
}
