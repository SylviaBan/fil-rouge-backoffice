package com.example.backoffice2;

import com.example.backoffice2.emf.ConnexionDb;
import com.example.backoffice2.entity.Admin;
import com.example.backoffice2.entity.User;
import com.example.backoffice2.repository.AdminRepository;
import com.example.backoffice2.repository.UserRepository;

public class Main {
    public static void main(String[] args) {

        /* Connexion en bdd grâce au singleton puis crétaion d'un objet userRepo */
        UserRepository userRepo = new UserRepository(ConnexionDb.getInstanceEmf());
        AdminRepository adminRepo = new AdminRepository(ConnexionDb.getInstanceEmf());

        // Création de nouveaux éléments en bdd
        User user1 = new User("JeanDupont","1234", 0606060601L, "https://url1","jean@dupont.com");
        User user2 = new User("MarieDumont","0000",0606060602L, "https://url2","marie@dumont.com");
        User user3 = new User("PierreMartin","8888",0606060603L, "https://url3","pierre@martin.com");
        User user4 = new User("celestine69","1111",0606060604L, "https://url4","celestine@viard.com");
        User user5 = new User("AnneAnne","4321",0606060605L, "https://url5","anne@duris.com");

        userRepo.create(user1);
        userRepo.create(user2);
        userRepo.create(user3);
        userRepo.create(user4);
        userRepo.create(user5);

        Admin admin1 = new Admin("admin1","root");
        Admin admin2 = new Admin("admin2","rootroot");

        adminRepo.create(admin1);
        adminRepo.create(admin2);
    }
}
