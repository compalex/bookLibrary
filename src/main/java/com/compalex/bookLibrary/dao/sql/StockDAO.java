package com.compalex.bookLibrary.dao.sql;

import java.sql.Connection;
import java.util.List;
import com.compalex.bookLibrary.api.dao.IStockDAO;
import com.compalex.bookLibrary.api.model.IBookInStock;
import com.compalex.bookLibrary.api.model.IModel;

public class StockDAO extends ModelDAO implements IStockDAO {

    public StockDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<IBookInStock> getStock() throws Exception {
        return null;
    }

    @Override
    public boolean addRecord(IModel model) throws Exception {
        return false;
    }

    @Override
    public boolean deleteRecord(int id) {
        return false;
    }

    @Override
    public boolean updateRecord(IModel model, int id) {
        return false;
    }

    @Override
    public boolean addRecord(IBookInStock book) throws Exception {
        return false;
    }
}
