package com.compalex.bookLibrary.di;

import com.compalex.bookLibrary.api.di.InjectStrategy;
import com.compalex.bookLibrary.service.ServiceFactory;
import com.compalex.bookLibrary.utility.Constants;

public class StrategyInjectService implements InjectStrategy {
    public Object getInjectObject(Constants.Type type) {
        switch(type) {
            case BOOK:
                return ServiceFactory.getBookService();
            case ORDER:
                return ServiceFactory.getOrderService();
            case STOCK:
                return ServiceFactory.getStockService();
            default:
                return null;
        }
    }
}
