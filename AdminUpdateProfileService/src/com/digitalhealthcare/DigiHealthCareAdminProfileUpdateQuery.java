package com.digitalhealthcare;


public class DigiHealthCareAdminProfileUpdateQuery {
	
	//public static String SQL_UPDATEPROFILE="UPDATE Profile_table  set App_id =?, MedicalId=?,Account_type =?,First_name =?,Last_name =?,Email_id =?,Gender =?,Photo =?,DOB =?,Date=? where User_id=?" ; 
	  public static String SQL_ADMINUPDATEPROFILE="UPDATE Profile_table  set App_id =?, Account_type =?,First_name =?,Last_name =?,Phone_no=?,Email_id =?,Gender =?,Photo =?,DOB =?,Date=?,Address=?,Landmark=?,City=?,State=?,County=?,Zipcode=?,Lattitude=?,Longitude=? where User_id=?" ;

	  public static String SQL_CHECKPHONE = " select Phone_no from Profile_table where Phone_no=? "; 

}

