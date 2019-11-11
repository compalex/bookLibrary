package com.compalex.bookLibrary.api.service;

import java.util.List;
import com.compalex.bookLibrary.api.model.IOrder;
import com.compalex.bookLibrary.utility.Constants;

public interface IOrderService {
    
    List<IOrder> getAllOrders(Constants.OrderSort sort) throws Exception;
    boolean addOrder(IOrder order);
    IOrder getCopyOfOrder(int id) throws Exception;
}
