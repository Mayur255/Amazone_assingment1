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

import com.business_logic.Base_class;

import HTML_REPORTS.HTMLReportGenerator;
import HTML_REPORTS.TakeScreenShot;

public class Product_detail_page extends Base_class {

	WebDriverWait wait = new WebDriverWait(driver, 20);
	static String pro_name=null;

	public Product_detail_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.amazon.mShop.android.shopping:id/item_title']")
	private WebElement Selected_product;

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View[12]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View")
	private WebElement product_name;

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View[12]/android.view.View[46]/android.view.View/android.view.View/android.view.View[1]/android.view.View[4]/android.widget.Button")
	private WebElement See_all_buying_option_button;

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[10]/android.view.View[10]/android.widget.Button")
	private WebElement Add_to_card;
	
	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.amazon.mShop.android.shopping:id/action_bar_cart_count")
	private WebElement Card_icon;

	public void verify_product() throws InterruptedException, IOException {
		String Product_decr = "Samsung Galaxy A50s (Prism Crush White, 6GB RAM, 128GB Storage) with No Cost EMI/Additional Exchange Offers";
		Selected_product.click();
		HTMLReportGenerator.StepDetails("Pass", "Product page is displayed ", "",
				TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));

		wait.until(ExpectedConditions.visibilityOfAllElements(product_name));
		pro_name = product_name.getText();
		Reporter.log("Displayed product name" + pro_name);
		assertEquals(pro_name, Product_decr);
		HTMLReportGenerator.StepDetails("Pass", "- Verify search text " + pro_name, "",
				TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
	}

	public void Click_See_all_buying_option() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(See_all_buying_option_button));
			assertTrue(See_all_buying_option_button.isDisplayed());
			HTMLReportGenerator.StepDetails("Pass", "-  See all buying option is displayed", "",
					TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
			See_all_buying_option_button.click();

		} catch (NoSuchElementException e) {
			Assert.fail("Failed to load Home Page");
			HTMLReportGenerator.StepDetails("Fail", "-  See all buying option is not displyed", "",
					TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
		}
	}

	public void Add_card() throws InterruptedException, IOException {

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(Add_to_card));
			assertTrue(Add_to_card.isDisplayed());
			HTMLReportGenerator.StepDetails("Pass", "-  Add to card button is displayed and click on this button", "",
					TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
			Add_to_card.click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			Card_icon.click();

		} catch (NoSuchElementException e) {
			Assert.fail("Failed to load Home Page");
			HTMLReportGenerator.StepDetails("Fail", "-Button not displyed", "",
					TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
		}
	}
}
