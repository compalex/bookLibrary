package com.compalex.bookLibrary.model;

import java.util.Date;
import com.compalex.bookLibrary.api.model.IOrder;

public class Order implements IOrder {

    private Integer id;
    private Date orderDate;
    private Double price;
    private String status;
    
    public Order() {
      //used by dao
    }

    @Override
    public int getId() {
        return id;
    }  
    
    @Override
    public Date getOrderDate() {
        return orderDate;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
    
    @Override
    public String getStatus() {
        return status;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Order)super.clone();
    }

    @Override
    public IOrder getClone() throws CloneNotSupportedException {
        IOrder order = (IOrder) clone();
        order.setId(null);
        return order;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
