package com.compalex.bookLibrary.dao.ser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.compalex.bookLibrary.api.dao.IBookDAO;
import com.compalex.bookLibrary.api.model.IBook;
import com.compalex.bookLibrary.di.InjectionHandler;
import com.compalex.bookLibrary.utility.Constants;

public class BookDAO extends ModelDAO implements IBookDAO {
    private static Logger logger = LogManager.getLogger(InjectionHandler.class);
    
    public BookDAO(String pathName) {
        super(pathName);
    }

    @Override
    public List<IBook> getAllBooks() throws IOException {
        ObjectInputStream in = null;
        try {
            FileInputStream file = new FileInputStream(pathName);
            in = new ObjectInputStream(file);
            return (List<IBook>)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            logger.error(e);
        } finally {
            in.close();
        }
        return null;
    }

    @Override
    public String getBookDescriprion(int bookId) throws Exception {
        List<IBook> allBooks = getAllBooks();
        
        for(IBook book : allBooks) {
            if(book.getId() == bookId) {
                return book.getDescription();
            }
        }
        return Constants.ERROR;
    }

    @Override
    public boolean addRecord(IBook book) throws Exception {
        return super.addRecord(book);
    }
}
