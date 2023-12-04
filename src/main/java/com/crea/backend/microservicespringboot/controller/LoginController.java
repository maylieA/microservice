package com.crea.backend.microservicespringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crea.backend.microservicespringboot.dao.UserLoginDao;
import com.crea.backend.microservicespringboot.model.UserLogin;

@RestController
public class LoginController {

    @Autowired
    private UserLoginDao userLoginDao;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLogin userLogin) {
        if (userLoginDao.isValidLogin(userLogin.getLogin(), userLogin.getPassword())) {
            return ResponseEntity.status(HttpStatus.OK).body("Connexion réussie.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Échec de connexion. Vérifiez vos informations de connexion.");
        }
    }
}
