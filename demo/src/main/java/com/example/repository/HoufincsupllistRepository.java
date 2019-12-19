package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Houfincsupllist; 

@Repository
public interface HoufincsupllistRepository extends JpaRepository<Houfincsupllist, String> {

}

