/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class OrderDetails {
    private int orderDetailID;
    private String productName ;
    private int productID;
    private int quantity;
    private float price;
    private String productimage ;
    private int customerID;

    public OrderDetails() {
    }

    public OrderDetails(int orderDetailID, String productName, int productID, int quantity, float price, String productimage, int customerID) {
        this.orderDetailID = orderDetailID;
        this.productName = productName;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
        this.productimage = productimage;
        this.customerID = customerID;
    }

    public OrderDetails(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    

    

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProductimage() {
        return productimage;
    }

    public void setProductimage(String productimage) {
        this.productimage = productimage;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    
    
    
}
