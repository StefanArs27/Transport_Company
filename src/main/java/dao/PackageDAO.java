package dao;

import company.Package;
import configuration.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PackageDAO {
    //CRUD - Create
    public static void savePackage(Package pac) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(pac);
            transaction.commit();
        }
    }

    //CRUD - CreateMultipleRows
    public static void savePackages(List<Package> packages) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            packages.stream().forEach((pac) -> session.save(pac));
            transaction.commit();
        }
    }

    //CRUD - Update
    public static void saveOrUpdatePackage(Package pac) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(pac);
            transaction.commit();
        }
    }

    //CRUD - Update
    public static void saveOrUpdatePackages(List<Package> packages) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            //change use of lambda
            packages.stream().forEach(session::saveOrUpdate);
            transaction.commit();
        }
    }

    //CRUD - Read
    public static List<Package> readPackages(List<Package> packages) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT a FROM Package a", Package.class).getResultList();
        }
    }

    public static Package getAPackage (long id) {
        Package pac;

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            pac = session.get(Package.class, id);
            transaction.commit();
        }

        return pac;
    }

    //CRUD - Delete
    public static void deletePackage(Package pac) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(pac);
            transaction.commit();
        }
    }
}

//Sorting and Filter
