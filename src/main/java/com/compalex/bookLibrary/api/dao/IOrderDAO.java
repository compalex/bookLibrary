package com.compalex.bookLibrary.api.dao;

import java.util.Date;
import java.util.List;
import com.compalex.bookLibrary.model.Order;

public interface IOrderDAO {
    public List<Order> getAllOrders() throws Exception;
    public List<Order> getCompletedOrdersOverTime(Date dateFrom, Date dateTo);
    public double getAmountOfFundsOverTime(Date dateFrom, Date dateTo);
    public int getNumOfCompletedOrdersOverTime(Date dateFrom, Date dateTo);
    public Order getOrderDetails(); 
    public boolean addOrder(Order order);
    public boolean completeOrder(Order order);
    public boolean cancelOrder(Order book);
}
