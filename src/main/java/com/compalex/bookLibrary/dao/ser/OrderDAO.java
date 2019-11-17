package com.compalex.bookLibrary.dao.ser;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.List;
import com.compalex.bookLibrary.api.dao.IOrderDAO;
import com.compalex.bookLibrary.model.Order;

public class OrderDAO extends ModelDAO implements IOrderDAO {

    public OrderDAO(String pathName) {
        super(pathName);
    }

    @Override
    public List<Order> getAllOrders() throws Exception {
        FileInputStream file = new FileInputStream(pathName);
        ObjectInputStream in = new ObjectInputStream(file);
        return (List<Order>)in.readObject();
    }

    @Override
    public List<Order> getCompletedOrdersOverTime(Date dateFrom, Date dateTo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getAmountOfFundsOverTime(Date dateFrom, Date dateTo) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getNumOfCompletedOrdersOverTime(Date dateFrom, Date dateTo) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Order getOrderDetails() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean addOrder(Order order) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean completeOrder(Order order) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean cancelOrder(Order book) {
        // TODO Auto-generated method stub
        return false;
    }
}
