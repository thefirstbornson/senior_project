import dao.Dao;
import dao.DaoFactory;
import datasets.*;
import dbservice.DBService;
import dbservice.DBServiceHibernateImpl;
import hibernate.HibernateDaoFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
      //  DBService dbService = new DBServiceHibernateImpl("seniorproject.jpa.hibernate.mysql" );
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("seniorproject.jpa.hibernate.mysql");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        DaoFactory factory = new HibernateDaoFactory(entityManager);
        Dao mealDao = factory.getDataSetDAO(Meal.class);
        Meal second_breakfast = new Meal("второй завтрак");
        mealDao.persist(second_breakfast);
        entityManager.close();

        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        DaoFactory factory1 = new HibernateDaoFactory(entityManager1);
        Dao mealDao1 = factory1.getDataSetDAO(Meal.class);

        Meal del_breakfast = (Meal) mealDao1.getByPK(Meal.class,second_breakfast.getId());
        mealDao1.delete(del_breakfast);

        Meal del_breakfast1 = (Meal) mealDao1.getByPK(Meal.class,10);
        mealDao1.delete(del_breakfast1);
        entityManager1.close();

    }

}
