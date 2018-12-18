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

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        DBService dbService = new DBServiceHibernateImpl();
        final SessionFactory sessionFactory;
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Recipe.class);
        configuration.addAnnotatedClass(Ingredient.class);
        configuration.addAnnotatedClass(RecipeIngredient.class);

        sessionFactory = createSessionFactory(configuration);

        Recipe recipe = new Recipe(
                "Курочка в чесночном соусе"
                ,""
                ,"Отбей толстую часть куриной грудки для того, чтобы толщина всего куска была равномерной.\n" +
                "2. Смешай в чашке воду, лимонный сок и мелко нарезанный чеснок, подогрей всё в микроволновке и хорошо перемешай.\n"
                ,new SimpleDateFormat("HH:mm:ss").parse("00:30:00")
                ,0
                ,0
                ,0
                ,""
        );
        Ingredient ingredient = new Ingredient(
            "Курица"
                ,170
        );

        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setRecipe(recipe);
        recipeIngredient.setIngredient(ingredient);
        recipeIngredient.setAmount(150);



        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.save(recipeIngredient);
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
