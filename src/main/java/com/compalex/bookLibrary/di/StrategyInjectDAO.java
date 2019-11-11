package com.compalex.bookLibrary.di;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.compalex.bookLibrary.api.di.IInjectStrategy;
import com.compalex.bookLibrary.dao.DAOFactory;
import com.compalex.bookLibrary.utility.Constants;

public class StrategyInjectDAO implements IInjectStrategy {
    private static Logger logger = LogManager.getLogger(InjectionHandler.class);
    
    public Object getInjectObject(Constants.Type type) {
        try {
            switch(type) {
                case BOOK:
                    return DAOFactory.getBookDAO();
                case ORDER:
                    return DAOFactory.getOrderDAO();
                case REQUEST:
                    return DAOFactory.getRequestDAO();
                case STOCK:
                    return DAOFactory.getStockDAO();
                default:
                    return null;
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }
}
