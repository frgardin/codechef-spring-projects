package com.example.demo.repository;

import com.example.demo.model.RfidCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RfidCardRepository extends JpaRepository<RfidCard, Long> {

}