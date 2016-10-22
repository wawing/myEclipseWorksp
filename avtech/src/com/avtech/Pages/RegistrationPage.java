package com.avtech.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.avtech.DataObject.RegisterData;

public class RegistrationPage {
	
	WebDriver driver;
	
	public RegistrationPage (WebDriver driver){ //constructor
		this.driver = driver;
	    driver.findElement(By.linkText("REGISTER")).click();
	}
	public RegistrationPage enterFirstName(){
		driver.findElement(By.name("firstName")).clear();
	    driver.findElement(By.name("firstName")).sendKeys("Bruce");
	    return this;
	}
	public RegistrationPage enterLastName(){
		driver.findElement(By.name("lastName")).clear();
	    driver.findElement(By.name("lastName")).sendKeys("Lee");
	    return this;
	}
	public RegistrationPage enterPhone(){
		driver.findElement(By.name("phone")).clear();
	    driver.findElement(By.name("phone")).sendKeys("732-123-4567");
	    return this;
	}
	public RegistrationPage enterUserName(){
		driver.findElement(By.id("userName")).clear();
	    driver.findElement(By.id("userName")).sendKeys("bruceLeeyahoo.com");
	    return this;
	} 
	public RegistrationPage enterAddress(){
	    driver.findElement(By.name("address1")).clear();
	    driver.findElement(By.name("address1")).sendKeys("1 avtech way");
	    return this;
	} 
	public RegistrationPage enterCity(){
	    driver.findElement(By.name("city")).clear();
	    driver.findElement(By.name("city")).sendKeys("south plainfied");
	    return this;
	}
	public RegistrationPage enterState(){
	    driver.findElement(By.name("state")).clear();
	    driver.findElement(By.name("state")).sendKeys("NJ");
	    return this;
	}
	public RegistrationPage enterPostalCode(){
	    driver.findElement(By.name("postalCode")).clear();
	    driver.findElement(By.name("postalCode")).sendKeys("08873");
	    return this;
	}
	public RegistrationPage selectCountry(){
	    new Select(driver.findElement(By.name("country"))).selectByVisibleText("HONG KONG");
	    return this;
	}
	public RegistrationPage enterEmail(){
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("wassup");
	    return this;
	}
	public RegistrationPage enterPasswd(){
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("123456");
	    return this;
	}
	public RegistrationPage enterConfirmPasswd(){
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("123456");
	    return this;
	}
	public RegistrationPage submitRegistration(){
	    driver.findElement(By.name("register")).click();
	    return this;
	}
	public void RegTestPage (RegisterData regData){  //object with required data is passed in
	    driver.findElement(By.linkText("REGISTER")).click();
	    driver.findElement(By.name("firstName")).clear();
	    //driver.findElement(By.name("firstName")).sendKeys("Bruce");
	    driver.findElement(By.name("firstName")).sendKeys(regData.getFirstName()); //supplied by excel sheet
	    
	    driver.findElement(By.name("lastName")).clear();
	    driver.findElement(By.name("lastName")).sendKeys("Lee");
	    driver.findElement(By.name("phone")).clear();
	    driver.findElement(By.name("phone")).sendKeys("732-221-4567");
	    driver.findElement(By.id("userName")).clear();
	    driver.findElement(By.id("userName")).sendKeys("bruceLeeyahoo.com");
	    driver.findElement(By.name("address1")).clear();
	    driver.findElement(By.name("address1")).sendKeys("1 avtech way");
	    driver.findElement(By.name("city")).clear();
	    driver.findElement(By.name("city")).sendKeys("south plainfied");
	    driver.findElement(By.name("state")).clear();
	    driver.findElement(By.name("state")).sendKeys("NJ");
	    driver.findElement(By.name("postalCode")).clear();
	    driver.findElement(By.name("postalCode")).sendKeys("08873");
	    new Select(driver.findElement(By.name("country"))).selectByVisibleText("HONG KONG");
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("wassup");
	    driver.findElement(By.name("password")).clear();
	   //driver.findElement(By.name("password")).sendKeys("123456");
	    driver.findElement(By.name("password")).sendKeys(regData.getPassWord());
	    
	    driver.findElement(By.name("confirmPassword")).clear();
	    driver.findElement(By.name("confirmPassword")).sendKeys("123456");
	    driver.findElement(By.name("register")).click();
	}

}
