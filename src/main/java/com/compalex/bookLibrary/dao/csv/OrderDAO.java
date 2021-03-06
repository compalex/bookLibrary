package com.compalex.bookLibrary.dao.csv;

import java.io.File;
import java.util.Date;
import java.util.List;
import com.compalex.bookLibrary.api.dao.IOrderDAO;
import com.compalex.bookLibrary.model.Order;
import com.compalex.bookLibrary.utility.Converter;

public class OrderDAO extends ModelDAO implements IOrderDAO {

    public OrderDAO(String pathName) throws Exception {
        super(pathName);
    }
    
    @Override
    public List<Order> getAllOrders() throws Exception {
        File file = new File(pathName);
        List<List<String>> records = Converter.getRecordsCVS(file);                
        Class<Order> classType = Order.class;
        List<Order> list = Converter.getListFromListOfList(classType, records);
        return list;
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
