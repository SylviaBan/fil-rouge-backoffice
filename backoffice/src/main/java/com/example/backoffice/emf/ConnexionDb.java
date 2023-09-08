package com.example.backoffice.emf;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionDb {

    private static ConnexionDb instance;
    private final EntityManagerFactory emf;

    private ConnexionDb() {
        this.emf = Persistence.createEntityManagerFactory("db_config");
    }
    private EntityManagerFactory getEmf() {
        return this.emf;
    }

    public static EntityManagerFactory getInstanceEmf() {
        if (instance == null) {
            instance = new ConnexionDb();
        }
        return instance.getEmf();
    }
}