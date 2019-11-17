package com.compalex.bookLibrary.di;

import com.compalex.bookLibrary.api.di.InjectStrategy;
import com.compalex.bookLibrary.dao.DAOFactory;
import com.compalex.bookLibrary.utility.Constants;

public class StrategyInjectDAO implements InjectStrategy {
    public Object getInjectObject(Constants.Type type) throws Exception {
        switch (type) {
            case BOOK:
                return DAOFactory.getBookDAO();
            case ORDER:
                return DAOFactory.getOrderDAO();
            case STOCK:
                return DAOFactory.getStockDAO();
            default:
                return null;
            }
    }
}
