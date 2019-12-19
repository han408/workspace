package com.example.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Houfincinst;
import com.example.model.Houfincsupllist;
import com.example.repository.HoufincinstRepository;
import com.example.repository.HoufincsupllistRepository;

/**
 * @author jjhan
 */
@Service
public class InstituteRegist {
	
    @Autowired
    private HoufincinstRepository houfincinstRepository;
    
    @Autowired
    private HoufincsupllistRepository houfincsupllistRepository;

	public void institute(String[] ar) {

		System.out.println("ar +"+ar.length);
		
		int code = 1;

		for(int i=2;i<ar.length;i++) {
			
			Houfincinst houfincinst = new Houfincinst();

			houfincinst.setInstituteCode("0"+Integer.toString(code));
			houfincinst.setInstituteName(ar[i]);
			
			// 등록
			houfincinstRepository.save(houfincinst);
			
			houfincinstRepository.flush();			
			
			code++;
		}

	}

	public void institute_amt(String[] ar) {
		
		int code = 1;
		
		for(int i=2;i<ar.length;i++) {

			Houfincsupllist houfincsupllist = new Houfincsupllist();
			
			houfincsupllist.setYear(ar[0]);
			houfincsupllist.setMonth(ar[1]);
			houfincsupllist.setInstituteCode("0"+Integer.toString(code));
			houfincsupllist.setInstituteAmt(Integer.parseInt(ar[i]));
			
			// 등록
			houfincsupllistRepository.save(houfincsupllist);
			
			houfincsupllistRepository.flush();
			
			code++;
		}

	}

	public void regist() {

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("sample.csv"),"UTF-8"));
			boolean flag = false;

			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				
				Pattern p = Pattern.compile("\"[0-9]+,[0-9]+\"");
				Matcher m = p.matcher(line);
				StringBuffer sb = new StringBuffer();
				while(m.find())
		        {
					String ch = m.group().replace(",", "");
					ch = ch.replace("\"", "");
					m.appendReplacement(sb, ch);
		        }				
				m.appendTail(sb);

				// 콤마로 분할
				String[] ar = sb.toString().split(",");
		
				// 제목 처리
				if (flag == false) {
					flag = true;
					institute(ar);
					continue;
				}
				
				institute_amt(ar);
			}

		} catch(Exception e) {
			System.out.printf("%s\n",e.getMessage());
			e.printStackTrace();
		}

	}
}
