import datasets.*;
import dbservice.DBService;
import dbservice.DBServiceHibernateImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        DBService dbService = new DBServiceHibernateImpl();
        final SessionFactory sessionFactory;
        final EntityManagerFactory entityManagerFactory;
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Recipe.class);
        configuration.addAnnotatedClass(Ingredient.class);
        configuration.addAnnotatedClass(RecipeIngredient.class);
        configuration.addAnnotatedClass(Level.class);
        configuration.addAnnotatedClass(Cuisine.class);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(FoodCategory.class);
        configuration.addAnnotatedClass(Meal.class);
        configuration.addAnnotatedClass(NutritionalInformation.class);
        configuration.addAnnotatedClass(IngredientNutritionalInformation.class);
        configuration.addAnnotatedClass(Measurement.class);

        //sessionFactory = createSessionFactory(configuration);
        entityManagerFactory = Persistence.createEntityManagerFactory( "seniorproject.jpa.hibernate" );
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Recipe> criteria = builder.createQuery( Recipe.class );
        Root<Recipe> root = criteria.from( Recipe.class );
        criteria.select(root);
        TypedQuery<Recipe> query = entityManager.createQuery(criteria);
        List<Recipe> recipes = query.getResultList();
        recipes.forEach(System.out::println);

    }


    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

}
