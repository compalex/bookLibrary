package com.compalex.bookLibrary.api.facade;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.compalex.bookLibrary.api.model.IBook;
import com.compalex.bookLibrary.api.model.IOrder;
import com.compalex.bookLibrary.api.model.IBookRequest;
import com.compalex.bookLibrary.utility.Constants.BookSort;
import com.compalex.bookLibrary.utility.Constants.OrderSort;
import com.compalex.bookLibrary.utility.Constants.RequestSort;
import com.compalex.bookLibrary.utility.Constants.StaleBookSort;

public interface ILibraryFacade {
    Map<IBook, Integer> getAllBooks(BookSort sort) throws Exception;
    List<IOrder> getAllOrders(OrderSort sort) throws Exception;
    Map<IBook, Integer> getAllRequests(RequestSort sort) throws Exception;
    Map<IBook, List<Date>> getStaleBooks(StaleBookSort sort) throws Exception;
    String getBookDescription(int bookId) throws Exception;
    boolean addOrder(IOrder order);
    boolean addBookToStock(IBook book) throws Exception;
    boolean addRequest(IBookRequest request);
    IOrder getCopyOfOrder(int id) throws Exception;
}
