package supermarkethibernate;

import org.hibernate.Session;
import supermarkethibernate.util.SessionFactoryConfiguration;

public class Main {
    public static void main(String[] args) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
    }
}
