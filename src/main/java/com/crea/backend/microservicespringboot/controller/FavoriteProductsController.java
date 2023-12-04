package com.crea.backend.microservicespringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crea.backend.microservicespringboot.dao.ProductDao;
import com.crea.backend.microservicespringboot.dao.UserDao;
import com.crea.backend.microservicespringboot.model.Product;
import com.crea.backend.microservicespringboot.model.User;

@RestController
public class FavoriteProductsController {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private ProductDao productDao;

    @PostMapping("/addFavoriteProduct/{userId}/{productId}")
    public ResponseEntity<String> addFavoriteProduct(@PathVariable int userId, @PathVariable int productId) {
        User user = userDao.getUserById(userId);
        Product product = productDao.findById(productId);

        if (user != null && product != null) {
            user.addFavoriteProduct(product);
            userDao.updateUser(user);
            return ResponseEntity.status(HttpStatus.OK).body("Produit ajouté aux favoris.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utilisateur ou produit non trouvé.");
        }
    }
}
