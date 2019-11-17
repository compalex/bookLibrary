package com.compalex.bookLibrary.utility;

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import com.compalex.bookLibrary.model.Book;
import com.compalex.bookLibrary.model.BookInstance;
import com.compalex.bookLibrary.model.Order;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Session activeSession;
    
    public static <T> List<T> fetchAllObjects(Class<T> classType) {
        Session session = getSessionFactory().openSession();
        CriteriaQuery<T> criteriaQuery = session.getCriteriaBuilder().createQuery(classType);
        criteriaQuery.from(classType);
        List<T> contacts = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return contacts;
    }
    
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Book.class);
            configuration.addAnnotatedClass(BookInstance.class);
            configuration.addAnnotatedClass(Order.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
    
    public static Session getActiveSession() {
        if(activeSession == null) {
            activeSession = getSessionFactory().openSession();
        }
        return activeSession;
    }
}
