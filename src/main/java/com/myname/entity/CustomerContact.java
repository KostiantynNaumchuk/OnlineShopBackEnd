package com.myname.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="contact_details")
public class CustomerContact {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name="id",nullable = false,length = 10)
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="default_adress")
    private String defaultAdress;

   /* @OneToOne(mappedBy = "customerContact")
    private User user;*/

    public CustomerContact() {
    }

    public CustomerContact(int id,  String firstName, String lastName, String email, String defaultAdress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.defaultAdress = defaultAdress;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDefaultAdress() {
        return defaultAdress;
    }

    public void setDefaultAdress(String defaultAdress) {
        this.defaultAdress = defaultAdress;
    }
}
