package com.compalex.bookLibrary.dao.sql;

import java.sql.Connection;
import com.compalex.bookLibrary.api.dao.IModelDAO;
import com.compalex.bookLibrary.api.model.IModel;

public class ModelDAO implements IModelDAO {
    protected Connection connection;
    
    public ModelDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean addRecord(IModel model) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteRecord(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateRecord(IModel model, int id) {
        // TODO Auto-generated method stub
        return false;
    }
}
