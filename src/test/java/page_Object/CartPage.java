package page_Object;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.business_logic.BaseClass;
import HTML_REPORTS.HTMLReportGenerator;
import HTML_REPORTS.TakeScreenShot;

public class CartPage extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 20);

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@resource-id='sc-item-Cf7bba0bd-6183-4774-bd6c-aede48afbfba']/android.view.View/android.view.View[1]/android.view.View[2]")
	private WebElement product_name_loc;

	/**
	 * This method Verifies the product available in the card
	 */
	public void verifyCartProduct() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(product_name_loc));
			String productName = product_name_loc.getText();

			assertEquals(productName, ProductDetailPage.productName);
			HTMLReportGenerator.StepDetails("Pass","- Seleted product and actully product same in Cart " + productName, "",
					TakeScreenShot.TakeScreenShot(BaseClass.Get_ImageFilePath(), driver));

		} catch (Exception e) {
			Assert.fail("Failed to load Home Page");
			HTMLReportGenerator.StepDetails("Fail", "-  Wrong product is added in Cart", "",
					TakeScreenShot.TakeScreenShot(BaseClass.Get_ImageFilePath(), driver));
		}
	}
}
