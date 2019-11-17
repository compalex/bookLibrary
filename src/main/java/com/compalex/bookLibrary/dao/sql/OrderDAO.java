package com.compalex.bookLibrary.dao.sql;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.compalex.bookLibrary.api.dao.IOrderDAO;
import com.compalex.bookLibrary.model.Order;
import com.compalex.bookLibrary.utility.HibernateUtil;

public class OrderDAO extends ModelDAO implements IOrderDAO {
    private Class<Order> classType;
    
    public OrderDAO() {
        classType = Order.class;
    }

    @Override
    public List<Order> getAllOrders() throws Exception {
        return HibernateUtil.fetchAllObjects(classType);
    }

    @Override
    public List<Order> getCompletedOrdersOverTime(Date dateFrom, Date dateTo) {
        return null;
    }

    @Override
    public double getAmountOfFundsOverTime(Date dateFrom, Date dateTo) {
        return 0;
    }

    @Override
    public int getNumOfCompletedOrdersOverTime(Date dateFrom, Date dateTo) {
        return 0;
    }

    @Override
    public Order getOrderDetails() {
        return null;
    }

    @Override
    public boolean addOrder(Order order) {
        Statement statement = null;
        try {
            //statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `orders` (`date`, `price`, `status`) VALUES ('"
                    + new SimpleDateFormat("yyyy/MM/dd").format(order.getOrderDate())
                    + "', "
                    + order.getPrice() 
                    + ", '"
                    + order.getStatus()
                    +"')");   
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                statement.close();
            } catch(SQLException ex) {
                System.err.print("Couldn't close DB connection");
                ex.printStackTrace();
            }
        }
    }

    @Override
    public boolean completeOrder(Order order) {
        return false;
    }

    @Override
    public boolean cancelOrder(Order book) {
        return false;
    }
}
