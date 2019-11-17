package com.compalex.bookLibrary.dao.csv;

import java.io.File;
import java.util.List;
import com.compalex.bookLibrary.api.dao.IStockDAO;
import com.compalex.bookLibrary.model.Book;
import com.compalex.bookLibrary.model.BookInstance;
import com.compalex.bookLibrary.utility.Converter;

public class StockDAO extends ModelDAO implements IStockDAO {

    public StockDAO(String pathName) throws Exception {
        super(pathName);
    }

    @Override
    public List<BookInstance> getStock() throws Exception {
        File file = new File(pathName);
        List<List<String>> records = Converter.getRecordsCVS(file);                
        Class<BookInstance> classType = BookInstance.class;
        List<BookInstance> list = Converter.getListFromListOfList(classType, records);
        return list;
    }

    @Override
    public boolean addRecord(BookInstance book) throws Exception {
        return super.addRecord(book);
    }

    @Override
    public boolean deleteRecord(BookInstance book) {
        // TODO Auto-generated method stub
        return false;
    }
}
