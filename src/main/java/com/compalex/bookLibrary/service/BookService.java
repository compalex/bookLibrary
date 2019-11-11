package com.compalex.bookLibrary.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.compalex.bookLibrary.api.annotations.Inject;
import com.compalex.bookLibrary.api.dao.IBookDAO;
import com.compalex.bookLibrary.api.dao.IStockDAO;
import com.compalex.bookLibrary.api.model.IBook;
import com.compalex.bookLibrary.api.model.IBookInStock;
import com.compalex.bookLibrary.api.model.IBookRequest;
import com.compalex.bookLibrary.api.service.IBookService;
import com.compalex.bookLibrary.api.service.IRequestService;
import com.compalex.bookLibrary.api.service.IStockService;
import com.compalex.bookLibrary.model.BookInStock;
import com.compalex.bookLibrary.utility.Constants.BookSort;
import com.compalex.bookLibrary.utility.Constants.RequestSort;
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
    public Map<IBook, Integer> getAllBooks(BookSort sort) throws Exception {
        List<IBook> allBooks = bookDAO.getAllBooks();
        IStockService stockService = StockService.getInstance();
        List<IBookInStock> booksInStock = stockService.getStock();
        return getBookStockMap(allBooks, booksInStock);
    }

    @Override
    public Map<IBook, Integer> getRequests(RequestSort sort) throws Exception {
        List<IBook> allBooks = bookDAO.getAllBooks();
        IRequestService requestService = RequestService.getInstance();
        List<IBookRequest> requests = requestService.getAllRequests();
        return getBookRequestMap(allBooks, requests);
    }
    
    @Override
    public Map<IBook, List<Date>> getStaleBooks(StaleBookSort sort) throws Exception {
        List<IBook> allBooks = bookDAO.getAllBooks();
        IStockService stockService = StockService.getInstance();
        List<IBookInStock> booksInStock = stockService.getStock();
        return getStaleBooksMap(allBooks, booksInStock);
    }
    
    @Override
    public String getBookDescription(int bookId) throws Exception {
        return bookDAO.getBookDescriprion(bookId);
    }
    
    @Override
    public boolean addBookToStock(IBook book) throws Exception {
        List<IBookInStock> booksInStock = StockService.getInstance().getStock();
        int previousId = booksInStock.get(booksInStock.size() - 1).getId();        
        if(ConfigHandler.getInstance().getConfigs().autoRequest) {
            IRequestService requestService = RequestService.getInstance();
            requestService.deleteRequests(book);
        }
        return stockDAO.addRecord(new BookInStock(previousId + 1, book.getId(), new Date()));
    }
    
    private Map<IBook, Integer> getBookStockMap(List<IBook> books, List<IBookInStock> booksInStock) {
        Map<IBook, Integer> map = new HashMap<>();
        
        for(IBook book : books) {
            int quantity = 0;
            
            for(IBookInStock bookInStock : booksInStock) {
                if(book.getId() == bookInStock.getBookId()) {
                    quantity++;
                }
            }
            map.put(book, quantity);
        }
        return map;
    }
    
    private Map<IBook, Integer> getBookRequestMap(List<IBook> books, List<IBookRequest> requests) {
        Map<IBook, Integer> map = new HashMap<>();
        
        for(IBook book : books) {
            int quantity = 0;
            
            for(IBookRequest request : requests) {
                if(book.getId() == request.getBookId()) {
                    quantity++;
                }
            }
            if(quantity > 0) {
                map.put(book, quantity); 
            }
        }
        return map;
    }

    private Map<IBook, List<Date>> getStaleBooksMap(List<IBook> books, List<IBookInStock> booksInStock) throws Exception {
        booksInStock = Converter.getStaleBooks(booksInStock, 
                ConfigHandler.getInstance().getConfigs().unsoldMonth);
        Map<IBook, List<Date>> map = new HashMap<>();
        
        for(IBook book : books) {
            for(IBookInStock bookInStock : booksInStock) {
                if(book.getId() == bookInStock.getBookId()) {
                    if(map.get(book) == null) {
                      //  map.put(book, new ArrayList<>());
                    }
                    map.get(book).add(bookInStock.getDate());
                }
            }
        }
        return map;
    } 
}
