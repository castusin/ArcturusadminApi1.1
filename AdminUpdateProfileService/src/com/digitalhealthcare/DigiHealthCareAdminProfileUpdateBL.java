package com.digitalhealthcare;



import java.sql.Date;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;

public class DigiHealthCareAdminProfileUpdateBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareAdminProfileUpdateDAO profileUpdateDAO=(DigiHealthCareAdminProfileUpdateDAO)ctx.getBean("AdminProfileUpdateDAO");

	/**
	 * @param updateProfile
	 * @return
	 */
	public CISResults updateProfile(DigiHealthCareAdminProfileUpdate adminUpdateProfile) {
		final Logger logger = Logger.getLogger(DigiHealthCareAdminProfileUpdateBL.class);
		String phoneNumber=CISConstants.USA_COUNTRY_CODE+adminUpdateProfile.getPhoneNumber(); 
		CISResults cisResult = profileUpdateDAO.updateProfile(adminUpdateProfile.getAppId(),adminUpdateProfile.getUserId(),adminUpdateProfile.getAccountType(),adminUpdateProfile.getFirstName(),adminUpdateProfile.getLastName(),phoneNumber,adminUpdateProfile.getEmailId(),adminUpdateProfile.getGender(),adminUpdateProfile.getPhoto(),adminUpdateProfile.getDob(),adminUpdateProfile.getAddress(),adminUpdateProfile.getLandmark(),adminUpdateProfile.getCity(),adminUpdateProfile.getState(),adminUpdateProfile.getCounty(),adminUpdateProfile.getZipcode(),adminUpdateProfile.getLattitude(),adminUpdateProfile.getLongitude());
		logger.debug("DigitalHealthCare:saveFeedback dao service" +cisResult );
		return cisResult;
	}

}