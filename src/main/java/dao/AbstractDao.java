package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public abstract class AbstractDao <T> implements Dao<T> {

    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public AbstractDao(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityTransaction = this.entityManager.getTransaction();
    }

    @Override
    public void persist(T object) {
        beginTransaction();
        entityManager.persist(object);
        commitTransaction();
    }

    @Override
    public T getByPK( Class<T> clazz,long key) {
        return entityManager.find(clazz, key);
    }

    @Override
    public void update(T object) {
        beginTransaction();
        entityManager.merge(object);
        commitTransaction();
    }

    @Override
    public void delete(T object) {
        beginTransaction();
        entityManager.remove(object);
        commitTransaction();
    }

    private void beginTransaction() {
        try {
            entityTransaction.begin();
        }
        catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    private void commitTransaction() {
        try {
            entityTransaction.commit();
            entityManager.close();
        }
        catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    private void rollbackTransaction() {
        try {
            entityTransaction.rollback();
        }
        catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
