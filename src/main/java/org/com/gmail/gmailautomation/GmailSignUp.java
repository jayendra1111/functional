package org.com.gmail.gmailautomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class GmailSignUp {

	
	
	
	
	@FindBy(xpath="//input[@id='firstName']")
	private WebElement txtbox_fname;
	
	@FindBy(xpath="//input[@id='lastName']")
	private WebElement txtbox_lname;
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement txtbox_username;
	
	@FindBy(xpath="//input[@type='password' and @name='Passwd']")
	private WebElement txtbox_password;
	
	@FindBy(xpath="//input[@type='password' and @name='ConfirmPasswd']")
	private WebElement txtbox_confirmpassword;
	
	@FindBy(xpath="//span[@class='RveJvd snByac']")
	private WebElement btn_next;
	
	public String Password=GenericMethod.GM().generateRandomString();
	
	
	public void fn_signup() throws Throwable{
		GenericMethod.GM().fn_LaunchBrowser("Chrome");
		GenericMethod.GM().driver.get("https://accounts.google.com/signup");
		GenericMethod.GM().driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		GenericMethod.GM().driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		txtbox_fname.sendKeys(GenericMethod.GM().generateRandomString());
		txtbox_lname.sendKeys(GenericMethod.GM().generateRandomString());
		txtbox_username.sendKeys(GenericMethod.GM().generateRandomString());
		txtbox_password.sendKeys(Password);
		txtbox_confirmpassword.sendKeys(Password);
		btn_next.click();
		//GenericMethod.GM().driver.
		
		
		
	}
	
	
}
