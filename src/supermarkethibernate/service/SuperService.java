package supermarkethibernate.service;

import org.hibernate.Session;
import supermarkethibernate.util.SessionFactoryConfiguration;

public interface SuperService {
    Session session = SessionFactoryConfiguration.getInstance().getSession();
}
