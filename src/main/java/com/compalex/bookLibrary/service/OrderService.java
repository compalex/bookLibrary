package com.compalex.bookLibrary.service;

import java.util.List;
import com.compalex.bookLibrary.api.annotations.Inject;
import com.compalex.bookLibrary.api.dao.IOrderDAO;
import com.compalex.bookLibrary.api.service.IOrderService;
import com.compalex.bookLibrary.model.Order;
import com.compalex.bookLibrary.utility.Constants;
import com.compalex.bookLibrary.utility.Constants.OrderSort;

public class OrderService implements IOrderService {
    @Inject(layer = Constants.Layer.DAO, type = Constants.Type.ORDER) 
    private IOrderDAO orderDAO;
    private static IOrderService instance;

    private OrderService() {
        //just to forbid regular initializing
    }
    
    public static IOrderService getInstance() {
        if(instance == null) {
            instance = new OrderService();
        }
        return instance;
    }
    
    @Override
    public List<Order> getAllOrders(OrderSort sort) throws Exception {
        return orderDAO.getAllOrders();
    }

    @Override
    public boolean addOrder(Order order) {
        // TODO Auto-generated method stub
        return false;
    }
    
    @Override
    public Order getCopyOfOrder(int id) throws Exception {
        List<Order> orders = getAllOrders(OrderSort.BY_DATE);
        
        for(Order order : orders) {
            if(order.getId() == id) {
                return order.getClone();
            }
        }
        return null;
    }
}
