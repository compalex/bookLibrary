package com.compalex.bookLibrary.api.service;

import java.util.List;
import java.util.Map;

import com.compalex.bookLibrary.model.Book;
import com.compalex.bookLibrary.model.BookInstance;

public interface IStockService {
    List<BookInstance> getStock() throws Exception;
    void deleteRequests(Book book);
}
