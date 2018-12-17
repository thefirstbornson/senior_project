import datasets.Ingredient;
import datasets.Recipe;
import datasets.RecipeIngredient;
import dbservice.DBService;
import dbservice.DBServiceHibernateImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {
    public static void main(String[] args) {
        DBService dbService = new DBServiceHibernateImpl();
        final SessionFactory sessionFactory;
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Recipe.class);
        configuration.addAnnotatedClass(Ingredient.class);
        configuration.addAnnotatedClass(RecipeIngredient.class);

        sessionFactory = createSessionFactory(configuration);

        Recipe recipe = new Recipe("")

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.save();
            transaction.commit();

        }
    }
    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

}
