package com.exec.TestNG;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.business_logic.Device_capb;

import HTML_REPORTS.HTMLReportGenerator;
import core.FileInput;
import io.appium.java_client.AppiumDriver;
import page_Object.Home_Page_Method;
import page_Object.Login_Page_Method;
import page_Object.Sign_In_Page_Method;

public class Amzone_exe {
	FileInput files = new FileInput();

	static AppiumDriver driver;

	@Test
	public void testSearchAndCompare() throws Exception {

		Sign_In_Page_Method meth = new Sign_In_Page_Method(driver);
		meth.SignInPageDisplayed();
		meth.clickSignInButton();

		Login_Page_Method login_page = new Login_Page_Method(driver);
		login_page.verifyLogInPageDisplayed();
		login_page.userLogIn();

		Home_Page_Method search = new Home_Page_Method(driver);
		search.HomePageDisplayed();
		search.EnterSearchItem();
		search.verify_product();

	}

	@BeforeTest
	public static void setup() throws IOException {

		Reporter.log("Run the before");

		Device_capb dev = new Device_capb();
		dev.loadCapabilities();
		dev.startAppium();

		try {

			HTMLReportGenerator.TestSuiteStart("C:\\screenshots\\Automation_Reports\\Automation_Reports.html",
					"VF_Pack");

			HTMLReportGenerator.TestCaseStart("Amazone", "Production_Build_number:001");

		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

	@AfterTest
	public static void teardown() {
		Reporter.log("Run the after");
		HTMLReportGenerator.TestCaseEnd();
		HTMLReportGenerator.TestSuiteEnd();

	}

}
