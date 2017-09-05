package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class DigihealthCareAdminCreateServiceBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml");
	DigihealthCareAdminCreateServiceDAO adminCreateServiceDAO=(DigihealthCareAdminCreateServiceDAO)ctx.getBean("savePatient");


	public CISResults addPatients(DigihealthCareProfileData savePatient) {
		
		Logger logger = Logger.getLogger(DigihealthCareAdminCreateServiceBL.class);
		
		// Capture service Start time
		  TimeCheck time=new TimeCheck();
	      String saveDate=time.getTimeZone();
	      String careTakerphone="";
	      String sessionId = UUID.randomUUID().toString();
	      String userId=DigestUtils.sha1Hex(sessionId);
	      String upToNCharacters = userId.substring(0, Math.min(userId.length(), 8));
	      userId=upToNCharacters;
	      String contact = savePatient.getPhoneNumber();
	      String phoneNumber=CISConstants.USA_COUNTRY_CODE+contact; 
		  //Need to change method name
	      CISResults cisResult = adminCreateServiceDAO.isPatinetExists(phoneNumber);
	      if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
	         cisResult = adminCreateServiceDAO.addPatients(savePatient.getAppId(),userId,savePatient.getAccountType(),savePatient.getFirstName(),savePatient.getLastName(),phoneNumber,savePatient.getPassword(),savePatient.getEmailId(),savePatient.getGender(),savePatient.getPhoto(),savePatient.getDob(),saveDate,sessionId,savePatient.getAddress(),savePatient.getLandmark(),savePatient.getCity(),savePatient.getState(),savePatient.getCounty(),savePatient.getZipcode(),savePatient.getLattitude(),savePatient.getLongitude());
		  }
		return cisResult;
		
	}

}
