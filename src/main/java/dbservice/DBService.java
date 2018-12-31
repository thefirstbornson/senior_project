package dbservice;


import datasets.Recipe;

import java.util.List;

public interface DBService  {
    <T> void save(T dataset);
    <T> T load( Class<T> clazz, long id);
    List<Recipe> loadRecipeByCriteria(Class<Recipe> clazz, long foodCategoryID, long courseID, long mealID);
}
