package com.compalex.bookLibrary.model;

import java.util.Date;
import com.compalex.bookLibrary.api.model.IBook;

public class Book implements IBook {
    
    private Integer id;
    
    private String title;
    
    private Date date;
    
    private Double price;
    
    private String description;
    
    public Book() {  
      //used by dao
    }
    
    @Override
    public int getId() {
        return id;
    }
    
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Date getPublicationDate() {
        return date;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
