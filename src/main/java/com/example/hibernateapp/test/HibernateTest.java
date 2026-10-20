
package com.example.hibernateapp.test;

import com.example.hibernateapp.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class HibernateTest {

    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory =
                    HibernateUtil.getSessionFactory();

            System.out.println(
                    "Hibernate connected successfully!"
            );

            sessionFactory.close();

        } catch (Exception e) {
            System.err.println(
                    "Hibernate connection failed!"
            );
            e.printStackTrace();
        }
    }
}
