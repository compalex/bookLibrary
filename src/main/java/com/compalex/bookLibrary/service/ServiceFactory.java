package com.compalex.bookLibrary.service;

import com.compalex.bookLibrary.api.service.IBookService;
import com.compalex.bookLibrary.api.service.IOrderService;
import com.compalex.bookLibrary.api.service.IStockService;

public class ServiceFactory {
    public static IBookService getBookService() {
        return BookService.getInstance();
    }
    
    public static IOrderService getOrderService() {
        return OrderService.getInstance();
    }
    
    public static IStockService getStockService() {
        return StockService.getInstance();
    }
}
