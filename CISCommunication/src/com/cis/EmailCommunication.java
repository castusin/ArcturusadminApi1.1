package com.cis;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailCommunication {
	
	public String sendMailWithAuth(String host, String user, String password,
	        String port, String to, String body, String subject, String cc, String bcc,String director) throws Exception{
	   
	    
	    Properties props = System.getProperties();

	      props.put("mail.smtp.user", user);
	      props.put("mail.smtp.password", password);
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", port);
	      props.put("mail.debug", "true");
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "false");
	      props.put("mail.smtp.EnableSSL.enable", "false");

	      Session session = Session.getInstance(props, null);
	      session.setDebug(true);

	      MimeMessage message = new MimeMessage(session);
	      message.setFrom(new InternetAddress(user));

	      // To get the array of addresses    
	     message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	     message.addRecipient(RecipientType.CC, new InternetAddress(cc));
	     message.addRecipient(RecipientType.BCC, new InternetAddress(bcc));
	     message.addRecipient(RecipientType.BCC, new InternetAddress(director));
	    

	      message.setSubject(subject);
	    
	      message.setContent(body, "text/html");
	     
	  
	      Transport transport = session.getTransport("smtp");
	      try {
	          transport.connect(host, user, password);
	          transport.sendMessage(message, message.getAllRecipients());
	          Transport.send(message);
	          transport.close();
	         
	        
	      } finally {
	         
	      }
	      return "0";
	    
	    
	}
	
	/*public CISResults sendStaffMail(String staffEmail, String startTime, String endTime, int recurrenceTime, String cc, String bcc) {
		// TODO Auto-generated method stub
		CISResults cisResult = new CISResults();
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<p>Hi, </b><br />"+
                
  				
				"<p>Hi " + name +" " + lastName +" , <br />"+
				 "<p>Please find your appointment details.</b><br />"+
                "<br />\n"+
                "<p>"+type+"</b><br />"+
                "<p>"+startTime+"</b><br />"+
				"<p><b>StaffName</b> : "+ fname +" "+ name +"</b><br /><br />"+
				
				
				"<p><b>EndDateTime</b> :"+endTime+"</b><br />"+
				"<p><b>Recurrence</b> :"+recurrenceTime+"</b><br />"+
				 "<p>Please call our office if you have any questions. </b><br />"+
                
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Care Admin<br />\n" +
                "  <br />\n" +
                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.EMAILHOST,CISConstants.EMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,staffEmail, msg, subject, cc, bcc);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}*/
	
	
	public CISResults sendPatientMail(String patientEmail, String appwith, String startTime, String endTime, String type, String name, String fname, int recurrenceTime, String cc, String bcc, String directorMail) {
		// TODO Auto-generated method stub
		CISResults cisResult = new CISResults();
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                /* "<p>Arcturus Care </b><br />"+*/ 
                
  				
				"<p>Hi, <br />"+
				 "<p>Your care plan schedule has been created.</b><br />"+
				 "<p>Please check updated schedule in Digital Health Care Mobile App. </b><br />"+
				
				 "<p>If you have any questions, please contact our office.</b><br />"+
                
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Care Admin<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.PRODEMAILHOST,CISConstants.PRODEMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,patientEmail, msg, subject,cc,bcc,directorMail);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}
	
	
	/*public CISResults sendAdminMail( String appwith, String startTime, String endTime, String type, String name, String fname, String lname,String lastName, int recurrenceTime, String cc, String bcc) {
		// TODO Auto-generated method stub
		CISResults cisResult = new CISResults();
		String emailId=CISConstants.ADMINEMAILID;
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                 "<p>Arcturus Care </b><br />"+
                
  				
				"<p>Hi " + name +" " + lastName +" , <br />"+
				 "<p>Please find your appointment details.</b><br />"+
                "<br />\n"+
                "<p>"+type+"</b><br />"+
                "<p>"+startTime+"</b><br />"+
				"<p><b>StaffName</b> : "+ fname +" "+ name +"</b><br /><br />"+
				
				
				"<p><b>EndDateTime</b> :"+endTime+"</b><br />"+
				"<p><b>Recurrence</b> :"+recurrenceTime+"</b><br />"+
				 "<p>Please call our office if you have any questions. </b><br />"+
                
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Care Admin<br />\n" +
                "  <br />\n" +
                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.EMAILHOST,CISConstants.EMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,emailId, msg, subject,cc,bcc);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}*/

	public CISResults sendPatientDelMail(String patientEmail,String type, String startTime,String fname, String lname,  String cc, String bcc,String directorMail) {
      
		CISResults cisResult = new CISResults();
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                /* "<p>Arcturus Care </b><br />"+*/
                
  				
				"<p>Hi, <br />"+
				 "<p>Your care plan schedule has been deleted.</b><br />"+
				 "<p>Please check updated schedule in Digital Health Care Mobile App. </b><br />"+
				
				 "<p>If you have any questions, please contact our office.</b><br />"+
                
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Care Admin<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.PRODEMAILHOST,CISConstants.PRODEMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,patientEmail, msg, subject,cc,bcc,directorMail);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}

	public CISResults sendPatientUpdateMail(String patientEmail,
			String appwith, String startTime, String endTime, String type,
			String fname, String lname, int recurrenceTime, String cc, String bcc,String directorMail) {
		
		CISResults cisResult = new CISResults();
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                /* "<p>Arcturus Care </b><br />"+*/
                
  				
				"<p>Hi, <br />"+
				 "<p>Please find your appointment details has been updated.</b><br />"+
                "<br />\n"+
                "<p>"+type+"</b><br />"+
                "<p>Start Date/Time :"+startTime+""+
				"<p>Staff Name : "+ fname +" "+ lname +""+
				"<p>Repeats for "+recurrenceTime+" weeks</b><br />"+
				
				/*"<p><b>EndDateTime</b> :"+endTime+"</b><br />"+
				"<p><b>Recurrence</b> :"+recurrenceTime+"</b><br />"+*/
				 "<p>Please call our office if you have any questions. </b><br />"+
                
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Care Admin<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.PRODEMAILHOST,CISConstants.PRODEMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,patientEmail, msg, subject,cc,bcc,directorMail);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}

	public CISResults sendPatientMailSingle(String patientEmail,
			String appwith, String startTime, String endTime, String type,
			String fname, String lname, int recurrenceTime, String cc, String bcc,String directorMail) {
		
		CISResults cisResult = new CISResults();
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                /* "<p>Arcturus Care </b><br />"+*/
                
  				
				"<p>Hi, <br />"+
				 "<p>Please find your appointment details.</b><br />"+
                "<br />\n"+
                "<p>"+type+"</b><br />"+
                "<p>Start Date/Time :"+startTime+""+
				"<p>Staff Name : "+ fname +" "+ lname +""+
				
				
				 "<p>Please call our office if you have any questions. </b><br />"+
                
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Care Admin<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.PRODEMAILHOST,CISConstants.PRODEMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,patientEmail, msg, subject,cc,bcc, directorMail);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}

	public CISResults sendPatienSingleUpdatetMail(String patientEmail,
			String appwith, String startTime, String endTime, String type,
			String fname, String lname, int recurrenceTime, String cc, String bcc,String directorMail) {
		CISResults cisResult = new CISResults();
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                /* "<p>Arcturus Care </b><br />"+*/
                
  				
				"<p>Hi, <br />"+
				 "<p>Please find your appointment details has been updated.</b><br />"+
                "<br />\n"+
                "<p>"+type+"</b><br />"+
                "<p>Start Date/Time :"+startTime+""+
				"<p>Staff Name : "+ fname +" "+ lname +""+
				/*"<p>Repeats for "+recurrenceTime+" weeks</b><br />"+*/
				
				/*"<p><b>EndDateTime</b> :"+endTime+"</b><br />"+
				"<p><b>Recurrence</b> :"+recurrenceTime+"</b><br />"+*/
				 "<p>Please call our office if you have any questions. </b><br />"+
                
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Care Admin<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.PRODEMAILHOST,CISConstants.PRODEMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,patientEmail, msg, subject,cc,bcc, directorMail);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}

	/*public CISResults sendAdminDelMail(String name, String lastname, String bcc, String cc) {
		CISResults cisResult = new CISResults();
		String emailId=CISConstants.ADMINEMAILID;
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                 "<p>Arcturus Care </b><br />"+
                 
           
  				
				"<p>Hi " + name +" " + lastname +" ,<br /> "+
	
				"<p>The following appointment has been cancelled</b><br />"+
				
				
				
				"<p>Please call our office if you have any questions. </b><br />"+
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Care Admin<br />\n" +
                "  <br />\n" +
                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.EMAILHOST,CISConstants.EMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,emailId, msg, subject,cc,bcc);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}*/
}
