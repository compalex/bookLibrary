package com.compalex.bookLibrary.dao.sql;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import com.compalex.bookLibrary.api.dao.IStockDAO;
import com.compalex.bookLibrary.api.model.IModel;
import com.compalex.bookLibrary.model.Book;
import com.compalex.bookLibrary.model.BookInstance;
import com.compalex.bookLibrary.utility.HibernateUtil;

public class StockDAO extends ModelDAO implements IStockDAO {
    private Class<BookInstance> classType;
    
    public StockDAO() {
        classType = BookInstance.class;
    }
    
    @Override
    public List<BookInstance> getStock() throws Exception {
        return HibernateUtil.fetchAllObjects(classType);
    }

    @Override
    public boolean addRecord(IModel model) {
        return false;
    }

    @Override
    public boolean deleteRecord(BookInstance book) {
        return super.deleteRecord(book);
    }

    @Override
    public boolean updateRecord(IModel model, int id) {
        return false;
    }

    @Override
    public boolean addRecord(BookInstance book) {
        return super.addRecord(book);
    }
}
