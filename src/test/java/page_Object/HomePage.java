package page_Object;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.business_logic.BaseClass;
import com.business_logic.ExcelData;

import HTML_REPORTS.HTMLReportGenerator;
import HTML_REPORTS.TakeScreenShot;
import bsh.Console;
import io.appium.java_client.TouchAction;

public class HomePage extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 20);
	ExcelData files = new ExcelData();

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.amazon.mShop.android.shopping:id/rs_search_src_text']")
	private WebElement txtBoxSearch;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_query_builder']")
	private WebElement buttonAppendSearch;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text']")
	private WebElement productSelected;

	
	/**
	 * Verification of Home page
	 */
	
	public void homePageDisplayed() throws IOException, InterruptedException {
		try {
			Reporter.log("txtBoxSearch");
			wait.until(ExpectedConditions.visibilityOfAllElements(txtBoxSearch));
			//Rotate landscape mode
			driver.rotate(ScreenOrientation.LANDSCAPE);
			Reporter.log("Waiting for signin page to load");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Rotate portrait mode
			
			assertTrue(txtBoxSearch.isDisplayed());
			HTMLReportGenerator.StepDetails("Pass", "-  login successfilly and home page is displyed", "",
					TakeScreenShot.TakeScreenShot(BaseClass.Get_ImageFilePath(), driver));
		} catch (NoSuchElementException e) {
			Assert.fail("Failed to load Home Page");
			HTMLReportGenerator.StepDetails("Fail", "-  login unsuccessfilly and home page is not displyed", "",
					TakeScreenShot.TakeScreenShot(BaseClass.Get_ImageFilePath(), driver));
		}
	}

	/**
	 * Enter the search keyword in search box and select value from auto suggestion
	 */

	public void enterSearchItem() {
		try {
			txtBoxSearch.click();
			String searchItem = files.SearchItem();
			txtBoxSearch.sendKeys(searchItem);
			HTMLReportGenerator.StepDetails("Pass", "- Click on search field and Enter search Item ", "",
					TakeScreenShot.TakeScreenShot(BaseClass.Get_ImageFilePath(), driver));
			
			wait.until(ExpectedConditions.visibilityOfAllElements(productSelected));
			productSelected.click();			
			HTMLReportGenerator.StepDetails("Pass", "- Selected search Item in dropdown list ", "",
					TakeScreenShot.TakeScreenShot(BaseClass.Get_ImageFilePath(), driver));
		} catch (Exception e) {
			Assert.fail("Search process failed");
		}
	}

	

}
