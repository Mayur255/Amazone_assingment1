package page_Object;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

import com.business_logic.BaseClass;

import HTML_REPORTS.HTMLReportGenerator;
import HTML_REPORTS.TakeScreenShot;

public class ProductDetailPage extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 20);
	static String productName=null;

	public ProductDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.amazon.mShop.android.shopping:id/item_title']")
	private WebElement Selected_product;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='titleExpanderContent']")
	private WebElement product_name;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='offers']")
	private WebElement See_all_buying_option_button;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='a-autoid-0']")
	private WebElement Add_to_card;
	
	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.amazon.mShop.android.shopping:id/action_bar_cart_count]")
	private WebElement Card_icon;
	
	/**
	 * Verify the selected product
	 */
	public void verifyProduct() throws InterruptedException, IOException {
		String productDescription = "Samsung Galaxy A50s (Prism Crush White, 6GB RAM, 128GB Storage) with No Cost EMI/Additional Exchange Offers";
		Selected_product.click();
		HTMLReportGenerator.StepDetails("Pass", "Product page is displayed ", "",
				TakeScreenShot.TakeScreenShot(BaseClass.Get_ImageFilePath(), driver));

		wait.until(ExpectedConditions.visibilityOfAllElements(product_name));
		productName = product_name.getText();
		Reporter.log("Displayed product name" + productName);
		assertEquals(productName, productDescription);
		HTMLReportGenerator.StepDetails("Pass", "- Verify search text " + productName, "",
				TakeScreenShot.TakeScreenShot(BaseClass.Get_ImageFilePath(), driver));
	}
	/**
	 * This method clicks on See All Buying button
	 */
	public void ClickSeeAllBuyingOption() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(See_all_buying_option_button));
			assertTrue(See_all_buying_option_button.isDisplayed());
			HTMLReportGenerator.StepDetails("Pass", "-  See all buying option is displayed", "",
					TakeScreenShot.TakeScreenShot(BaseClass.Get_ImageFilePath(), driver));
			See_all_buying_option_button.click();

		} catch (NoSuchElementException e) {
			Assert.fail("Failed to load Home Page");
			HTMLReportGenerator.StepDetails("Fail", "-  See all buying option is not displyed", "",
					TakeScreenShot.TakeScreenShot(BaseClass.Get_ImageFilePath(), driver));
		}
	}

	/**
	 * This method clicks on Add to Cart button
	 */
	public void AddCard() throws InterruptedException, IOException {

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(Add_to_card));
			assertTrue(Add_to_card.isDisplayed());
			HTMLReportGenerator.StepDetails("Pass", "-  Add to card button is displayed and click on this button", "",
					TakeScreenShot.TakeScreenShot(BaseClass.Get_ImageFilePath(), driver));
			Add_to_card.click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			Card_icon.click();

		} catch (NoSuchElementException e) {
			Assert.fail("Failed to load Home Page");
			HTMLReportGenerator.StepDetails("Fail", "-Button not displyed", "",
					TakeScreenShot.TakeScreenShot(BaseClass.Get_ImageFilePath(), driver));
		}
	}
}
