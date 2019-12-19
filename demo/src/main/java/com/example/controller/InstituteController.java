package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Houfincinst;
import com.example.model.Houfincsuplsum;
import com.example.service.InstituteList;
import com.example.service.InstituteRegist;
import com.example.service.InstituteSum;

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
	
	//기관등록
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
	
    //기관조회
    @RequestMapping(value = "/instituteList", method = RequestMethod.GET)
    public List<Houfincinst> instituteList() {

        List<Houfincinst> houfincinst = instituteList.findInstitutes();
        return houfincinst;
    }
    
    //합계조회
    @RequestMapping(value = "/instituteSumList", method = RequestMethod.GET)
    public List<Houfincsuplsum> instituteSum() {

        List<Houfincsuplsum> houfincsuplsum = instituteSum.sumInstitutes();
        return houfincsuplsum;
    }

}
