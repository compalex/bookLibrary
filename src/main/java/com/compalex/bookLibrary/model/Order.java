package com.compalex.bookLibrary.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.compalex.bookLibrary.api.model.IModel;

@Entity(name="order")
@Table(name="orders")
public class Order implements IModel {
    @Id
    private Integer id;
    @Column(name="date")
    private Date orderDate;
    @Column(name="price")
    private Double price;
    @Column(name="status")
    private String status;
    @ManyToMany()
    private List<Book> books;
    
    public Order() {
      //used by dao
    }

    public int getId() {
        return id;
    }  
    
    public Date getOrderDate() {
        return orderDate;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getStatus() {
        return status;
    }
    
    public List<Book> getBooks() {
        return books;
    }
    
    public void setOrderedBooks(List<Book> books) {
        this.books = books;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Object clone() throws CloneNotSupportedException {
        return (Order)super.clone();
    }

    public Order getClone() throws CloneNotSupportedException {
        Order order = (Order) clone();
        order.setId(null);
        return order;
    }
}
