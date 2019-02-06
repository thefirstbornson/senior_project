package dao;

public interface Dao <T> {

    /** Создает новую запись, соответствующую объекту object */
    public void persist(T object)  ;

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public T getByPK(Class<T> clazz, long key);

    /** Сохраняет состояние объекта group в базе данных */
    public void update(T object) ;

    /** Удаляет запись об объекте из базы данных */
    public void delete(T object);

}
