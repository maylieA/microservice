package com.crea.backend.microservicespringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crea.backend.microservicespringboot.dao.ProductDao;
import com.crea.backend.microservicespringboot.model.Product;


@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    /* LIST */
    @GetMapping("/products")
    public List<Product> listProducts() {
        return productDao.findAll();
    }


    /* CREATE */
    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        productDao.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("votre produit à été ajouté avec succès");
    }

    /* DELETE */
    @DeleteMapping(value = "/deleteProduct/{id}")
    public ResponseEntity<String> deletePost(@PathVariable int id) {
       productDao.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("votre produit à été suprimer avec succès");
    }


    /* UPDATE */
    @PostMapping("/displayProduct/{id}")
    public ResponseEntity<String> displayProduct(@PathVariable int id) {
        productDao.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body("votre produit à été modifier avec succès");
    }


    /* SEARCH by name*/
    /*by name*/
    @GetMapping(value ="/searchProduct/{search}")
    public List<Product> searchProducts(@PathVariable String search){
        return productDao.findByNameLike("%"+ search +"%");
    }
    

    /* PRICE */
    /* high price */
    @GetMapping(value ="/product/highestPrice/{highPrice}")
    public List<Product> productHighPrice(@PathVariable int highPrice){
        return productDao.findByPriceGreaterThan(highPrice);
    }

    /* low price */
    @GetMapping(value = "/product/lowestPrice/{lowPrice}")
    public List<Product> productLowPrice(@PathVariable int lowPrice){
    return productDao.findByPriceLessThan(lowPrice);
    }
}
