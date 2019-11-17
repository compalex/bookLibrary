package com.compalex.bookLibrary.api.dao;

import com.compalex.bookLibrary.api.model.IModel;

public interface IModelDAO {
    boolean addRecord(IModel model) throws Exception;
    boolean updateRecord(IModel model, int id);
    boolean deleteRecord(IModel model) throws Exception;
}
