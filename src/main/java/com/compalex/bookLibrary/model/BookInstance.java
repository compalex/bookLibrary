package com.compalex.bookLibrary.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.compalex.bookLibrary.api.model.IModel;

@Entity(name="bookInstance")
@Table(name="stock")
public class BookInstance implements IModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="store_date")
    private Date storeDate;
    @Column(name="book_type")
    private String bookType;
    @ManyToOne()
    private Book book;
    
    public BookInstance() {
      //used by dao
    }
    
    public int getId() {
        return id;
    }
    
    public Date getStoreDate() {
        return storeDate;
    }

    public void setStoreDate(Date storeDate) {
        this.storeDate = storeDate;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public Book getBook() {
        return book;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }
}
