package page_Object;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.business_logic.Base_class;
import com.business_logic.Exl_input_data;

import HTML_REPORTS.HTMLReportGenerator;
import HTML_REPORTS.TakeScreenShot;
import io.appium.java_client.MobileElement;;

public class Login_Page_Method extends Base_class {

	WebDriverWait wait = new WebDriverWait(driver, 20);

	Exl_input_data files = new Exl_input_data();

	public Login_Page_Method(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@resource-id='ap_email_login']")
	private MobileElement textBoxMobileNumber;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='ap_password']")
	private MobileElement textBoxPassword;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='signInSubmit']")
	private MobileElement buttonLogin;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='continue']")
	private MobileElement buttonContinue;

	public void verifyLogInPageDisplayed() throws IOException {

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(textBoxMobileNumber));
			assertTrue(textBoxMobileNumber.isDisplayed());

			HTMLReportGenerator.StepDetails("Pass", "- Sign In page is displyed", "",
					TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
			Reporter.log("page is diplayed");
		} catch (NoSuchElementException e) {
			Assert.fail("Failed to load LogIn Page");
			HTMLReportGenerator.StepDetails("Pass", "- Sign In page is  not displyed", "",
					TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
		}
	}

	/**
	 * User login
	 */
	public Login_Page_Method userLogIn() {
		try {
			Reporter.log("Fatching data");
			String username = files.Username(); // Fetching username from TestData.xls
			String password = files.Password(); // Fetching login password from TestData.xls
			Reporter.log("====" + username);
			Reporter.log("=====" + password);
			signIn(username, password); // Calling login method
			Assert.assertTrue(true, "Login Successful");
		} catch (Exception e) {
			Assert.fail("Failed to enter login details and Continue");
		}
		return this;
	}

	public void signIn(String mobile_no, String pass) throws IOException {
		try {
			Reporter.log("Start");

			textBoxMobileNumber.click();
			wait.until(ExpectedConditions.visibilityOfAllElements(textBoxMobileNumber));
			textBoxMobileNumber.sendKeys(mobile_no);
			HTMLReportGenerator.StepDetails("Pass", "- Enter Mobile number", "",
					TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));

			buttonContinue.click();
			wait.until(ExpectedConditions.visibilityOfAllElements(textBoxPassword));
			textBoxPassword.sendKeys(pass);
			wait.until(ExpectedConditions.visibilityOfAllElements(buttonLogin));
			buttonLogin.click();
			HTMLReportGenerator.StepDetails("Pass", "- Click on login button", "",
					TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
		} catch (Exception e) {
			Reporter.log("error");
			Assert.fail("Failed to enter login details and Continue");
			HTMLReportGenerator.StepDetails("Fail", "- Wrong Locator " + e, "",
					TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
		}
	}
}
