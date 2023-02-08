package dao;

import configuration.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import people.Client;

import java.util.List;

public class ClientDAO {

    public static void saveClient(Client client) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }
    }

    public static void saveClients(List<Client> clients) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            clients.stream().forEach((com) -> session.save(com));
            transaction.commit();
        }
    }

    public static void saveOrUpdateClient(Client client) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(client);
            transaction.commit();
        }
    }

    public static void saveOrUpdateClients(List<Client> clients) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            clients.stream().forEach((com) -> session.saveOrUpdate(com));
            transaction.commit();
        }
    }

    public static Client getClient(long id) {
        Client client;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            client = session.get(Client.class, id);
            transaction.commit();
        }
        return client;
    }

    public static List<Client> readClients() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT a FROM Client a", Client.class).getResultList();
        }
    }

    public static void deleteClient(Client client) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
        }
    }
}

//Sorting and Filter