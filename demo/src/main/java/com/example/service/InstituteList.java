package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Houfincinst;
import com.example.repository.HoufincinstRepository;

/**
 * @author jjhan
 */
@Service
public class InstituteList {
	
    @Autowired
    private HoufincinstRepository houfincinstRepository;
	
    //기관조회
    public List<Houfincinst> findInstitutes() {
        return houfincinstRepository.findAll();
    }
}
