package page_Object;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.business_logic.Base_class;
import com.business_logic.Exl_input_data;
import HTML_REPORTS.HTMLReportGenerator;
import HTML_REPORTS.TakeScreenShot;
;

public class Login_Page_Method extends Base_class{
	
	WebDriverWait wait=new WebDriverWait(driver, 20);
	Login_Page_Object obj=new Login_Page_Object(driver);
	Exl_input_data files= new Exl_input_data();
	

	public void verifyLogInPageDisplayed() throws IOException {
		
		try {
			
			wait.until(ExpectedConditions.visibilityOfAllElements(obj.textBoxMobileNumber));
			assertTrue(obj.textBoxMobileNumber.isDisplayed());
			
			HTMLReportGenerator.StepDetails("Pass"  , "- Sign In page is displyed", "",TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
			System.out.println("page is diplayed");
		} catch (NoSuchElementException e) {
			Assert.fail("Failed to load LogIn Page");
			HTMLReportGenerator.StepDetails("Pass"  , "- Sign In page is  not displyed", "",TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));

		}
		
	}
	
	/**
	 * User login
	 */
	public Login_Page_Method userLogIn() {
		try {
			System.out.println("0000000000000000000");
			String username = files.Username(); 		//Fetching username from TestData.xls
			String password = files.Password(); 		//Fetching login password from TestData.xls
			System.out.println("===="+username);
			System.out.println("====="+password);
			signIn(username, password); //Calling login method
			Assert.assertTrue(true,"Login Successful");
		
		

		
	} catch (Exception e) {
		Assert.fail("Failed to enter login details and Continue");
	}
		return this;
	}	
	
	
	public void signIn(String mobile_no,String pass) throws IOException {
		try {
			System.out.println("Start");
		
			obj.textBoxMobileNumber.click();
			Thread.sleep(2000);
			obj.textBoxMobileNumber.sendKeys(mobile_no);
			Thread.sleep(2000);
			HTMLReportGenerator.StepDetails("Pass"  , "- Enter Mobile number", "",TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
		
			obj.buttonContinue.click();
			HTMLReportGenerator.StepDetails("Pass"  , "- Click on continue button", "",TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));

			wait.until(ExpectedConditions.visibilityOfAllElements(obj.textBoxPassword));

			obj.textBoxPassword.sendKeys(pass);
			Thread.sleep(1000);
			HTMLReportGenerator.StepDetails("Pass"  , "- Enter password", "",TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));

			WebElement buttonLogin=driver.findElement(By.xpath("//*[@resource-id='signInSubmit']"));
			buttonLogin.click();
			
			HTMLReportGenerator.StepDetails("Pass"  , "- Click on login button", "",TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));

			
		} catch (Exception e) {
			System.out.println("error");
			Assert.fail("Failed to enter login details and Continue");
			HTMLReportGenerator.StepDetails("Fail"  , "- Wrong Locator "+e, "",TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));

		}
		
	}
	
}
