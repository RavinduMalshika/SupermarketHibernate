package supermarkethibernate.dao;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public interface CrudDao<T, ID> extends SuperDao {
    boolean save(T t, Session session);

    boolean update(T t, Session session);

    boolean delete(ID id, Session session);

    T get(ID id, Session session);

    List<T> getAll(Session session);
}
