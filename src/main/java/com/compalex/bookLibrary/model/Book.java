package com.compalex.bookLibrary.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.compalex.bookLibrary.api.model.IModel;

@Entity(name="Book")
@Table(name="books")
public class Book implements IModel {
    @Id
    private Integer id;
    @Column(name="title")
    private String title;
    @Column(name="publication_date")
    private Date publicDate;
    @Column(name="price")
    private Double price;
    @Column(name="description")
    private String description;
    @ManyToMany(mappedBy="books")
    private List<Order> orders;
    @OneToMany(mappedBy="book", fetch=FetchType.EAGER)
    private List<BookInstance> bookInstance;
    
    public Book() {  
        //used by dao
      }
    
    public int getId() {
        return id;
    }
    
    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public List<BookInstance> getBookInstance() {
        return bookInstance;
    }

    public void setBooksInstance(List<BookInstance> bookInstance) {
        this.bookInstance = bookInstance;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public List<BookInstance> getBookRequests() {
        List<BookInstance> requests = new ArrayList<>();
        
        for(BookInstance instance : getBookInstance()) {
            if(instance.getBookType().equals("request")) {
                requests.add(instance);
            }
        }
        return requests;
    }
}
