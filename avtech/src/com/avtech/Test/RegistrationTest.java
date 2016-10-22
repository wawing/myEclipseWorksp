package com.avtech.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.avtech.DataObject.ReadExcelFile;
import com.avtech.DataObject.RegisterData;
import com.avtech.Pages.RegistrationPage;
import com.avtech.Pages.RegistrationPageTDD;

import org.testng.Assert;

public class RegistrationTest extends SharedFunctions {
									//SharedFunctions is a base class where we init the webdriver

	  //private WebDriver driver; ---found in base class
	   static String baseUrl="http://newtours.demoaut.com/";

	  @Test (enabled=false)  //false means do not execute this
	  public void verifyRegistrationTest() throws Exception {
	    driver.get(baseUrl + "/");
	    RegistrationPage RegPage = new RegistrationPage(driver);
	    
	    RegPage.enterFirstName();
	    //RegPage.RegTestPage();  //fill in registration page	and submit it

	    String actualStr=driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > table > tbody > tr > td:nth-of-type(2) > table > tbody > tr:nth-of-type(4) > td > table > tbody > tr > td:nth-of-type(2) > table > tbody > tr:nth-of-type(3) > td > p:nth-of-type(2) > font")).getText();
	    String expectStr="Thank you for registering. You may now sign-in using the user name and password you've just entered.";
	    System.out.println("actual text is:" + actualStr);
	    Assert.assertEquals(expectStr, actualStr);
	    
	    
	  } 
	  
	  @Test(dataProvider = "RegistrationData", dataProviderClass = RegisterData.class) //direct to the class where the provider is
	  public void registerByExcel( String firstName, String pwd ){
		    driver.get(baseUrl + "/");
		    RegistrationPage regPage = new RegistrationPage(driver);
		    RegisterData regData =  new RegisterData(); //will read excel sheet data, myData.xlsx using Readexcel1.java class	
		    regData.setFirstName(firstName);
		    regData.setPassWord(pwd);
		    regPage.RegTestPage(regData); //pass the data object to the page
		    
		    String actualStr=driver.findElement(By.cssSelector("html > body > div:nth-of-type(1) > table > tbody > tr > td:nth-of-type(2) > table > tbody > tr:nth-of-type(4) > td > table > tbody > tr > td:nth-of-type(2) > table > tbody > tr:nth-of-type(3) > td > p:nth-of-type(2) > font")).getText();
		    String expectStr="Thank you for registering. You may now sign-in using the user name and password you've just entered.";
		    System.out.println("actual text is:" + actualStr);
		    
		    Assert.assertEquals(expectStr, actualStr);
		

		  
	  
	  }
	  
    //@Test(dataProvider="usersCredentials",priority=2) //hard coded input data, defined in SharedFunctions base class
	 @Test(dataProvider="getExcelData",priority=2,enabled=false) 	//input data stored in excel, defined in SharedFunctions base class
    // GET ALL TEST DATA FROM A OBJECT ARRAY
    public void registerUsers(String fN, String lN, String pH, String uN, String addr, String city, String st, 
    		String zip, String cc, String email, String pwd, String pwd2){
    	driver.get(baseUrl + "/");
	    RegistrationPageTDD RegPage = new  RegistrationPageTDD(driver);
	    if (fN == null)return; //excel data is null
	    RegPage.RegTestPage(fN, lN, pH, uN, addr, city, st, zip, cc, email, pwd, pwd2);
    }
    
    @Test(priority=3,enabled=false)
    public void readExcelData(){
    	String[][] myExcelData = null;
    	ReadExcelFile ex = new ReadExcelFile(); //defined in DataObject package
    	try {
    		myExcelData=ex.readExcel();   //String 2D Array is returned
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }

    
}

	 

