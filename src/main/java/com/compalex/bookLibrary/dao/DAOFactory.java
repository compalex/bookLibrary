package com.compalex.bookLibrary.dao;

import com.compalex.bookLibrary.api.dao.IBookDAO;
import com.compalex.bookLibrary.api.dao.IOrderDAO;
import com.compalex.bookLibrary.api.dao.IStockDAO;
import com.compalex.bookLibrary.utility.ConfigHandler;
import com.compalex.bookLibrary.utility.Constants;

public class DAOFactory {
    public static IBookDAO getBookDAO() throws Exception {
        switch(ConfigHandler.getInstance().getConfigs().database) {
            case MY_SQL:
                return new com.compalex.bookLibrary.dao.sql.BookDAO();
            case SERIAL:
                return new com.compalex.bookLibrary.dao.ser.BookDAO(Constants.PATH_BOOK_SER);
            case CSV_FILES:
                return new com.compalex.bookLibrary.dao.csv.BookDAO(Constants.PATH_BOOK_CSV);
            default:
                return null;
        }
    }
    
    public static IOrderDAO getOrderDAO() throws Exception {
        switch(ConfigHandler.getInstance().getConfigs().database) {
            case MY_SQL:
                return new com.compalex.bookLibrary.dao.sql.OrderDAO();
            case SERIAL:
                return new com.compalex.bookLibrary.dao.ser.OrderDAO(Constants.PATH_ORDER_SER);
            case CSV_FILES:
                return new com.compalex.bookLibrary.dao.csv.OrderDAO(Constants.PATH_ORDER_CSV);
            default:
                return null;
        }
    }

    public static IStockDAO getStockDAO() throws Exception {
        switch(ConfigHandler.getInstance().getConfigs().database) {
            case MY_SQL:
                return new com.compalex.bookLibrary.dao.sql.StockDAO();
            case SERIAL:
                return new com.compalex.bookLibrary.dao.ser.StockDAO(Constants.PATH_STOCK_SER);
            case CSV_FILES:
                return new com.compalex.bookLibrary.dao.csv.StockDAO(Constants.PATH_STOCK_CSV);
            default:
                return null;
        }
    }
}