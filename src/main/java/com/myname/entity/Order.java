package com.myname.entity;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name="orders")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class  , property = "id",scope=Order.class)
@JsonIgnoreProperties(ignoreUnknown = false)
public class Order implements Serializable {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name="id",nullable = false,length = 10)
    private int id;

    @Column(name="order_date")
    ///@NotNull
    private Date date;

    @Column(name="adress_to_deliver")
    private String adressToDeliver;

    @Column(name="contactemail")
    private String contactEmail;

    @ManyToMany
    @JoinTable(name="orders_products", joinColumns=@JoinColumn(name="order_id", referencedColumnName="id"),
               inverseJoinColumns=@JoinColumn(name="product_id", referencedColumnName="id"))
    //    @JsonManagedReference(value="order-product")
    private List<Product> products;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id")
    @JsonBackReference(value="order-user")
    private User user;

    @ManyToOne
    @JoinColumn(name="manager_id")
    @JsonBackReference(value="order-manager")
    private Manager manager;

    public Order() {
    }

    /*public Order(int id, String adressToDeliver, Date date ) {
        this.id = id;
        this.date = date;
        this.adressToDeliver = adressToDeliver;
    }*/

    public Order( String adressToDeliver, List<Product> products, User user,
                  Manager manager, Date date, String contactEmail) {
        this.date = date;
        this.adressToDeliver = adressToDeliver;
        this.products = products;
        this.user = user;
        this.manager = manager;
        this.contactEmail=contactEmail;
    }

 /*   public Order(int id, String adressToDeliver, List<Product> products, User user, Manager manager, Date date ) {
        this.id = id;
        this.adressToDeliver = adressToDeliver;
        this.products=products;
        this.user=user;
        this.manager=manager;
        this.date = date;

    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return date;
    }

    public void setData(Date data) {
        this.date = data;
    }

    public String getAdressToDeliver() {
        return adressToDeliver;
    }

    public void setAdressToDeliver(String adressToDeliver) {
        this.adressToDeliver = adressToDeliver;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> product) {
        this.products = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", adressToDeliver='" + adressToDeliver + '\'' +
                ", products=" + products +
                ", user=" + user +
                ", manager=" + manager +
                '}';
    }
}
