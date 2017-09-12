package org.mycompany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mycompany.model.Event;
import org.mycompany.model.Message;
import org.mycompany.model.Person;
import org.mycompany.model.Phone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgresql");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Message message = new Message();
        message.setText("My first message");
        entityManager.persist(message);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}

