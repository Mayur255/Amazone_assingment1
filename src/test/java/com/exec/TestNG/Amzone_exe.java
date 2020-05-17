package com.exec.TestNG;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.business_logic.Base_class;
import com.business_logic.Device_capb;

import HTML_REPORTS.HTMLReportGenerator;
import bsh.Capabilities;
import core.FileInput;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import page_Object.Home_Page_Method;
import page_Object.Login_Page_Method;
import page_Object.Sign_In_Page_Method;
import page_Object.Sign_In_Page_Obj;


public class Amzone_exe {
FileInput files= new FileInput();
	
	static AppiumDriver driver;
	
	@Test
	public void testSearchAndCompare() throws Exception {
		
		 
		
		System.out.println("Mayur Dugad");
		Sign_In_Page_Method meth=new Sign_In_Page_Method();
		meth.SignInPageDisplayed();
		meth.clickSignInButton();
		
		System.out.println("@@@@@@@@@@@");
		Login_Page_Method login_page=new Login_Page_Method();
		login_page.verifyLogInPageDisplayed();
		login_page.userLogIn();
		
		Home_Page_Method search=new Home_Page_Method();
		search.HomePageDisplayed();
		search.EnterSearchItem();
		search.verify_product();
		
	}
	
	
	
	
	@BeforeTest
	public static void setup() throws IOException {
	
	 System.out.println("Ran the before");
	

	 Device_capb dev=new Device_capb();
	 dev.loadCapabilities();
	 dev.startAppium();
		
	  try {
		
	 HTMLReportGenerator.TestSuiteStart("C:\\screenshots\\Automation_Reports\\Automation_Reports.html", "VF_Pack");
			
	 HTMLReportGenerator.TestCaseStart("Voda_Pack", "Production_Build_number:001");
			
	  } catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
    }

	@AfterTest
	public static void teardown() {
		System.out.println("Run the after");
		HTMLReportGenerator.TestCaseEnd();
		HTMLReportGenerator.TestSuiteEnd();

}
	
	
	
}
