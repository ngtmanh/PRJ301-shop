/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author admin
 */
public class Order {
    private int orderID;
    private String paymethod ;
    private int orderDetaiID;

    public Order() {
    }

    public Order(int orderID, String paymethod, int orderDetaiID) {
        this.orderID = orderID;
        this.paymethod = paymethod;
        this.orderDetaiID = orderDetaiID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }

    public int getOrderDetaiID() {
        return orderDetaiID;
    }

    public void setOrderDetaiID(int orderDetaiID) {
        this.orderDetaiID = orderDetaiID;
    }

    
    
}
