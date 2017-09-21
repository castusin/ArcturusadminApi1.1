
package com.digitalhealthcare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class DigihealthCareProfileDataMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigihealthCareProfileData homeCareRegistration = new DigihealthCareProfileData();
		homeCareRegistration.setAppId(rs.getString("App_id"));
		homeCareRegistration.setUserId(rs.getString("User_id"));
		
		homeCareRegistration.setAccountType(rs.getString("Account_type"));
		homeCareRegistration.setFirstName(rs.getString("First_name"));
	    homeCareRegistration.setLastName(rs.getString("Last_name"));
		homeCareRegistration.setPhoneNumber(rs.getString("Phone_no"));
		
		homeCareRegistration.setEmailId(rs.getString("Email_id"));
		homeCareRegistration.setGender(rs.getString("Gender"));
		homeCareRegistration.setPhoto(rs.getString("Photo"));
		homeCareRegistration.setDob(rs.getString("DOB"));
		homeCareRegistration.setDate(rs.getDate("Date"));
		
		homeCareRegistration.setAddress(rs.getString("Address"));
		homeCareRegistration.setLandmark(rs.getString("Landmark"));
		homeCareRegistration.setCity(rs.getString("City"));
		homeCareRegistration.setState(rs.getString("State"));
		homeCareRegistration.setCounty(rs.getString("County"));
		homeCareRegistration.setZipcode(rs.getString("Zipcode"));
		homeCareRegistration.setLattitude(rs.getFloat("Lattitude"));
		homeCareRegistration.setLongitude(rs.getFloat("Longitude"));
		
		return homeCareRegistration;
	}

}
