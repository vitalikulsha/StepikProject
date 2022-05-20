package service;

import entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DBService {
    private static final String SHOW_SQL = "true";
    private static final String HBM2DDL_AUTO = "create";

    private final SessionFactory factory;

    public DBService(){
        Configuration cnf = getH2Configuration();
        factory = createSessionFactory(cnf);
    }

    private Configuration getH2Configuration(){
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(User.class);

        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        cfg.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        cfg.setProperty("hibernate.connection.url", "jdbc:h2:./h2db");
        cfg.setProperty("hibernate.connection.username", "test");
        cfg.setProperty("hibernate.connection.password", "test");
        cfg.setProperty("hibernate.show_sql", SHOW_SQL);
        cfg.setProperty("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
        return cfg;
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public SessionFactory getFactory() {
        return factory;
    }
}
