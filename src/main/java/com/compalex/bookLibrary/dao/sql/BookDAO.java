package com.compalex.bookLibrary.dao.sql;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.compalex.bookLibrary.api.dao.IBookDAO;
import com.compalex.bookLibrary.model.Book;
import com.compalex.bookLibrary.utility.HibernateUtil;

public class BookDAO extends ModelDAO implements IBookDAO {
    private Class<Book> classType;
    
    public BookDAO() {
        classType = Book.class;
    }

    @Override
    public List<Book> getAllBooks() throws Exception {        
        return HibernateUtil.fetchAllObjects(classType);
    }

    @Override
    public String getBookDescriprion(int bookId) {
        return null;
    }

    @Override
    public boolean addRecord(Book book) throws Exception {
        return super.addRecord(book);
    }
}
