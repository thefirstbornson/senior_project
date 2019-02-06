package hibernate;

import dao.AbstractDao;

import javax.persistence.EntityManager;

public class HibMealDao extends AbstractDao {
    public HibMealDao(EntityManager entityManager) {
        super(entityManager);
    }
}
