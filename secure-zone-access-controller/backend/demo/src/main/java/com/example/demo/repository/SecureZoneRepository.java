package com.example.demo.repository;

import com.example.demo.model.SecureZone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecureZoneRepository extends JpaRepository<SecureZone, Long> {
    
}