package com.compalex.bookLibrary.api.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.compalex.bookLibrary.api.model.IBook;
import com.compalex.bookLibrary.utility.Constants;
import com.compalex.bookLibrary.utility.Constants.RequestSort;
import com.compalex.bookLibrary.utility.Constants.StaleBookSort;

public interface IBookService {
    Map<IBook, Integer> getAllBooks(Constants.BookSort sort) throws Exception;
    Map<IBook, Integer> getRequests(RequestSort sort) throws Exception;
    Map<IBook, List<Date>> getStaleBooks(StaleBookSort sort) throws Exception;
    String getBookDescription(int bookId) throws Exception;
    boolean addBookToStock(IBook book) throws Exception;
}
