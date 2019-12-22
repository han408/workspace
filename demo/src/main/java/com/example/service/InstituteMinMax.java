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
public class InstituteMinMax {
    
    @Autowired
	private InstituteDao instituteDao;

    @SuppressWarnings("unchecked")
	@Transactional
    public JSONObject minmaxInstitutes() {
    	
    	List<Object[]> houfincsuplsums = instituteDao.instituteAvgSum();
    	JSONObject json = new JSONObject();
    	JSONObject json2 = new JSONObject();
    	JSONArray jsonArry = new JSONArray();
    	
		int flag = 0;
		double minAmt = 0;
		double maxAmt = 0;
		String minyear = "";
		String maxyear = "";
		
    	for(Object[] houfincsuplsum  : houfincsuplsums) {

			if(flag == 0) {
				maxyear = (String)houfincsuplsum[0];
				maxAmt = (double)houfincsuplsum[1];
				minyear = (String)houfincsuplsum[0];
				minAmt = (double)houfincsuplsum[1];
			} else {
    			if( maxAmt < (double)houfincsuplsum[1] ) {
    				maxyear = (String)houfincsuplsum[0];
    				maxAmt = (double)houfincsuplsum[1];
    			}
    			
    			if( minAmt > (double)houfincsuplsum[1] ) {
    				minyear = (String)houfincsuplsum[0];
    				minAmt = (double)houfincsuplsum[1];
    			}
			}
			
			flag = 1;
    	}    	
    	
    	
		json.put("year", minyear);
		json.put("amount", minAmt);
		jsonArry.add(json);
		
		json = new JSONObject();
		json.put("year", maxyear);
		json.put("amount", maxAmt);
		jsonArry.add(json);
    	
    	json2.put("bank","외환은행");
    	json2.put("support_amount", jsonArry);

    	return json2;

    }
}
