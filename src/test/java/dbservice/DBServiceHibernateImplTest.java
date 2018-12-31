package dbservice;

import datasets.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DBServiceHibernateImplTest {
    private Recipe recipe;
    DBService dbService;

    public DBServiceHibernateImplTest() {
        this.dbService = new DBServiceHibernateImpl("seniorproject.jpa.hibernate.h2" );
    }


    @Before
    public void initialize() {
        recipe = new DBServiceHibernateImplTest().createRecipe();
        System.out.println(recipe.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void saveNull() {
        dbService.save(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void saveNotDataset() {
        dbService.save("test");
    }

    @Test
    public void loadRecipe() {
        long id =1;
        dbService.save(recipe);
        assertEquals("Проверка возврата RecipeID", id, dbService.load(Recipe.class,id).getId());
    }

    @Test(expected = NullPointerException.class)
    public void loadWrongID() {
        long id =6;
        dbService.save(recipe);
        dbService.load(Recipe.class,id).getId();
    }

    @Test
    public void loadRecipeByCriteria(){
        dbService.save(recipe);
        List<Recipe> recipes= dbService.loadRecipeByCriteria(Recipe.class,1,1,1);
        assertTrue("Проверка возврата списка рецептов согласно критериям",recipes.size()>0);
    }

    private Recipe createRecipe() {
        Level level = new Level(5);
        Cuisine cuisine = new Cuisine("Испанская кухня");
        Course course = new Course("Основное блюдо");
        FoodCategory foodCategory = new FoodCategory("Птица");
        Meal meal = new Meal("Обед");
        Ingredient ingredient = new Ingredient("Курица");
        NutritionalInformation protein =new NutritionalInformation("Белки");
        NutritionalInformation fat =new NutritionalInformation("Жиры");
        NutritionalInformation carbohydrate=new NutritionalInformation("Углеводы");
        Measurement measurement = new Measurement("г");
        Recipe recipe = new Recipe(
                "Курочка в чесночном соусе"
                ,""
                ,"Отбей толстую часть куриной грудки для того, чтобы толщина всего куска была равномерной.\n" +
                "2. Смешай в чашке воду, лимонный сок и мелко нарезанный чеснок, подогрей всё в микроволновке и хорошо перемешай.\n"
                ,30
                ,level
                ,cuisine
                ,0
                ,""
        );
        recipe.addCourse(course);
        recipe.addFoodCategory(foodCategory);
        recipe.addMeal(meal);

        IngredientNutritionalInformation ingrInf1 = new IngredientNutritionalInformation();
        ingrInf1.setIngredient(ingredient);
        ingrInf1.setNutritionanInformation(protein);
        ingrInf1.setAmount(15);

        IngredientNutritionalInformation ingrInf2 = new IngredientNutritionalInformation();
        ingrInf2.setIngredient(ingredient);
        ingrInf2.setNutritionanInformation(fat);
        ingrInf2.setAmount(5);

        IngredientNutritionalInformation ingrInf3 = new IngredientNutritionalInformation();
        ingrInf3.setIngredient(ingredient);
        ingrInf3.setNutritionanInformation(carbohydrate);
        ingrInf3.setAmount(25);

        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setRecipe(recipe);
        recipeIngredient.setIngredient(ingredient);
        recipeIngredient.setAmount(150);
        recipeIngredient.setMeasurement(measurement);

        return recipe;
    }
}