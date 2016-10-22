package com.avtech.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.avtech.DataObject.ReadExcelFile;

public class SharedFunctions {
	protected WebDriver driver;
	
	 @BeforeClass(alwaysRun = true)
//OK	 @Parameters("browser") //<---defined in multiBrowser.xml file
//OK	  public void setUp( String browser ) throws Exception {
	  public void setUp( ) throws Exception {
		 String browser = "firefox";
		 if (browser.equalsIgnoreCase("firefox")){
			 driver = new FirefoxDriver();  //in base class
		 }
		 else if (browser.equalsIgnoreCase("chrome")){
			 System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			 driver = new ChromeDriver();
		 }
		 else if (browser.equalsIgnoreCase("ie")){	//security zone must be changed to protected
			 System.setProperty("webdriver.ie.driver", ".\\resources\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
		 }
		 else{
			 throw new Exception("browser parameter is not correct");
		 }
		 
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    //driver.manage().window().maximize();
	  }
	 
	 @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	  }

	//This method will return two dimensional array. 
	//This method behaves as data provider for LogIn_Test method. 
	 @DataProvider 
	 public Object[][] usersCredentials(){ 
		 //Created two dimensional array with 4 rows and 2 columns. 
		 //4 rows represents test has to run 4 times. 
		 //2 columns represents 2 data parameters. 
		 Object[][] Cred = new Object[2][12];
		 Cred[0][0] = "firstName1";Cred[0][1] = "lastName1";Cred[0][2]= "908-221-0001";Cred[0][3] = "user01";
		 Cred[0][4] = "50 Cragwood Rd";Cred[0][5] = "So. Plainfield";Cred[0][6] = "NJ";Cred[0][7] = "07080";
		 Cred[0][8] = "HONG KONG";Cred[0][9] = "user1@yahoo.com"; Cred[0][10] = "123456";Cred[0][11] = "123456";
		 
		 Cred[1][0] = "firstName2";Cred[1][1] = "lastName2";Cred[1][2]= "908-221-0002";Cred[1][3] = "user02";
		 Cred[1][4] = "50 Cragwood Rd";Cred[1][5] = "So. Plainfield";Cred[1][6] = "NJ";Cred[1][7] = "07080";
		 Cred[1][8] = "UNITED STATES";Cred[1][9] = "user2@yahoo.com"; Cred[1][10] = "123456";Cred[1][11] = "123456";

		 return Cred;  //Returned Cred 
	 }
	 
	 @DataProvider(name="getExcelData") //written by Wes W
		public Object[][] getExcelData() {
		 	ReadExcelFile ex = new ReadExcelFile();
			Object[][] arrayObject = null;
			try {
				arrayObject = ex.readExcel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return arrayObject;
		}

}
