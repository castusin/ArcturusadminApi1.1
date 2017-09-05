package com.digitalhealthcare;

public class DigihealthCareAdminCreateServiceQuery {
	
	public static String SQL_PATIENT_INFO="insert into Profile_table (App_id,User_id,Account_type,First_name,Last_name,Phone_no,Password,Email_id,Gender,Photo,DOB,Date,Address,Landmark,City,State,County,Zipcode,Lattitude,Longitude)"+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";     

	//public static String SQL_CARETAKERS_DETAILS="insert into Patient_phonenumber (Patient_id,Phone_number)"+"values(?,?)"; 	
	public static String SQL_FAMILYMAPPING="insert into Patient_fm (Patient_userid,Fm_id)"+"values(?,?)"; 	

}
