package com.gardin.felipe.wallet.digital.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gardin.felipe.wallet.digital.entity.AppUser;
import com.gardin.felipe.wallet.digital.entity.Wallet;
import com.gardin.felipe.wallet.digital.repository.UserRepository;

@Service
public class WalletService {

    private final UserRepository userRepository;

    public WalletService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AppUser registerUser(AppUser user) {

        // Challenge 1: Generate a random Wallet Address
        // Hint: Use UUID.randomUUID().toString() to get a random string.
        // Take first 8 characters and convert to uppercase for better readability.
        // Prefix it with "0x" to look like a crypto address.
        String generatedAddress = "0x" + UUID.randomUUID()
                .toString().substring(0, 8).toUpperCase();

        // Challenge 2: Create the Wallet Object
        Wallet newWallet = new Wallet();

        // TODO: Set the generated address
        newWallet.setWalletAddress(generatedAddress);

        // TODO: Initialize balance to ZERO (Use BigDecimal.ZERO)
        newWallet.setBalance(BigDecimal.ZERO);

        // Challenge 3: Link the Wallet to the User (One-to-One)
        user.setWallet(newWallet);

        // TODO: Save and return the User (This will also save the Wallet because of
        // Cascading)
        return userRepository.save(user);
    }

    // 2. ADD FUNDS
    // TODO: Add the annotation to ensure data integrity during updates (Dirty
    // Checking)
    @Transactional
    public String addFunds(Long userId, BigDecimal amount) {

        // Step 1: Try to find the user (Returns an Optional box)
        Optional<AppUser> userBox = userRepository.findById(userId);

        AppUser user = null;

        // Step 2: Check if user exists
        if (userBox.isPresent()) {
            // TODO: Open the box and get the user
            user = userBox.get();
        } else {
            // TODO: Throw an error if not found
            throw new RuntimeException("User not found!");
        }

        // Step 3: Get the user's wallet
        Wallet wallet = user.getWallet();

        // Step 4: Calculate new balance (Current Balance + Amount)
        BigDecimal newBalance = wallet.getBalance().add(amount);

        // Step 5: Update the wallet
        wallet.setBalance(newBalance);

        return "Success! Added $" + amount + ". New Balance: $" + newBalance;
    }

    // 3. DELETE USER
    public String deleteUser(Long id) {
        // TODO: Check if the user exists
        if (userRepository.existsById(id)) {
            // TODO: Delete the user
            userRepository.deleteById(id);
            return "User and Wallet deleted successfully.";
        }
        return "User not found.";
    }

    // 4. GET ALL USERS
    public List<AppUser> getAllUsers() {
        // TODO: Return all users from the database
        return userRepository.findAll();
    }

}
