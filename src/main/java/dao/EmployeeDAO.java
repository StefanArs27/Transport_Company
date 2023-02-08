package dao;

import org.hibernate.query.Query;
import people.Employee;
import configuration.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeDAO {
    public static void saveEmployee(Employee employee) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    public static void saveEmployees(List<Employee> employeeList) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employeeList.stream().forEach((com) -> session.save(com));
            transaction.commit();
        }
    }

    public static void saveOrUpdateEmployee(Employee employee) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        }
    }

    public static void saveOrUpdateEmployees(List<Employee> employees) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            //change use of lambda
            employees.stream().forEach(session::saveOrUpdate);
            transaction.commit();
        }
    }

    public static List<Employee> readEmployees() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT a FROM Employee a", Employee.class).getResultList();
        }
    }

    public static Employee getEmployee(long id) {
        Employee employee;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);
            transaction.commit();
        }
        return employee;
    }

    public static List<Employee> EmployeesBySalaryAsc() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
            Root<Employee> root = cr.from(Employee.class);
            cr.orderBy(cb.asc(root.get("salary")));

            Query<Employee> query = session.createQuery(cr);
            return query.getResultList();
        }
    }

    public static List<Employee> EmployeesBySalaryDesc() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
            Root<Employee> root = cr.from(Employee.class);
            cr.orderBy(cb.desc(root.get("salary")));

            Query<Employee> query = session.createQuery(cr);
            return query.getResultList();
        }
    }

    public static void deleteEmployee(Employee employee) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}