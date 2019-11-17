package com.compalex.bookLibrary.dao.sql;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.compalex.bookLibrary.api.dao.IModelDAO;
import com.compalex.bookLibrary.api.model.IModel;
import com.compalex.bookLibrary.utility.HibernateUtil;

public class ModelDAO implements IModelDAO {
    
    @Override
    public boolean addRecord(IModel model) {
        Session session = HibernateUtil.getActiveSession();
        Transaction transaction = session.beginTransaction();
        session.save(model);
        System.out.println("sup");
        transaction.commit();
        return true;
    }

    @Override
    public boolean deleteRecord(IModel model) {
        Session session = HibernateUtil.getActiveSession();
        session.remove(model);
        return true;
    }

    @Override
    public boolean updateRecord(IModel model, int id) {
        // TODO Auto-generated method stub
        return false;
    }
    
    
}
