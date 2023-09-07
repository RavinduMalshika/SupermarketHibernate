package supermarkethibernate.dao.custom.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import supermarkethibernate.dao.custom.ItemDao;
import supermarkethibernate.entity.ItemEntity;

import java.util.List;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(ItemEntity itemEntity, Session session) {
        String id = (String) session.save(itemEntity);
        if(id != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(ItemEntity itemEntity, Session session) {
        session.update(itemEntity);
        return true;
    }

    @Override
    public boolean delete(String s, Session session) {
        session.delete(s, ItemEntity.class);
        return true;
    }

    @Override
    public ItemEntity get(String s, Session session) {
        ItemEntity itemEntity = (ItemEntity) session.get(ItemEntity.class, s);
        return itemEntity;
    }

    @Override
    public List<ItemEntity> getAll(Session session) {
        String hql = "FROM ItemEntity";
        Query query = session.createQuery(hql);
        List<ItemEntity> itemEntities = query.list();
        return itemEntities;
    }
}
