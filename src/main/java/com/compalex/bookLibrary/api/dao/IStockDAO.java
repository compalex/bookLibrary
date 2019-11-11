package com.compalex.bookLibrary.api.dao;

import java.util.List;
import com.compalex.bookLibrary.api.model.IBookInStock;

public interface IStockDAO {
    List<IBookInStock> getStock() throws Exception;
    boolean addRecord(IBookInStock book) throws Exception;
    
}
