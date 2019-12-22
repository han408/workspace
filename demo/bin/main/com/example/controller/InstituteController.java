package com.example.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Houfincinst;
import com.example.service.InstituteList;
import com.example.service.InstituteRegist;
import com.example.service.InstituteSum;
import com.example.service.InstituteMax;
import com.example.service.InstituteMinMax;

import java.util.List;

/**
 * User: jjhan
 */
@RestController
public class InstituteController {

	@Autowired
    private InstituteList instituteList;

	@Autowired
    private InstituteRegist instituteRegist;
	
	@Autowired
    private InstituteSum instituteSum;
	
	@Autowired
    private InstituteMax instituteMax;
	
	@Autowired
    private InstituteMinMax instituteMinMax;
	
	//등록
    @RequestMapping(value = "/instituteRegist", method = RequestMethod.GET)
    public String instituteRegist() {

    	try {
    		instituteRegist.regist();
    		return "Success";
    	} catch(Exception e) {
			System.out.printf("%s\n",e.getMessage());
			return "Fail";
		}
    }
	
    //목록조회
    @RequestMapping(value = "/instituteList", method = RequestMethod.GET)
    public List<Houfincinst> instituteList() {

        List<Houfincinst> houfincinst = instituteList.findInstitutes();
        return houfincinst;
    }
    
    //합계조회
    @RequestMapping(value = "/instituteSumList", method = RequestMethod.GET)
    public JSONObject instituteSum() {

    	JSONObject houfincsuplsum = instituteSum.sumInstitutes();
        return houfincsuplsum;
    }
    
    //max조회
    @RequestMapping(value = "/instituteMaxList", method = RequestMethod.GET)
    public JSONArray InstituteMax() {

    	JSONArray houfincsuplmax = instituteMax.maxInstitutes();
        return houfincsuplmax;
    }
    
    //minmax조회
    @RequestMapping(value = "/instituteMinMaxList", method = RequestMethod.GET)
    public JSONObject instituteMinMax() {

    	JSONObject houfincsuplMinMax = instituteMinMax.minmaxInstitutes();
        return houfincsuplMinMax;
    }

}
