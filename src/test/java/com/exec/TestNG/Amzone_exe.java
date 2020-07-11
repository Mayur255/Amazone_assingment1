package com.exec.TestNG;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.business_logic.DeviceCapb;

import HTML_REPORTS.HTMLReportGenerator;
import core.FileInput;
import io.appium.java_client.AppiumDriver;
import page_Object.CartPage;
import page_Object.HomePage;
import page_Object.LoginPage;
import page_Object.ProductDetailPage;
import page_Object.SignInPage;

public class Amzone_Exe {
	FileInput files = new FileInput();

	static AppiumDriver driver;

	@Test
	public void testSearchAndCompare() throws Exception {

		SignInPage meth = new SignInPage(driver);
		meth.SignInPageDisplayed();
		meth.clickSignInButton();

		LoginPage login_page = new LoginPage(driver);
		login_page.verifyLogInPageDisplayed();
		login_page.userLogIn();

		HomePage search = new HomePage(driver);
		search.homePageDisplayed();
		search.enterSearchItem();
		
		ProductDetailPage prod=new ProductDetailPage(driver);
		prod.verifyProduct();
		prod.ClickSeeAllBuyingOption();
		prod.AddCard();
		
		CartPage crd=new CartPage(driver);
		crd.verifyCartProduct();
		
		

	}

	@BeforeTest
	public static void setup() throws IOException {

		Reporter.log("Run the before");

		DeviceCapb dev = new DeviceCapb();
		dev.loadCapabilities();
		dev.startAppium();

		try {
			HTMLReportGenerator.TestSuiteStart("C:\\screenshots\\Automation_Reports\\Automation_Reports.html","Amazone_App");
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
