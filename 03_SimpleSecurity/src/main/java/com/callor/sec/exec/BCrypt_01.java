package com.callor.sec.exec;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCrypt_01 {

    public static void main(String[] args) {

        PasswordEncoder pass = new BCryptPasswordEncoder(4);

        String password = "1234";
        String encPassword = "$2a$04$IGYpdkDQg407AwjASjHs5ea8cmsoaMM3oxSezDPQI3dBdfmwZ1hsu";

        String bcPassword = pass.encode(password);
        System.out.println(bcPassword);

        boolean loginOK = pass.matches(password,encPassword);

        if(loginOK) {
            System.out.println("LOGIN OK");
        } else {
            System.out.println("LOGIN FAIL");
        }

    }

}
