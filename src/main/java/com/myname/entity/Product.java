package com.myname.entity;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="products")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class Product implements Serializable{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name="id",nullable = false,length = 10)
    private int id;

    @Column(name="price")
    private float price;

    @Column(name="quantity_on_stock")
    private int quantityOnStock;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_image")
    private String productImage;

    @Column(name="product_sort")
    private String productSort;

    @OneToOne
    @JoinColumn(name="product_details_id")
    private ProductDetails productDetails;



    @ManyToMany
    @JoinTable(name="orders_products", joinColumns=@JoinColumn(name="product_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="order_id", referencedColumnName="id"))
    @JsonIgnore
    //@JsonBackReference(value="order-product")
    private List<Order> orders;

    public Product() {
    }

    public Product(int id, float price, int quantityOnStock, String productName, String productImage, String productSort) {
        this.id = id;
        this.price = price;
        this.quantityOnStock = quantityOnStock;
        this.productName=productName;
        this.productImage=productImage;
        this.productSort=productSort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantityOnStock() {
        return quantityOnStock;
    }

    public void setQuantityOnStock(int quantityOnStock) {
        this.quantityOnStock = quantityOnStock;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductSort() {
        return productSort;
    }

    public void setProductSort(String productSort) {
        this.productSort = productSort;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", quantityOnStock=" + quantityOnStock +
                ", productName='" + productName + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productSort='" + productSort + '\'' +
                ", productDetails=" + productDetails +
                ", orders=" + orders +
                '}';
    }
}
