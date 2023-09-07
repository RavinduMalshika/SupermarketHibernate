package supermarkethibernate.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import supermarkethibernate.dao.custom.OrderDao;
import supermarkethibernate.entity.OrderEntity;

import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public boolean save(OrderEntity orderEntity, Session session) {
        String id = (String) session.save(orderEntity);
        if(id != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(OrderEntity orderEntity, Session session) {
        session.update(orderEntity);
        return true;
    }

    @Override
    public boolean delete(String s, Session session) {
        session.delete(s, OrderEntity.class);
        return true;
    }

    @Override
    public OrderEntity get(String s, Session session) {
        OrderEntity orderEntity = (OrderEntity) session.get(OrderEntity.class, s);
        return orderEntity;
    }

    @Override
    public List<OrderEntity> getAll(Session session) {
        String hql = "FROM OrderEntity";
        Query query = session.createQuery(hql);
        List<OrderEntity> orderEntities = query.list();
        return orderEntities;
    }
}
