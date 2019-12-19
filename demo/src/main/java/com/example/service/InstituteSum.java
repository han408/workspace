package com.example.service;

import java.util.List;

import org.hibernate.annotations.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Houfincsuplsum;
import com.example.repository.HoufincsuplsumRepository;


/**
 * @author jjhan
 */
@Service
public class InstituteSum {
	
    @Autowired
    private HoufincsuplsumRepository houfincsuplsumRepository;
	
    // 금융기관 목록 조회
    public List<Houfincsuplsum> sumInstitutes() {

		List<Houfincsuplsum> houfincsuplsums = houfincsuplsumRepository.findAll();
    	
    	for(Houfincsuplsum houfincsuplsum  : houfincsuplsums) {
    		System.out.println("testmemberList" + houfincsuplsum.toString());
    	}
    	
		return houfincsuplsums;
    }
}
