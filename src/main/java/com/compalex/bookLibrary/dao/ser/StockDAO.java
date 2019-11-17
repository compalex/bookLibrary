package com.compalex.bookLibrary.dao.ser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.compalex.bookLibrary.api.dao.IStockDAO;
import com.compalex.bookLibrary.di.InjectionHandler;
import com.compalex.bookLibrary.model.Book;
import com.compalex.bookLibrary.model.BookInstance;

public class StockDAO extends ModelDAO implements IStockDAO {
    private static Logger logger = LogManager.getLogger(InjectionHandler.class);

    public StockDAO(String pathName) {
        super(pathName);
    }

    @Override
    public List<BookInstance> getStock() throws IOException {
        FileInputStream file = null;
        ObjectInputStream in = null;
        try {
            file = new FileInputStream(pathName);
            in = new ObjectInputStream(file);
            return (List<BookInstance>)in.readObject();
        } catch (IOException e) {
            logger.error(e);
        } catch (ClassNotFoundException e) {
            logger.error(e);
        } finally {
            in.close();
            file.close();
        }
        return null;
    }

    @Override
    public boolean addRecord(BookInstance book) throws Exception {
        return false;
    }

    @Override
    public boolean deleteRecord(BookInstance book) {
        // TODO Auto-generated method stub
        return false;
    }
}
