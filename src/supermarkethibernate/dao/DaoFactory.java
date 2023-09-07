package supermarkethibernate.dao;

import supermarkethibernate.dao.custom.impl.CustomerDaoImpl;
import supermarkethibernate.dao.custom.impl.ItemDaoImpl;
import supermarkethibernate.dao.custom.impl.OrderDaoImpl;
import supermarkethibernate.dao.custom.impl.OrderDetailDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {}

    public static DaoFactory getInstance() {
        return daoFactory == null ?
                daoFactory = new DaoFactory()
                : daoFactory;
    }

    public enum DaoTypes {
        CUSTOMER, ITEM, ORDER, ORDER_DETAIL
    }

    public SuperDao getDao(DaoTypes type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerDaoImpl();
            case ITEM:
                return new ItemDaoImpl();
            case ORDER:
                return new OrderDaoImpl();
            case ORDER_DETAIL:
                return new OrderDetailDaoImpl();
            default:
                return null;
        }
    }
}
