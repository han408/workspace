package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Houfincsuplsum;

@Repository
public interface HoufincsuplsumRepository extends JpaRepository<Houfincsuplsum, String> {

}

