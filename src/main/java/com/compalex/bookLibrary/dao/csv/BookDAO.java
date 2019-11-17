package com.compalex.bookLibrary.dao.csv;

import java.io.File;
import java.util.List;
import com.compalex.bookLibrary.api.dao.IBookDAO;
import com.compalex.bookLibrary.model.Book;
import com.compalex.bookLibrary.utility.Converter;

public class BookDAO extends ModelDAO implements IBookDAO {
    
    public BookDAO(String pathName) throws Exception {
        super(pathName);
    }

    @Override
    public List<Book> getAllBooks() throws Exception {
        File file = new File(pathName);
        List<List<String>> records = Converter.getRecordsCVS(file);                
        Class<Book> classType = Book.class;
        List<Book> list = Converter.getListFromListOfList(classType, records);
        return list;
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
