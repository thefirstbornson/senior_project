import datasets.*;
import dbservice.DBService;
import dbservice.DBServiceHibernateImpl;

import javax.persistence.EntityManager;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        DBService dbService = new DBServiceHibernateImpl("seniorproject.jpa.hibernate.mysql" );
       // DBService dbServiceTest = new DBServiceHibernateImpl("seniorproject.jpa.hibernate.h2" );
        //dbServiceTest.save(new String("1"));

       // System.out.println(dbService.load(Recipe.class,1235));
        List<Recipe> recipes= ((DBServiceHibernateImpl) dbService).loadRecipeByCriteria(Recipe.class,5,1,2);
        recipes.forEach(System.out::println);

       // EntityManager entityManager = ((DBServiceHibernateImpl) dbService).getEntityManager();

        //entityManager.find(Recipe.class,1L);


//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

//        CriteriaQuery<Recipe> criteria = builder.createQuery( Recipe.class );
//        Root<Recipe> root = criteria.from( Recipe.class );
//        criteria.select(root);
//        TypedQuery<Recipe> query = entityManager.createQuery(criteria);
//        List<Recipe> recipes = query.getResultList();
//        recipes.forEach(System.out::println);

    }

}
