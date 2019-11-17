package com.compalex.bookLibrary.entry_point;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.compalex.bookLibrary.api.facade.ILibraryFacade;
import com.compalex.bookLibrary.di.InjectionHandler;
import com.compalex.bookLibrary.facade.LibraryFacade;
import com.compalex.bookLibrary.model.Book;
import com.compalex.bookLibrary.model.BookInstance;
import com.compalex.bookLibrary.model.Order;
import com.compalex.bookLibrary.utility.Constants.BookSort;
import com.compalex.bookLibrary.utility.Constants.OrderSort;
import com.compalex.bookLibrary.utility.Constants.RequestSort;
import com.compalex.bookLibrary.utility.Constants.StaleBookSort;

public class Demo {
    private static Logger logger = LogManager.getLogger(InjectionHandler.class);
    private static ILibraryFacade facade;
    
    public static void main(String args[]) {       
        try {
            InjectionHandler.doInjection();
        } catch (Exception e) {
            logger.error(e);
        }
        facade = LibraryFacade.getInstance();   
        try {
            //showBooks(BookSort.BY_TITLE);
            addBookToStock();
            //showOrders(OrderSort.BY_PRICE);
            //showBookRequests(RequestSort.BY_ALPHABET);
            //showStaleBooks(StaleBookSort.BY_DATE);
            //showBookDescription(2);
            //copyAnOrder(3);
            addBook();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addBook() {
        // TODO Auto-generated method stub
      //  facade.add
    }

    private static void addBookToStock() throws Exception {
        /*
        Book bookToAdd = new Book();
        bookToAdd.setId(228);
        bookToAdd.setTitle("FRICKING BOOK");
        bookToAdd.setDescription("really fricking one");
        bookToAdd.setPrice(228.23);
        */
        Book bookToAdd = facade.getAllBooks(BookSort.BY_PRICE).get(0);
        System.out.println(bookToAdd.getId());
        facade.addBookToStock(bookToAdd);
    }

    private static void showBooks(BookSort sort) throws Exception {   
        List<Book> books = facade.getAllBooks(sort);

        for(Book book : books) {
            System.out.println("____________");
            System.out.println(book.getId() + ". " + book.getTitle());
            System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(book.getPublicDate()));
            System.out.println(book.getPrice());
            System.out.println(book.getBookInstance().size() + " in stock");
            
            //if(book.getId() == 102) book.setPrice(book.getPrice());
        }
        
    }
    
    private static void showOrders(OrderSort sort) throws Exception {   
        List<Order> orders = facade.getAllOrders(sort);
        
        for(Order order : orders) {
            System.out.println("-------------");
            System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(order.getOrderDate()));
            System.out.println(order.getPrice());
            System.out.println(order.getStatus());
        }
    }
    
    private static void showBookRequests(RequestSort sort) throws Exception {
        Map<Book, Integer> bookRequests = facade.getBookRequests(RequestSort.BY_ALPHABET);
        
        for(Book book : bookRequests.keySet()) {
            System.out.println("__ __ ___ __ ___");
            System.out.println(book.getId() + ". " + book.getTitle());
            System.out.println(book.getPrice());
            System.out.println(bookRequests.get(book) + " requests");
        }
    }
    
    private static void showStaleBooks(StaleBookSort sort) throws Exception {
        Map<Book, List<Date>> books = facade.getStaleBooks(sort);

        for(Book book : books.keySet()) {
            for(Date date : books.get(book)) {
                System.out.println("____________");
                System.out.println(book.getId() + ". " + book.getTitle());
                System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(book.getPublicDate()));
                System.out.println(book.getPrice());
                System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(date));
            }
        }
    }
    
    private static void showBookDescription(int bookId) throws Exception {
        String description = facade.getBookDescription(bookId);
        System.out.println(description);
    }

    private static void copyAnOrder(int id) throws Exception {
        Order order = facade.getCopyOfOrder(id);
        
        System.out.println("-------------");
        System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(order.getOrderDate()));
        System.out.println(order.getPrice());
        System.out.println(order.getStatus());
    }
}
