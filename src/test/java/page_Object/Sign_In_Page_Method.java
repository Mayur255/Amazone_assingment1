package page_Object;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.business_logic.Base_class;

import HTML_REPORTS.HTMLReportGenerator;
import HTML_REPORTS.TakeScreenShot;

public class Sign_In_Page_Method extends Base_class {

	WebDriverWait wait=new WebDriverWait(driver, 30);		
	
public Sign_In_Page_Method(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.XPATH, using="//*[@resource-id='com.amazon.mShop.android.shopping:id/sign_in_button']")
	public WebElement buttonSignIn;
	
	
	
	
	public void SignInPageDisplayed() throws InterruptedException, IOException {
		
		try {
						
		
			
			wait.until(ExpectedConditions.visibilityOfAllElements(buttonSignIn));
			
				
			boolean b=buttonSignIn.isDisplayed();
			
					
			assertTrue(buttonSignIn.isDisplayed());
			
			HTMLReportGenerator.StepDetails("Pass"  , "- Sign In page is displyed", "",TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
			
			
		} catch (NoSuchElementException e) {
			Reporter.log("=====");
			HTMLReportGenerator.StepDetails("Fail"  , "- Sign In page is not displyed", "",TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));

		}
		
	}
	
	/**
	 * Click Sign In button
	 */
	public void clickSignInButton() {
		try {
			buttonSignIn.click();
			HTMLReportGenerator.StepDetails("Pass"  , "- Click on Sign In button", "",TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
			Reporter.log("Click on Sign in btn");
		} catch (Exception e) {
			Assert.fail("Sign in button is not clickable");
		}
		
	}
}
