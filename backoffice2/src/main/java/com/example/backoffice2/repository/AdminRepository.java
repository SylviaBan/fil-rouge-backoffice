package com.example.backoffice2.repository;

import com.example.backoffice2.entity.Admin;
import com.example.backoffice2.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class AdminRepository extends EntityRepository<Admin, Long>{
    public AdminRepository(EntityManagerFactory emf) {
        super(emf, Admin.class);
    }

    public Admin findAdmin(String login, String password) {
        EntityManager em = super.emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Admin a = null;
        try {
            TypedQuery<Admin> tq = em.createQuery(
                    "SELECT a FROM Admin a WHERE a.login = :login AND a.password = :password", Admin.class);
            tq.setParameter("login", login);
            tq.setParameter("password", password);

            a = tq.getSingleResult();
        } catch (Exception e) {

        }

        tx.commit();// Fin
        em.close();

        return a;
    }
}
