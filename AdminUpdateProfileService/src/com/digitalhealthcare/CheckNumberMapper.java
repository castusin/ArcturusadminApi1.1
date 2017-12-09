package com.digitalhealthcare;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class CheckNumberMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigiHealthCareAdminProfileUpdate profileUpdate = new DigiHealthCareAdminProfileUpdate();
		profileUpdate.setPhoneNumber(rs.getString("Phone_no"));
		
		
		return profileUpdate;
	}

}
