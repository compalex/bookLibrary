package com.compalex.bookLibrary.utility;

public class Constants {
    public static final String PROPERTY_DATABASE = "DATABASE";
    public static final String PROPERTY_UNSOLD_MONTH = "UNSOLD_MONTH";
    public static final String PROPERTY_AUTOFILL = "AUTO_COMPLETE_REQUEST";   
    public static final String PATH_BOOK_SER = "db/ser/books.ser";
    public static final String PATH_BOOK_CSV = "db/csv/books.csv";
    public static final String PATH_ORDER_SER = "db/ser/orders.ser";
    public static final String PATH_ORDER_CSV = "db/csv/orders.csv";
    public static final String PATH_REQUEST_SER = "db/ser/bookRequests.ser";
    public static final String PATH_REQUEST_CSV = "db/csv/bookRequests.csv";
    public static final String PATH_STOCK_SER = "db/ser/stock.ser";
    public static final String PATH_STOCK_CSV = "db/csv/stock.csv";
    public static final String PATH_CONFIG_PROPERTIES = "config.properties";
    public static final String ERROR = "ERROR";
    public static final String GET_INSTANCE_METHOD = "getInstance";
    public static final String PACKAGE_NAME = "com.compalex.bookLibrary.service";
    
    public enum BookSort {
        BY_TITLE,
        BY_PUBLICATION_DATE,
        BY_PRICE,
        BY_STOCK_AVAILABILITY
    }
    
    public enum OrderSort {
        BY_DATE,
        BY_PRICE,
        BY_STATUS
    }
    
    public enum RequestSort {
        BY_QUANTITY,
        BY_ALPHABET
    }

    public enum StaleBookSort {
        BY_DATE,
        BY_PRICE
    }
    
    public enum Database {
        MY_SQL,
        SERIAL,
        CSV_FILES
    }
    
    public enum Type {
        BOOK,
        ORDER,
        REQUEST,
        STOCK,
        UNDEFINED
    }
    
    public enum Layer {
        DAO,
        SERVICE
    }
}
