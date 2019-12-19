package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Houfincinst;
import com.example.model.Houfincsupllist; 

@Repository
public interface HoufincinstRepository extends JpaRepository<Houfincinst, String> {

}
