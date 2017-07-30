package com.myname.service.impl;

import com.myname.entity.Order;
import com.myname.entity.Product;
import com.myname.repository.ProductRepository;
import com.myname.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Product> getProductsOfSort(String sort) {
        return productRepository.findProductsBySort(sort);
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProductById(int id) {
        return productRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        List<Product> products=new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public void decreaseQuantityOfProduct (Product product)throws NullPointerException {
        Product updatedProduct = productRepository.findOne(product.getId());
        int quantity = updatedProduct.getQuantityOnStock();
        if (quantity > 0) {
            updatedProduct.setQuantityOnStock(quantity - 1);
            productRepository.save(updatedProduct);
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public List<Order> getProductOrders(int id) {
        Product product=productRepository.findOne(id);
        return product.getOrders();
    }
}
