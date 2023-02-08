package configuration;


import company.Company;
import company.Package;
import company.Vehicle;
import people.Client;
import people.Driver;
import people.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Employee.class);
            configuration.addAnnotatedClass(Vehicle.class);
            configuration.addAnnotatedClass(Company.class);
            configuration.addAnnotatedClass(Client.class);
            configuration.addAnnotatedClass(Package.class);
            configuration.addAnnotatedClass(Driver.class);
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }
}
