package com.example.backoffice.repository;

import com.example.backoffice.entity.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

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
                    "SELECT u FROM User u WHERE u.username = :login OR u.password = :password", User.class);
            tq.setParameter("username", username);
            tq.setParameter("password", password);

            u = tq.getSingleResult();
        } catch (Exception e) {

        }

        tx.commit();// Fin
        em.close();

        return u;
    }
}