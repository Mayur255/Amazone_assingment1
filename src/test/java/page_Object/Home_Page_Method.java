package page_Object;

import static org.testng.Assert.assertEquals;
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
import com.business_logic.Exl_input_data;

import HTML_REPORTS.HTMLReportGenerator;
import HTML_REPORTS.TakeScreenShot;
import bsh.Console;
import io.appium.java_client.TouchAction;

public class Home_Page_Method extends Base_class {

	WebDriverWait wait = new WebDriverWait(driver, 20);
	Exl_input_data files = new Exl_input_data();

	public Home_Page_Method(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.amazon.mShop.android.shopping:id/rs_search_src_text']")
	private WebElement txtBoxSearch;

	@FindBy(how = How.XPATH, using = "//*[@resource-id=\"com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_query_builder\"]")
	private WebElement buttonAppendSearch;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text']")
	private WebElement productSelected;

	
	public void HomePageDisplayed() throws IOException, InterruptedException {
		try {
			Reporter.log("txtBoxSearch");
			wait.until(ExpectedConditions.visibilityOfAllElements(txtBoxSearch));
			assertTrue(txtBoxSearch.isDisplayed());
			HTMLReportGenerator.StepDetails("Pass", "-  login successfilly and home page is displyed", "",
					TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
		} catch (NoSuchElementException e) {
			Assert.fail("Failed to load Home Page");
			HTMLReportGenerator.StepDetails("Fail", "-  login unsuccessfilly and home page is not displyed", "",
					TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
		}
	}

	/**
	 * Enter the search keyword in search box and select value from auto suggestion
	 */

	public void EnterSearchItem() {
		try {
			txtBoxSearch.click();
			String search_item = files.SearchItem();
			txtBoxSearch.sendKeys(search_item);
			HTMLReportGenerator.StepDetails("Pass", "- Click on search field and Enter search Item ", "",
					TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
			
			wait.until(ExpectedConditions.visibilityOfAllElements(productSelected));

			productSelected.click();			
			HTMLReportGenerator.StepDetails("Pass", "- Selected search Item in dropdown list ", "",
					TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
		} catch (Exception e) {
			Assert.fail("Search process failed");
		}
	}

	

}
