package com.compalex.bookLibrary.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.compalex.bookLibrary.api.annotations.Inject;
import com.compalex.bookLibrary.api.dao.IStockDAO;
import com.compalex.bookLibrary.api.service.IStockService;
import com.compalex.bookLibrary.model.Book;
import com.compalex.bookLibrary.model.BookInstance;
import com.compalex.bookLibrary.utility.Constants;

public class StockService implements IStockService {
    @Inject(layer = Constants.Layer.DAO, type = Constants.Type.STOCK) 
    private IStockDAO stockDAO;
    private static IStockService instance;

    private StockService() {
        //just to forbid regular initializing
    }
    
    public static IStockService getInstance() {
        if(instance == null) {
            instance = new StockService();
        }
        return instance;
    }
    
    @Override
    public Map<Book, Integer> getBookRequests() {
        List<BookInstance> bookRequests = stockDAO.getBookRequests();
        System.out.println(bookRequests);
        Map<Book, Integer> map = new HashMap<>();
        Book book = null;

        for(BookInstance bookInstance : bookRequests) {
            book = bookInstance.getBook();
            if(map.get(book) == null) {
                map.put(book, 1);
            } else {
                map.put(book, map.get(book) + 1);
            }          
        }
        return map;
    }
    
    @Override
    public List<BookInstance> getStock() throws Exception {
        return stockDAO.getStock();
    }

    @Override
    public void deleteRequests(Book book) {
        for(BookInstance bookInstance : book.getBookRequests()) {
            stockDAO.deleteRecord(bookInstance);
        } 
    }
}
