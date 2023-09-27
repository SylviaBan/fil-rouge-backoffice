package com.example.backoffice2.servlet;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedPassword = md.digest(password.getBytes());
        // Convert the byte array to a hexadecimal string
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedPassword) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static String maskPassword(String password) {
        // Masquer le mot de passe comme vous le souhaitez, par exemple : "********"
        return "********";
    }

    // Bcrypt 
}
