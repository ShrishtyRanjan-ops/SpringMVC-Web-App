
package com.example.springmvc;

import com.example.hibernateapp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAO {

    public boolean addEmployee(Employee e) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(e);
            tx.commit();
            return true;

        } catch (Exception ex) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            ex.printStackTrace();
            return false;
        }
    }

    public Employee getEmployeeById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Employee> getAllEmployees() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Employee ORDER BY id", Employee.class
            ).list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return List.of();
        }
    }

    public boolean deleteEmployee(int id) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Employee employee = session.get(Employee.class, id);
            if (employee == null) {
                tx.rollback();
                return false;
            }

            session.remove(employee);
            tx.commit();
            return true;

        } catch (Exception ex) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            ex.printStackTrace();
            return false;
        }
    }

    public boolean updateEmployee(Employee e) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Employee existing = session.get(Employee.class, e.getId());
            if (existing == null) {
                tx.rollback();
                return false;
            }

            existing.setName(e.getName());
            existing.setGender(e.getGender());
            existing.setDesignation(e.getDesignation());
            existing.setSalary(e.getSalary());
            existing.setCity(e.getCity());
            existing.setEmail(e.getEmail());
            existing.setMobileNo(e.getMobileNo());

            tx.commit();
            return true;

        } catch (Exception ex) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            ex.printStackTrace();
            return false;
        }
    }
}
