package supermarkethibernate.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import supermarkethibernate.dao.custom.OrderDetailDao;
import supermarkethibernate.entity.OrderDetailEntity;

import java.util.List;

public class OrderDetailDaoImpl implements OrderDetailDao {
    @Override
    public boolean save(OrderDetailEntity orderDetailEntity, Session session) {
        Object id = session.save(orderDetailEntity);
        if(id != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(OrderDetailEntity orderDetailEntity, Session session) {
        session.update(orderDetailEntity);
        return true;
    }

    @Override
    public boolean delete(String s, Session session) {
        session.delete(s, OrderDetailEntity.class);
        return true;
    }

    @Override
    public OrderDetailEntity get(String s, Session session) {
        OrderDetailEntity orderDetailEntity = (OrderDetailEntity) session.get(s, OrderDetailEntity.class);
        return orderDetailEntity;
    }

    @Override
    public List<OrderDetailEntity> getAll(Session session) {
        String hql = "FROM OrderDetailEntity";
        Query query = session.createQuery(hql);
        List<OrderDetailEntity> orderDetailEntities = query.list();
        return orderDetailEntities;
    }
}
