package com.avtech.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPageTDD {
	
	WebDriver driver;
	
	public RegistrationPageTDD (WebDriver driver){ //constructor
		this.driver = driver;
	    driver.findElement(By.linkText("REGISTER")).click();
	}

	public void RegTestPage (String fN, String lN, String pH, String uN, String addr, String city, 
			String st, String zip, String cc, String email, String pwd, String pwd2){
	    driver.findElement(By.linkText("REGISTER")).click();
	    driver.findElement(By.name("firstName")).clear();
	    driver.findElement(By.name("firstName")).sendKeys(fN);
	    driver.findElement(By.name("lastName")).clear();
	    driver.findElement(By.name("lastName")).sendKeys(lN);
	    driver.findElement(By.name("phone")).clear();
	    driver.findElement(By.name("phone")).sendKeys(pH);
	    driver.findElement(By.id("userName")).clear();
	    driver.findElement(By.id("userName")).sendKeys(uN);
	    driver.findElement(By.name("address1")).clear();
	    driver.findElement(By.name("address1")).sendKeys(addr);
	    driver.findElement(By.name("city")).clear();
	    driver.findElement(By.name("city")).sendKeys(city);
	    driver.findElement(By.name("state")).clear();
	    driver.findElement(By.name("state")).sendKeys(st);
	    driver.findElement(By.name("postalCode")).clear();
	    driver.findElement(By.name("postalCode")).sendKeys(zip);
	    new Select(driver.findElement(By.name("country"))).selectByVisibleText(cc);
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys(email);
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys(pwd);
	    driver.findElement(By.name("confirmPassword")).clear();
	    driver.findElement(By.name("confirmPassword")).sendKeys(pwd);
	    driver.findElement(By.name("register")).click();
	}

}
