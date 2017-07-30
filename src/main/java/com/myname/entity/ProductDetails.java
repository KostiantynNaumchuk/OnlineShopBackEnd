package com.myname.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="product_details")
public class ProductDetails {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name="id",nullable = false,length = 10)
    private  int id;
    @Column(name="weight")
    private float weight;
    @Column(name="height")
    private float height;
    @Column(name = "depth")
    private float depth;
    @Column(name = "width")
    private float width;

    @OneToOne(mappedBy = "productDetails")
    private Product product;

    public ProductDetails() {
    }

    public ProductDetails(int id, float weight, float height, float depth, float width) {
        this.id = id;
        this.weight = weight;
        this.height = height;
        this.depth = depth;
        this.width = width;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
