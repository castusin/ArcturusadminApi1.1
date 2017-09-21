package com.digitalhealthcare;

import com.cis.CISResults;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


	public class DigihealthCareAdminCreateServiceDAO extends JdbcDaoSupport {

		
		public CISResults addPatients(String appId, String userId,
				String accountType, String firstName, String lastName,
				String phoneNumber,  String password,
				String emailId, String gender, String photo, String dob,
				String saveDate, String sessionId, String address,String landmark, String city, String state, String country, String zipcode, float lattitude, float longitude) {
			
			Logger logger = Logger.getLogger(DigihealthCareAdminCreateServiceDAO.class);
			CISResults cisResults=new CISResults();
			cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			try{
				// Capture service Start time
				 TimeCheck time=new TimeCheck();
				 testServiceTime sessionTimeCheck=new testServiceTime();
				 String serviceStartTime=time.getTimeZone();
				getJdbcTemplate().update(DigihealthCareAdminCreateServiceQuery.SQL_PATIENT_INFO,appId,userId,accountType,firstName,lastName,phoneNumber,password,emailId,gender,photo,dob,saveDate,address,landmark,city,state,country,zipcode,lattitude,longitude);
				 String serviceEndTime=time.getTimeZone();
				 sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
				 logger.info("patient info query time:: " +cisResults);
				 logger.info("Add patient info query time:: " +cisResults);
			} catch (DataAccessException e) {
				e.printStackTrace();
			
				cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
				cisResults.setErrorMessage("Failed At DataAccess");
			}

	   		return cisResults; 
			
		}

		public CISResults isAccountExists(String phoneNumber) {
			Logger logger = Logger.getLogger(DigihealthCareAdminCreateServiceDAO.class);
			DigitalHealthCareIsAccountExistModel verifyPhoneNumber;
			CISResults cisResults=new CISResults();
			cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			String accountType=CISConstants.AccountType;
			Object[] inputs = new Object[]{phoneNumber,accountType};
			try{
				// Capture service Start time
				 TimeCheck time=new TimeCheck();
				 testServiceTime sessionTimeCheck=new testServiceTime();
				 String serviceStartTime=time.getTimeZone();
				 verifyPhoneNumber=(DigitalHealthCareIsAccountExistModel)getJdbcTemplate().queryForObject(DigiHealthCareAdminAddCareTakerQuery.SQL_CHECK_CARETAKER,inputs,new DigitalHealthCareIsCareTakerExistMapper());
				 String serviceEndTime=time.getTimeZone();
				 sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
				 logger.info("check care taker query time:: " +cisResults);
				 
				 if(verifyPhoneNumber!=null){
					cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
					cisResults.setErrorMessage(CISConstants.ACCOUNT_STATUS5);
					//cisResults.setResultObject(verifyPhoneNumber);
				} 
			
				
				
			} catch (DataAccessException e) {
				e.printStackTrace();
				cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
				
			}
	   		return cisResults; 
		}

		public CISResults isPatinetExists(String phoneNumber) {
			// TODO Auto-generated method stub
			Logger logger = Logger.getLogger(DigihealthCareAdminCreateServiceDAO.class);
			DigihealthCareAdminCreateService verifyPhoneNumber;
			CISResults cisResults=new CISResults();
			cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			String accountType=CISConstants.AccountType;
			Object[] inputs = new Object[]{phoneNumber,accountType};
			try{
				// Capture service Start time
				 TimeCheck time=new TimeCheck();
				 testServiceTime sessionTimeCheck=new testServiceTime();
				 String serviceStartTime=time.getTimeZone();
				 verifyPhoneNumber=(DigihealthCareAdminCreateService)getJdbcTemplate().queryForObject(DigiHealthCareAdminAddCareTakerQuery.SQL_CHECK_PATIENT ,inputs,new DigihealthCareAdminCreateServiceMapper());
				 String serviceEndTime=time.getTimeZone();
				 sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
				 logger.info("check CheckPaitnet query time:: " +cisResults);
				 
				 if(verifyPhoneNumber!=null){
					cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
					cisResults.setErrorMessage(CISConstants.ACCOUNT_STATUS5);
					//cisResults.setResultObject(verifyPhoneNumber);
				} 
			
				
				
			} catch (DataAccessException e) {
				e.printStackTrace();
				cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
				
			}
	   		return cisResults; 
		}

	}
