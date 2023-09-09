package com.example.backoffice;

import com.example.backoffice.emf.ConnexionDb;
import com.example.backoffice.entity.User;
import com.example.backoffice.repository.UserRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        /* Connexion en bdd grâce au singleton puis crétaion d'un objet userRepo */
        UserRepository userRepo = new UserRepository(ConnexionDb.getInstanceEmf());

        // Création de nouveaux éléments en bdd
        User user1 = new User("JeanDupont","1234","jean@dupont.com");
        User user2 = new User("MarieDumont","0000","marie@dumont.com");
        User user3 = new User("PierreMartin","8888","pierre@martin.com");
        User user4 = new User("celestine69","1111","celestine@viard.com");
        User user5 = new User("AnneAnne","4321","anne@duris.com");

        userRepo.create(user1);
        userRepo.create(user2);
        userRepo.create(user3);
        userRepo.create(user4);
        userRepo.create(user5);

    }
}
