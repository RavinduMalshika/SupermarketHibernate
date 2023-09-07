package supermarkethibernate.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import supermarkethibernate.dao.custom.CustomerDao;
import supermarkethibernate.entity.CustomerEntity;

import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean save(CustomerEntity customerEntity, Session session) {
        String id = (String) session.save(customerEntity);
        if(id != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(CustomerEntity customerEntity, Session session) {
        session.update(customerEntity);
        return true;
    }

    @Override
    public boolean delete(String s, Session session) {
        //CustomerEntity customerEntity = get(s, session);
        session.delete(s, CustomerEntity.class);
        return true;
    }

    @Override
    public CustomerEntity get(String s, Session session) {
        CustomerEntity customerEntity = (CustomerEntity) session.get(CustomerEntity.class, s);
        return customerEntity;
    }

    @Override
    public List<CustomerEntity> getAll(Session session) {
        String hql = "FROM CustomerEntity";
        Query query = session.createQuery(hql);
        List<CustomerEntity> customerEntities = query.list();
        return customerEntities;
    }
}
