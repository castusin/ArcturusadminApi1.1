package com.digitalhealthcare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
@SuppressWarnings("rawtypes")
public class DigihealthCareAdminCreateServiceMapper implements RowMapper{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigihealthCareAdminCreateService digiHealthpatinetExist = new DigihealthCareAdminCreateService();	
		digiHealthpatinetExist.setPhoneNumber(rs.getString("Phone_no"));
		return digiHealthpatinetExist;
	}

}
