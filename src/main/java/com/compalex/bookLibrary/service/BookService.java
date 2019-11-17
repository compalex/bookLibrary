package com.compalex.bookLibrary.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.compalex.bookLibrary.api.annotations.Inject;
import com.compalex.bookLibrary.api.dao.IBookDAO;
import com.compalex.bookLibrary.api.dao.IStockDAO;
import com.compalex.bookLibrary.api.service.IBookService;
import com.compalex.bookLibrary.api.service.IStockService;
import com.compalex.bookLibrary.model.Book;
import com.compalex.bookLibrary.model.BookInstance;
import com.compalex.bookLibrary.utility.Constants.BookSort;
import com.compalex.bookLibrary.utility.Constants.StaleBookSort;
import com.compalex.bookLibrary.utility.ConfigHandler;
import com.compalex.bookLibrary.utility.Constants;
import com.compalex.bookLibrary.utility.Converter;

public class BookService implements IBookService {
    private static IBookService instance;
    @Inject(layer = Constants.Layer.DAO, type = Constants.Type.BOOK) 
    private IBookDAO bookDAO;
    @Inject(layer = Constants.Layer.DAO, type = Constants.Type.STOCK) 
    private IStockDAO stockDAO;
    
    private BookService() {
        //just to forbid regular initializing
    }
    
    public static IBookService getInstance() {
        if(instance == null) {
            instance = new BookService();
        }
        return instance;
    }
    
    @Override
    public List<Book> getAllBooks(BookSort sort) throws Exception {
        return bookDAO.getAllBooks();
    }
    
    @Override
    public Map<Book, List<Date>> getStaleBooks(StaleBookSort sort) throws Exception {
        List<Book> allBooks = bookDAO.getAllBooks();
        IStockService stockService = StockService.getInstance();
        List<BookInstance> booksInStock = stockService.getStock();
        return getStaleBooksMap(allBooks, booksInStock);
    }
    
    @Override
    public List<Book> getBookRequests() throws Exception {
        List<Book> allBooks = bookDAO.getAllBooks();
        List<Book> bookWithRequests = new ArrayList<>();
        
        for(Book book : allBooks) {
            if(book.getBookRequests().size() > 0) {
                bookWithRequests.add(book);
            }
        }
        return bookWithRequests;
    }
    
    @Override
    public String getBookDescription(int bookId) throws Exception {
        return bookDAO.getBook(bookId).getDescription();
    }
    
    @Override
    public boolean addBookToStock(Book book) throws Exception {    
        if(ConfigHandler.getInstance().getConfigs().autoRequest) {
            
            StockService.getInstance().deleteRequests(book);
        }
        BookInstance bookInstance = new BookInstance();
        bookInstance.setBook(book);
        bookInstance.setStoreDate(new Date());
        bookInstance.setBookType("stock");
        return stockDAO.addRecord(bookInstance);
    }

    private Map<Book, List<Date>> getStaleBooksMap(List<Book> books, List<BookInstance> bookInstance) throws Exception {
        bookInstance = Converter.getStaleBooks(bookInstance, 
                ConfigHandler.getInstance().getConfigs().unsoldMonth);
        Map<Book, List<Date>> map = new HashMap<>();
        
        for(Book book : books) {
            for(BookInstance bookInStock : bookInstance) {
                if(true) {
                    if(map.get(book) == null) {
                      //  map.put(book, new ArrayList<>());
                    }
                    map.get(book).add(bookInStock.getStoreDate());
                }
            }
        }
        return map;
    } 
}
