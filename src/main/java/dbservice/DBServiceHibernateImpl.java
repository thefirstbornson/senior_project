package dbservice;


import datasets.Ingredient;
import datasets.Recipe;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;


public class DBServiceHibernateImpl implements DBService {
    private Session session;
    private final SessionFactory sessionFactory;

    //private final DBCache dbCache;

    public DBServiceHibernateImpl() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = createSessionFactory(configuration);
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

//    public  void save(Recipe recipe) {
//        session.save(recipe);
//    }
//
//    public  void save(Ingredient ingredient) {
//        session.save(ingredient);
//    }


}