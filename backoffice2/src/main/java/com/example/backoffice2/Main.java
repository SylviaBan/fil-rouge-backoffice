package com.example.backoffice2;

import com.example.backoffice2.emf.ConnexionDb;
import com.example.backoffice2.entity.Admin;
import com.example.backoffice2.entity.User;
import com.example.backoffice2.repository.AdminRepository;
import com.example.backoffice2.repository.UserRepository;


public class Main {
    public static void main(String[] args) {

        /* Connexion en bdd grâce au singleton puis création d'un objet userRepo */
        UserRepository userRepo = new UserRepository(ConnexionDb.getInstanceEmf());
        AdminRepository adminRepo = new AdminRepository(ConnexionDb.getInstanceEmf());

        // Création de nouveaux éléments en bdd
        User user1 = new User("JeanDupont","1234", "0606060601", "https://url1","jean@dupont.com");
        User user2 = new User("MarieDumont","0000","0606060602", "https://url2","marie@dumont.com");
        User user3 = new User("PierreMartin","8888","0606060603", "https://url3","pierre@martin.com");
        User user4 = new User("celestine69","1111","0606060604", "https://url4","celestine@viard.com");
        User user5 = new User("AnneAnne","4321","0606060605", "https://url5","anne@duris.com");
        User user6 = new User("user2024","2024","0606060606", "https://url6","user2024@gmail.com");


        userRepo.create(user1);
        userRepo.create(user2);
        userRepo.create(user3);
        userRepo.create(user4);
        userRepo.create(user5);
        userRepo.create(user6);

        Admin admin1 = new Admin("admin1","root1");
        Admin admin2 = new Admin("admin2","root2");
        Admin admin3 = new Admin("admin3","root3");

        adminRepo.create(admin1);
        adminRepo.create(admin2);
    }
}
