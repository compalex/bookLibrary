package com.compalex.bookLibrary.dao.ser;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.compalex.bookLibrary.api.dao.IModelDAO;
import com.compalex.bookLibrary.api.model.IModel;

public class ModelDAO implements IModelDAO {
    protected String pathName;
    
    public ModelDAO(String pathName) {
        this.pathName = pathName;
    }
    
    @Override
    public boolean addRecord(IModel model) throws Exception {
        FileOutputStream file = new FileOutputStream(pathName);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(model);
        out.close();
        file.close();
        return true;
    }
    
    public boolean addRecords(List<? extends IModel> models) throws Exception {
        FileOutputStream file = new FileOutputStream(pathName, false);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(models);
        out.close();
        file.close();
        return true;
    }

    @Override
    public boolean deleteRecord(IModel model) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateRecord(IModel model, int id) {
        // TODO Auto-generated method stub
        return false;
    }
}
