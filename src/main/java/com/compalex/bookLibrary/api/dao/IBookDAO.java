package com.compalex.bookLibrary.api.dao;

import java.util.List;
import com.compalex.bookLibrary.model.Book;

public interface IBookDAO {
    List<Book> getAllBooks() throws Exception;
    String getBookDescriprion(int bookId) throws Exception; 
    boolean addRecord(Book book) throws Exception;
}
