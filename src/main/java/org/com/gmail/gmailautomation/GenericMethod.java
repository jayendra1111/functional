package org.com.gmail.gmailautomation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GenericMethod {

	private static GenericMethod GM=null;

	WebDriver driver;

	private static final int RANDOM_STRING_LENGTH =5;
	private static final String Num_LIST ="0123456789";
	private static final String CHAR_LIST ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	int min=1;
	int max=1000;
	float tamt;

	private GenericMethod(){

	}

	public static GenericMethod GM(){
		if(GM==null){
			GM=new GenericMethod();
		}
		return GM;
	}

	@Test
	@Parameters()
	public void fn_LaunchBrowser(String Browsertype) throws Throwable{
		try{
			if(Browsertype.equalsIgnoreCase("FF")||(Browsertype.equalsIgnoreCase("Firefox"))){
				driver=new FirefoxDriver();
			}else if (Browsertype.equalsIgnoreCase("CH")||(Browsertype.equalsIgnoreCase("Chrome"))) {
				System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
				driver=new ChromeDriver();
			}else if (Browsertype.equalsIgnoreCase("IE")||(Browsertype.equalsIgnoreCase("InternetExplorer"))) {
				System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
				//Initialize InternetExplorerDriver Instance.
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
		}catch(Throwable e){
			throw e;
		}
	}




	public void fn_click(WebElement ele) throws Throwable{
		try{
			ele.click();
		}catch(Throwable e){

			throw e;
		}
	}
	public void fn_jsclick(WebElement ele) throws Throwable{
		try{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
		}catch(Throwable e){
			throw e;
		}

	}

	public void fn_Actionclick(WebElement ele) throws Throwable{
		try{
			Actions Actions=new Actions(driver);
			Actions.click(ele).perform();;
		}catch(Throwable e){
			throw e;
		}
	}

	public void fn_mouseoverelement(WebElement ele) throws Throwable{
		try{
			Actions builder=new Actions(driver);
			builder.moveToElement(ele).build().perform();
		}catch(Throwable e){
			throw e;

		}
	}


	public String fn_gettext(WebElement ele) throws Throwable{
		try{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return ele.getText();

		}catch(Throwable e){
			throw e;
		}

	}

	public String generateRandomString(){

		StringBuffer randStr = new StringBuffer();
		for(int i=0; i<RANDOM_STRING_LENGTH; i++){
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}

	public int getRandomNumber() {

		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}

	public int randomNumber()

	{
		Random rand = new Random();
		int randomNum = rand.nextInt((max-min)+1)+min;
		return randomNum;
	}



}
