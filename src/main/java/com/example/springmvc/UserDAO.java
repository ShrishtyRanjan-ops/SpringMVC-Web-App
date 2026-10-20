
package com.example.springmvc;

import com.example.hibernateapp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDAO {

    private final BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();

    public boolean registerUser(User user) {
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();

            try {
                user.setPassword(
                        passwordEncoder.encode(user.getPassword()));

                session.persist(user);
                tx.commit();

                return true;

            } catch (Exception ex) {
                // Roll back before the session closes
                try {
                    if (tx.isActive()) {
                        tx.rollback();
                    }
                } catch (Exception rollbackEx) {
                    System.err.println(
                            "Rollback failed: " + rollbackEx.getMessage());
                }

                System.err.println(
                        "Registration failed: " + ex.getMessage());
                return false;
            }

        } catch (Exception ex) {
            System.err.println(
                    "Unable to open Hibernate session: "
                            + ex.getMessage());
            return false;
        }
    }

    public User findUser(String username) {
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                            "FROM User WHERE username = :username",
                            User.class)
                    .setParameter("username", username)
                    .uniqueResult();

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean updateProfile(String username, User user) {
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();

            try {
                User existing = session.createQuery(
                                "FROM User WHERE username = :username",
                                User.class)
                        .setParameter("username", username)
                        .uniqueResult();

                if (existing == null) {
                    tx.rollback();
                    return false;
                }

                existing.setName(user.getName());
                existing.setCity(user.getCity());
                existing.setEmail(user.getEmail());
                existing.setMobileNo(user.getMobileNo());

                tx.commit();
                return true;

            } catch (Exception ex) {
                try {
                    if (tx.isActive()) {
                        tx.rollback();
                    }
                } catch (Exception rollbackEx) {
                    System.err.println(
                            "Rollback failed: "
                                    + rollbackEx.getMessage());
                }

                ex.printStackTrace();
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean checkPassword(
            String enteredPassword, String storedHash) {

        return passwordEncoder.matches(
                enteredPassword, storedHash);
    }
}
