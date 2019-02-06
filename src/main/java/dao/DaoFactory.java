package dao;

import javax.persistence.EntityManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class DaoFactory {
    private EntityManager entityManager;

    public DaoFactory(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public <T extends Dao> T getDataSetDAO(Class klazz) {
        T itemDAO=null;
        try{
            String className=klazz.getName().substring(klazz.getName().lastIndexOf('.')+1);
            Class c = Class.forName(getClass().getPackageName()+".Hib" + className + "Dao");

            Constructor kl =  c.getConstructor(EntityManager.class);
            itemDAO = (T) kl.newInstance(entityManager);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | ClassNotFoundException | InvocationTargetException e) {
        e.printStackTrace();
        }
        return itemDAO;
    }
}