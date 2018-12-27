package dbservice;


import java.util.List;

public interface DBService  {
    <T> void save(T dataset);
    <T> T load( Class<T> clazz, long id);
    //<T> List<T> readAll(Class<T> clazz);
}
