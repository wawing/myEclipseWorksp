package com.avtech.DataObject;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import tools.Readexcel1;

public class RegisterData {
	
	private String firstName;
	private String passWord;
	
	public String getFirstName(){
		return firstName;
	}
	public  void setFirstName( String fn ){
		this.firstName=fn;
	}
	
	public String getPassWord(){
		return passWord;
	}
	public  void setPassWord( String pwd ){
		this.passWord=pwd;
	}	
	
	
	@DataProvider(name = "RegistrationData")
	public static Object[][] getExcelData() throws IOException{
		Readexcel1 excel = new Readexcel1();
		return excel.readExcelData();  //Object[][] is returned from excel
		
	}
}
