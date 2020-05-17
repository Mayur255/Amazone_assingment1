package page_Object;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.business_logic.Base_class;

import HTML_REPORTS.HTMLReportGenerator;
import HTML_REPORTS.TakeScreenShot;

public class Sign_In_Page_Method extends Base_class {

	Sign_In_Page_Obj obj=new Sign_In_Page_Obj(driver);
	
	public void SignInPageDisplayed() throws InterruptedException, IOException {
		
		try {
						
			WebDriverWait wait=new WebDriverWait(driver, 30);
			
			wait.until(ExpectedConditions.visibilityOfAllElements(obj.buttonSignIn));
			
			System.out.println(obj.buttonSignIn);
			
			boolean b=obj.buttonSignIn.isDisplayed();
			
			System.out.println(b);
		//	if(obj.buttonSignIn.isDisplayed()==true)
			
			assertTrue(obj.buttonSignIn.isDisplayed());
			
			HTMLReportGenerator.StepDetails("Pass"  , "- Sign In page is displyed", "",TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
			
			
		} catch (NoSuchElementException e) {
			System.out.println("=====");
			HTMLReportGenerator.StepDetails("Fail"  , "- Sign In page is not displyed", "",TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));

		}
		
	}
	
	/**
	 * Click Sign In button
	 */
	public void clickSignInButton() {
		try {
			obj.buttonSignIn.click();
			HTMLReportGenerator.StepDetails("Pass"  , "- Click on Sign In button", "",TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
			System.out.println("Click on Sign in btn");
		} catch (Exception e) {
			Assert.fail("Sign in button is not clickable");
		}
		
	}
}
