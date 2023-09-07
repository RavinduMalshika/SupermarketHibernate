package supermarkethibernate.service;

import supermarkethibernate.service.custom.impl.CustomerServiceImpl;
import supermarkethibernate.service.custom.impl.ItemServiceImpl;
import supermarkethibernate.service.custom.impl.OrderServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return serviceFactory == null ?
                serviceFactory = new ServiceFactory()
                : serviceFactory;
    }

    public enum ServiceTypes {
        CUSTOMER, ITEM, ORDER
    }
    public SuperService getService(ServiceTypes type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerServiceImpl();
            case ORDER:
                return new OrderServiceImpl();
            case ITEM:
                return new ItemServiceImpl();
            default:
                return null;
        }
    }
}
