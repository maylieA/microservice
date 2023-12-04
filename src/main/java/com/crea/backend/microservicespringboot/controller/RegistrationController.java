package com.crea.backend.microservicespringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crea.backend.microservicespringboot.dao.UserRegisterDao;
import com.crea.backend.microservicespringboot.model.UserRegister;

@RestController
public class RegistrationController {

    @Autowired
    private UserRegisterDao userRegisterDao;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegister userRegistration) {
        if (userRegisterDao.isUsernameTaken(userRegistration.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le nom d'utilisateur est déjà pris.");
        }

        if (userRegisterDao.isLoginTaken(userRegistration.getLogin())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le login est déjà pris.");
        }

        if (userRegisterDao.isEmailTaken(userRegistration.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("L'adresse e-mail est déjà enregistrée.");
        }

        userRegisterDao.registerUser(userRegistration);
        return ResponseEntity.status(HttpStatus.CREATED).body("Inscription réussie.");
    }
}
