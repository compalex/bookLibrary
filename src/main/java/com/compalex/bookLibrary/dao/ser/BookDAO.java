package com.compalex.bookLibrary.dao.ser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.compalex.bookLibrary.api.dao.IBookDAO;
import com.compalex.bookLibrary.di.InjectionHandler;
import com.compalex.bookLibrary.model.Book;
import com.compalex.bookLibrary.utility.Constants;

public class BookDAO extends ModelDAO implements IBookDAO {
    private static Logger logger = LogManager.getLogger(InjectionHandler.class);
    
    public BookDAO(String pathName) {
        super(pathName);
    }

    @Override
    public List<Book> getAllBooks() throws IOException {
        ObjectInputStream in = null;
        try {
            FileInputStream file = new FileInputStream(pathName);
            in = new ObjectInputStream(file);
            return (List<Book>)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            logger.error(e);
        } finally {
            in.close();
        }
        return null;
    }

    @Override
    public String getBookDescriprion(int bookId) throws Exception {
        List<Book> allBooks = getAllBooks();
        
        for(Book book : allBooks) {
            if(book.getId() == bookId) {
                return book.getDescription();
            }
        }
        return Constants.ERROR;
    }

    @Override
    public boolean addRecord(Book book) throws Exception {
        return super.addRecord(book);
    }
}
