package com.compalex.bookLibrary.api.service;

import java.util.List;
import com.compalex.bookLibrary.model.Order;
import com.compalex.bookLibrary.utility.Constants;

public interface IOrderService {
    List<Order> getAllOrders(Constants.OrderSort sort) throws Exception;
    boolean addOrder(Order order);
    Order getCopyOfOrder(int id) throws Exception;
}
