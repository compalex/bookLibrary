package com.compalex.bookLibrary.service;

import java.util.List;
import com.compalex.bookLibrary.api.annotations.Inject;
import com.compalex.bookLibrary.api.dao.IStockDAO;
import com.compalex.bookLibrary.api.model.IBookInStock;
import com.compalex.bookLibrary.api.service.IStockService;
import com.compalex.bookLibrary.utility.Constants;

public class StockService implements IStockService {
    @Inject(layer = Constants.Layer.DAO, type = Constants.Type.STOCK) 
    private IStockDAO stockDAO;
    private static IStockService instance;

    private StockService() {
        //just to forbid regular initializing
    }
    
    public static IStockService getInstance() {
        if(instance == null) {
            instance = new StockService();
        }
        return instance;
    }
    
    @Override
    public List<IBookInStock> getStock() throws Exception {
        return stockDAO.getStock();
    }
}
