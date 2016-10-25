package com.theironyard;

import javax.persistence.*;

/**
 * Created by Troy on 10/25/16.
 */
@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String date;

    @Column(nullable = false)
    String creditCard;

    @Column(nullable = false)
    int cvv;

    @Column(nullable = false)
    String category;

    @ManyToOne
    Customer customer;

    public Purchase(String date, String creditCard, int cvv, String category, Customer customer) {
        this.date = date;
        this.creditCard = creditCard;
        this.cvv = cvv;
        this.category = category;
        this.customer = customer;
    }

    public Purchase() {
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public int getCvv() {
        return cvv;
    }

    public String getCategory() {
        return category;
    }

    public Customer getCustomer() {
        return customer;
    }
}
