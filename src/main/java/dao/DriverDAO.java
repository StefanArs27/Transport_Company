package dao;

import company.Company;
import configuration.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import people.Driver;
import people.Employee;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DriverDAO {
    public static void saveDriver(Driver driver) {
    try (Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(driver);
            transaction.commit();
        }
    }

    public static void saveDrivers(List<Driver> drivers) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            drivers.forEach(session::save);
            transaction.commit();
        }
    }

    public static void saveOrUpdateDriver(Driver driver) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(driver);
            transaction.commit();
        }
    }

    public static void saveOrUpdateDrivers(List<Driver> drivers) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            drivers.forEach(session::saveOrUpdate);
            transaction.commit();
        }
    }

    public static List<Driver> readDrivers() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            return session.createQuery("select a from driver a", Driver.class).getResultList();
        }
    }

    public static Driver getDriver(long id) {
        Driver driver;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            driver = session.get(Driver.class, id);
            transaction.commit();
        }
        return driver;
    }

    public static List<Driver> driversByQualificationAsc() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Driver> cr = cb.createQuery(Driver.class);
            Root<Driver> root = cr.from(Driver.class);
            cr.orderBy(cb.asc(root.get("driverQualification")));

            Query<Driver> query = session.createQuery(cr);
            List<Driver> drivers = query.getResultList();
            return drivers;
        }
    }

    public static List<Driver> driversByQualificationDesc() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Driver> cr = cb.createQuery(Driver.class);
            Root<Driver> root = cr.from(Driver.class);
            cr.orderBy(cb.desc(root.get("driverQualification")));

            Query<Driver> query = session.createQuery(cr);
            List<Driver> drivers = query.getResultList();
            return drivers;
        }
    }

    public static List<Driver> driversBySalaryAsc() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Driver> cr = cb.createQuery(Driver.class);
            Root<Driver> root = cr.from(Driver.class);
            cr.orderBy(cb.asc(root.get("salary")));

            Query<Driver> query = session.createQuery(cr);
            List<Driver> drivers = query.getResultList();
            return drivers;
        }
    }

    public static List<Driver> driversBySalaryDesc() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Driver> cr = cb.createQuery(Driver.class);
            Root<Driver> root = cr.from(Driver.class);
            cr.orderBy(cb.desc(root.get("salary")));

            Query<Driver> query = session.createQuery(cr);
            List<Driver> drivers = query.getResultList();
            return drivers;
        }
    }

    public static void deleteDriver(Driver driver) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(driver);
            transaction.commit();
        }
    }
}
