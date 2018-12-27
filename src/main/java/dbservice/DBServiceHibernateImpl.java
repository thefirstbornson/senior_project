package dbservice;

import datasets.Course;
import datasets.FoodCategory;
import datasets.Meal;
import datasets.Recipe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.io.Serializable;
import java.util.List;


public class DBServiceHibernateImpl implements DBService {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    //private final DBCache dbCache;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public DBServiceHibernateImpl(String persistenceUnitname) {
        entityManagerFactory = Persistence.createEntityManagerFactory( persistenceUnitname);
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public <T> void save(T dataset) {
        entityManager.getTransaction().begin();
        entityManager.persist(dataset);
        entityManager.getTransaction().commit();
    }

    @Override
    public <T> T load( Class<T> clazz,long id) {
        entityManager.getTransaction().begin();
        T dataset = entityManager.find(clazz,id);
        entityManager.getTransaction().commit();
        return dataset;
    }

    public List<Recipe> loadRecipeByCriteria(Class<Recipe> clazz, long foodCategoryID,long courseID,long mealID){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Recipe> criteria = builder.createQuery( clazz );
        Root<Recipe> recipeRoot= criteria.from(Recipe.class);
        Join<Recipe,FoodCategory> foodCategoriesJoin = recipeRoot.join("foodCategories");
        Join<Recipe,Course> courseJoin = recipeRoot.join("courses");
        Join<Recipe,Meal> mealJoin = recipeRoot.join("meals");
        criteria.where(builder.equal(foodCategoriesJoin.get("id"),foodCategoryID));
        criteria.where(builder.equal(courseJoin.get("id"),courseID));
        criteria.where(builder.equal(mealJoin.get("id"),mealID));
        return entityManager.createQuery(criteria).getResultList();


//        CriteriaBuilder cb = em.getCriteriaBuilder(); //creted from EntityManager instance
//        CriteriaQuery<Long> cq = cb.createQuery(Collaborator.class);
//        Root<Answer> rootAnswer = cq.from(Answer.class);
//        Join<Collaborator,Answer> joinAnswerCollaborator = rootAnswer.join("collaborators"); //(or rootAnswer.join(Answer_.collaborators); if you've created the metamodel with JPA2


    }


}