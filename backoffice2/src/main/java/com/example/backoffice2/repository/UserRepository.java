package com.example.backoffice2.repository;

import com.example.backoffice2.entity.User;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UserRepository extends EntityRepository<User, Long> {
    public UserRepository(EntityManagerFactory emf) {
        super(emf, User.class);
    }

    public User findUser(String username, String password) {
        EntityManager em = super.emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();// Début

        User u = null;
        try {
            TypedQuery<User> tq = em.createQuery(
                    "SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
            tq.setParameter("username", username);
            tq.setParameter("password", password);

            u = tq.getSingleResult();
        } catch (Exception e) {

        }

        tx.commit();// Fin
        em.close();

        return u;
    }

    public User findByUsername(String username) {
        EntityManager em = super.emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();// Début

        User u = null;
        try {
            TypedQuery<User> tq = em.createQuery(
                    "SELECT u FROM User u WHERE u.username = :username", User.class);
            tq.setParameter("username", username);

            u = tq.getSingleResult();
        } catch (Exception e) {

        }

        tx.commit();// Fin
        em.close();

        return u;
    }
}