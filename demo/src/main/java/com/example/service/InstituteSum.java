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
public class InstituteSum {

    @Autowired
	private InstituteDao instituteDao;

    @SuppressWarnings("unchecked")
	@Transactional
    public JSONObject sumInstitutes() {
    	
    	List<Object[]> houfincsuplsums = instituteDao.yearSum();
    	JSONObject jsonResult = new JSONObject();
    	JSONArray jsonArryResult = new JSONArray();
		
    	for(Object[] houfincsuplsum  : houfincsuplsums) {
    		
    		JSONObject json = new JSONObject();
    		JSONArray jsonArry = new JSONArray();
    		
    		List<Object[]> houfincsuplsumInstitutes = instituteDao.instituteYearSum((String)houfincsuplsum[0]);

    		json.put("year", houfincsuplsum[0]);
    		json.put("total_amount", houfincsuplsum[1]);
    		
    		for(Object[] houfincsuplsumInstitute  : houfincsuplsumInstitutes) {
    			
    			JSONObject json_institute = new JSONObject();
        		json_institute.put(houfincsuplsumInstitute[0], houfincsuplsumInstitute[1]);
        		jsonArry.add(json_institute);

        	}
    		
    		json.put("detail_amount", jsonArry);
    		jsonArryResult.add(json);

    	}
    	
    	jsonResult.put("주택금융 공급현황",jsonArryResult);
    	
    	return jsonResult;

    }
}


