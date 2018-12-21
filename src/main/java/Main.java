import datasets.*;
import dbservice.DBService;
import dbservice.DBServiceHibernateImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

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
        configuration.addAnnotatedClass(Level.class);
        configuration.addAnnotatedClass(Cuisine.class);
        configuration.addAnnotatedClass(Course.class);
       // configuration.addAnnotatedClass(RecipeCourse.class);
        configuration.addAnnotatedClass(FoodCategory.class);
        configuration.addAnnotatedClass(RecipeFoodCategory.class);
        configuration.addAnnotatedClass(Meal.class);
        configuration.addAnnotatedClass(RecipeMeal.class);
        configuration.addAnnotatedClass(NutritionalInformation.class);
        configuration.addAnnotatedClass(IngredientNutritionalInformation.class);
        configuration.addAnnotatedClass(Measurement.class);

        sessionFactory = createSessionFactory(configuration);

        Level level = new Level(5);
        Cuisine cuisine = new Cuisine("Испанская кухня");
        Course course = new Course("Основное блюдо");
//        FoodCategory foodCategory = new FoodCategory("Птица");
//        Meal meal = new Meal("Обед");
//        Ingredient ingredient = new Ingredient("Курица");
//        NutritionalInformation protein =new NutritionalInformation("Белки");
//        NutritionalInformation fat =new NutritionalInformation("Жиры");
//        NutritionalInformation carbohydrate=new NutritionalInformation("Углеводы");
//        Measurement measurement = new Measurement("г");

        Recipe recipe = new Recipe(
                "Курочка в чесночном соусе"
                ,""
                ,"Отбей толстую часть куриной грудки для того, чтобы толщина всего куска была равномерной.\n" +
                "2. Смешай в чашке воду, лимонный сок и мелко нарезанный чеснок, подогрей всё в микроволновке и хорошо перемешай.\n"
                ,new SimpleDateFormat("HH:mm:ss").parse("00:30:00")
                ,level
                ,cuisine
                ,0
                ,""
        );
        recipe.addCourse(course);

//        IngredientNutritionalInformation ingrInf1 = new IngredientNutritionalInformation();
//        ingrInf1.setIngredient(ingredient);
//        ingrInf1.setNutritionanInformation(protein);
//        ingrInf1.setAmount(15);
//        IngredientNutritionalInformation ingrInf2 = new IngredientNutritionalInformation();
//        ingrInf2.setIngredient(ingredient);
//        ingrInf2.setNutritionanInformation(fat);
//        ingrInf2.setAmount(5);
//        IngredientNutritionalInformation ingrInf3 = new IngredientNutritionalInformation();
//        ingrInf3.setIngredient(ingredient);
//        ingrInf3.setNutritionanInformation(carbohydrate);
//        ingrInf3.setAmount(25);

//        RecipeCourse recipeCourse = new RecipeCourse();
//        recipeCourse.setRecipe(recipe);
//        recipeCourse.setCourse(course);

//        RecipeFoodCategory recipeFoodCategory = new RecipeFoodCategory();
//        recipeFoodCategory.setRecipe(recipe);
//        recipeFoodCategory.setFoodCategory(foodCategory);
//
//        RecipeMeal recipeMeal = new RecipeMeal();
//        recipeMeal.setRecipe(recipe);
//        recipeMeal.setMeal(meal);
//        RecipeIngredient recipeIngredient = new RecipeIngredient();
//        recipeIngredient.setRecipe(recipe);
//        recipeIngredient.setIngredient(ingredient);
//        recipeIngredient.setAmount(150);
//        recipeIngredient.setMeasurement(measurement);

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.save(recipe);
//            session.save(recipeIngredient);
//            //session.save(recipeCourse);
//            session.save(recipeFoodCategory);
//            session.save(recipeMeal);
//            session.save(ingrInf1);
//            session.save(ingrInf2);
//            session.save(ingrInf3);
            transaction.commit();

        }
//        System.out.println(recipe.getRecipeCourses());
//        System.out.println(recipe.getRecipeFoodCategories());
    }


    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

}
