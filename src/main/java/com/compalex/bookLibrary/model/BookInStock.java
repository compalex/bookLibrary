package com.compalex.bookLibrary.model;

import java.util.Date;
import com.compalex.bookLibrary.api.model.IBookInStock;

public class BookInStock implements IBookInStock {
    private Integer id;
    private Integer bookId;
    private Date date;
    
    public BookInStock() {
      //used by dao
    }
    
    public BookInStock(int id, int bookId, Date date) {
        this.id = id;
        this.bookId = bookId;
        this.date = date;
    }
    
    @Override
    public int getId() {
        return id;
    }
    
    @Override
    public int getBookId() {
        return bookId;
    }
    
    @Override
    public Date getDate() {
        return date;
    }
}
