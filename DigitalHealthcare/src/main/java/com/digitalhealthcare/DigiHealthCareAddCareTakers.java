/**
 * 
 */
package com.digitalhealthcare;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;

/**
 * @author Darshan
 *
 */
@RestController
public class DigiHealthCareAddCareTakers {

	@RequestMapping(value="/addCareTakers",method=RequestMethod.GET,produces={"application/json"})

	 public String requestOTP(HttpServletRequest request,@RequestParam ("userId") String userId,@RequestParam ("phoneNumber") String phoneNumber){
	
		// Capture service Start time
		 TimeCheck time=new TimeCheck();
		 testServiceTime sessionTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		
		Logger logger = Logger.getLogger(DigiHealthCareAddCareTakers.class);
		CommonCISValidation CommonCISValidation=new CommonCISValidation();
		CISResults cisResult=CommonCISValidation.addCareTakers(request,userId,phoneNumber);
		if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		 {
			DigiHealthCareAdminAddCareTakerWebService adminCareTakerServiceWebservice = new DigiHealthCareAdminAddCareTakerWebService();
		    cisResult = adminCareTakerServiceWebservice.addPatients(userId,phoneNumber);
		 }
		
		// Capture Service End time
		String serviceEndTime=time.getTimeZone();
		long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		
		logger.info("Total service time for addcaretakers service in milli seconds:: " +result );
		return returnJsonData(cisResult);
		

	}
	
	private String returnJsonData(Object src){
		// TODO Auto-generated method stub
        Gson gson = new Gson();
		String feeds = gson.toJson(src);
		return feeds;
	}
}