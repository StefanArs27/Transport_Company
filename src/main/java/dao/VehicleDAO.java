package dao;

import company.Vehicle;
import configuration.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class VehicleDAO {
    public static void saveVehicle(Vehicle vehicle) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(vehicle);
            transaction.commit();
        }
    }

    public static void saveVehicles(List<Vehicle> vehicleList) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            vehicleList.stream().forEach((com) -> session.save(com));
            transaction.commit();
        }
    }

    public static void saveOrUpdateVehicle(Vehicle vehicle) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(vehicle);
            transaction.commit();
        }
    }

    public static void saveOrUpdateVehicles(List<Vehicle> vehicles) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            //change use of lambda
            vehicles.stream().forEach(session::saveOrUpdate);
            transaction.commit();
        }
    }

    public static List<Vehicle> readVehicles() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT a FROM Vehicle a", Vehicle.class).getResultList();
        }
    }

    public static Vehicle getVehicle(long id) {
        Vehicle vehicle;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            vehicle = session.get(Vehicle.class, id);
            transaction.commit();
        }
        return vehicle;
    }

    //what is act being pushed - whole class or just distance
    public static List<Vehicle> VehicleDestinationAscending() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Vehicle> cr = cb.createQuery(Vehicle.class);
            Root<Vehicle> root = cr.from(Vehicle.class);
            cr.orderBy(cb.asc(root.get("distance")));

            Query<Vehicle> query = session.createQuery(cr);
            List<Vehicle> vehicles = query.getResultList();
            return vehicles;
        }
    }

    public static List<Vehicle> VehicleDestinationDescending() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Vehicle> cr = cb.createQuery(Vehicle.class);
            Root<Vehicle> root = cr.from(Vehicle.class);
            cr.orderBy(cb.desc(root.get("distance")));

            Query<Vehicle> query = session.createQuery(cr);
            List<Vehicle> vehicles = query.getResultList();
            return vehicles;
        }
    }

    public static void deleteVehicle(Vehicle vehicle) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(vehicle);
            transaction.commit();
        }
    }
}

//Sorting and Filter
