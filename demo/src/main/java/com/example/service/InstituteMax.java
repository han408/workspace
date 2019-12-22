package com.example.service;

import java.util.List;

import javax.transaction.Transactional;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.InstituteDao;


/**
 * @author jjhan
 */
@Service
public class InstituteMax {
    
    @Autowired
	private InstituteDao instituteDao;

    @SuppressWarnings("unchecked")
	@Transactional
    public JSONArray maxInstitutes() {
    	
    	List<Object[]> houfincsuplsums = instituteDao.yearSum();
    	JSONObject json = new JSONObject();
    	JSONArray jsonArry = new JSONArray();
		
    	for(Object[] houfincsuplsum  : houfincsuplsums) {
    		
    		List<Object[]> houfincsuplsumInstitutes = instituteDao.instituteYearSum((String)houfincsuplsum[0]);

    		long maxAmt = 0;
    		String maxInstitute="";
    		
    		for(Object[] houfincsuplsumInstitute  : houfincsuplsumInstitutes) {

    			if( maxAmt < (long)houfincsuplsumInstitute[1] ) {
    				maxInstitute = (String)houfincsuplsumInstitute[0];
    				maxAmt = (long)houfincsuplsumInstitute[1];
    			}

        	}
    		json = new JSONObject();
    		json.put("year", houfincsuplsum[0]);
    		json.put("bank", maxInstitute);
    		jsonArry.add(json);
    	}

    	return jsonArry;

    }
}
