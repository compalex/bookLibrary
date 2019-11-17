package com.compalex.bookLibrary.api.facade;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.compalex.bookLibrary.model.Book;
import com.compalex.bookLibrary.model.BookInstance;
import com.compalex.bookLibrary.model.Order;
import com.compalex.bookLibrary.utility.Constants.BookSort;
import com.compalex.bookLibrary.utility.Constants.OrderSort;
import com.compalex.bookLibrary.utility.Constants.RequestSort;
import com.compalex.bookLibrary.utility.Constants.StaleBookSort;

public interface ILibraryFacade {
    List<Book> getAllBooks(BookSort sort) throws Exception;
    List<Order> getAllOrders(OrderSort sort) throws Exception;
    Map<Book, Integer> getAllRequests(RequestSort sort) throws Exception;
    Map<Book, List<Date>> getStaleBooks(StaleBookSort sort) throws Exception;
    String getBookDescription(int bookId) throws Exception;
    boolean addOrder(Order order);
    boolean addBookToStock(Book book) throws Exception;
    Order getCopyOfOrder(int id) throws Exception;
    boolean addRequest(BookInstance request);
    Map<Book, Integer> getBookRequests(RequestSort byAlphabet);
}
