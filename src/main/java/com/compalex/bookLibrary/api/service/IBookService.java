package com.compalex.bookLibrary.api.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.compalex.bookLibrary.model.Book;
import com.compalex.bookLibrary.model.BookInstance;
import com.compalex.bookLibrary.utility.Constants;
import com.compalex.bookLibrary.utility.Constants.RequestSort;
import com.compalex.bookLibrary.utility.Constants.StaleBookSort;

public interface IBookService {
    List<Book> getAllBooks(Constants.BookSort sort) throws Exception;
    Map<Book, List<Date>> getStaleBooks(StaleBookSort sort) throws Exception;
    String getBookDescription(int bookId) throws Exception;
    boolean addBookToStock(Book book) throws Exception;
    List<Book> getBookRequests() throws Exception;
}
