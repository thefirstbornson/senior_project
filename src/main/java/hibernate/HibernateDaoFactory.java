package hibernate;

import dao.DaoFactory;

import javax.persistence.EntityManager;

public class HibernateDaoFactory extends DaoFactory {
    public HibernateDaoFactory(EntityManager entityManager) {
        super(entityManager);
    }
}
