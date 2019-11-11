package com.compalex.bookLibrary.dao.csv;

import java.io.File;
import java.util.List;
import com.compalex.bookLibrary.api.dao.IStockDAO;
import com.compalex.bookLibrary.api.model.IBookInStock;
import com.compalex.bookLibrary.model.BookInStock;
import com.compalex.bookLibrary.utility.Converter;

public class StockDAO extends ModelDAO implements IStockDAO {

    public StockDAO(String pathName) throws Exception {
        super(pathName);
    }

    @Override
    public List<IBookInStock> getStock() throws Exception {
        File file = new File(pathName);
        List<List<String>> records = Converter.getRecordsCVS(file);                
        Class<BookInStock> classType = BookInStock.class;
        List<IBookInStock> list = Converter.getListFromListOfList(classType, records);
        return list;
    }

    @Override
    public boolean addRecord(IBookInStock book) throws Exception {
        return super.addRecord(book);
    }
}
