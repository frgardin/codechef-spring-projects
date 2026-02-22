package com.gardin.felipe.wallet.digital.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gardin.felipe.wallet.digital.entity.AppUser;
import com.gardin.felipe.wallet.digital.service.WalletService;

@RestController
@RequestMapping("/api")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }
   
    // 1. POST: Register User
    // TODO: Map this method to the URL "/register"
    // Challenge: Use @RequestBody to map the JSON input to the AppUser object
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AppUser user) {
        try {
            // TODO: Call the service to register the user
            // Wrap the result in ResponseEntity and return it
            return ResponseEntity.ok(walletService.registerUser(user));
        } catch (Exception e) {
            // TODO: In case of error, return a bad request with the error message using e.getMessage()
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // 2. PUT: Add Money
    // TODO: Map this method to the URL "/add-money/{userId}"
    // Challenge 1: Use @PathVariable to extract "userId" from the URL
    // Challenge 2: Use @RequestParam to extract "amount" from the query string (e.g., ?amount=50)
    @PutMapping("/add-money/{userId}")
    public ResponseEntity<String> addMoney(@PathVariable Long userId, @RequestParam BigDecimal amount) {
        try {
            // TODO: Call the service to add funds
            return ResponseEntity.ok(walletService.addFunds(userId, amount));
        } catch (Exception e) {
            // TODO: In case of error, return a bad request with the error message using e.getMessage()
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // 3. DELETE: Delete Account
    // TODO: Map this to "/delete/{id}"
    // Challenge: Extract the "id" from the URL using @PathVariable
    @DeleteMapping("/delete/{id}")
    public String deleteAccount(@PathVariable Long id) {
        // TODO: Call the service to delete the user
        return walletService.deleteUser(id);
    }

    // 4. GET: View All Users
    // TODO: Map this method to the URL "/users"
    @GetMapping("/users")
    public List<AppUser> getAll() {
        // TODO: Return all users
        return walletService.getAllUsers();
    }
}
