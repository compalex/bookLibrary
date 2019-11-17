package com.compalex.bookLibrary.api.dao;

import java.util.List;
import com.compalex.bookLibrary.model.BookInstance;

public interface IStockDAO {
    List<BookInstance> getStock() throws Exception;
    boolean addRecord(BookInstance book) throws Exception;
    List<BookInstance> getBookRequests();
    boolean deleteRecord(BookInstance book);
}
