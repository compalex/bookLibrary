package com.compalex.bookLibrary.facade;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.compalex.bookLibrary.api.annotations.Inject;
import com.compalex.bookLibrary.api.facade.ILibraryFacade;
import com.compalex.bookLibrary.api.service.IBookService;
import com.compalex.bookLibrary.api.service.IOrderService;
import com.compalex.bookLibrary.api.service.IStockService;
import com.compalex.bookLibrary.model.Book;
import com.compalex.bookLibrary.model.BookInstance;
import com.compalex.bookLibrary.model.Order;
import com.compalex.bookLibrary.utility.Constants;
import com.compalex.bookLibrary.utility.Constants.BookSort;
import com.compalex.bookLibrary.utility.Constants.OrderSort;
import com.compalex.bookLibrary.utility.Constants.RequestSort;
import com.compalex.bookLibrary.utility.Constants.StaleBookSort;

public class LibraryFacade implements ILibraryFacade {
    private static ILibraryFacade instance;
    @Inject(layer = Constants.Layer.SERVICE, type = Constants.Type.BOOK)
    private IBookService bookService;
    @Inject(layer = Constants.Layer.SERVICE, type = Constants.Type.ORDER)
    private IOrderService orderService;
    @Inject(layer = Constants.Layer.SERVICE, type = Constants.Type.STOCK)
    private IStockService stockService;
    
    public static ILibraryFacade getInstance() {
        if(instance == null) {
            instance = new LibraryFacade();
        }
        return instance;
    }       
    
    @Override
    public Order getCopyOfOrder(int id) throws Exception {
        return orderService.getCopyOfOrder(id);
    }

    @Override
    public List<Book> getAllBooks(BookSort sort) throws Exception {
        return bookService.getAllBooks(sort);
    }

    @Override
    public Map<Book, List<Date>> getStaleBooks(StaleBookSort sort) throws Exception {
        return bookService.getStaleBooks(sort);
    }
    
    @Override
    public List<Order> getAllOrders(OrderSort sort) throws Exception {
        return orderService.getAllOrders(sort);
    }

    @Override
    public List<Book> getBookRequests(RequestSort sort) throws Exception {
        return bookService.getBookRequests();
    }

    @Override
    public String getBookDescription(int bookId) throws Exception {
        return bookService.getBookDescription(bookId);
    }

    @Override
    public boolean addOrder(Order order) {
        return orderService.addOrder(order);
    }

    @Override
    public boolean addBookToStock(Book book) throws Exception {
        return bookService.addBookToStock(book);
    }

    @Override
    public boolean addRequest(BookInstance request) {
        return false;
    }
}
