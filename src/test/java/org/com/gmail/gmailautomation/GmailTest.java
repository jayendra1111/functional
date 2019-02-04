package org.com.gmail.gmailautomation;

import org.testng.annotations.Test;

public class GmailTest {

	
	@Test
	public void fn_signupprocess() throws Throwable {
		try{
			GmailSignUp gmsignup=new GmailSignUp();
			gmsignup.fn_signup();
			
		}catch(Throwable e){
			throw e;
		}
		
	}
	
	
	
}
