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
import com.business_logic.Base_class;
import HTML_REPORTS.HTMLReportGenerator;
import HTML_REPORTS.TakeScreenShot;

public class Card_page extends Base_class {

	WebDriverWait wait = new WebDriverWait(driver, 20);

	public Card_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[6]/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View")
	private WebElement product_name_loc;

	public void verify_card_product() throws InterruptedException, IOException {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(product_name_loc));
			String Product_decr = "Samsung Galaxy A50s (Prism Crush White, 4GB RAM, 128GB Storage) with No Cost EMI/Additional Exchange Offers";
			String product_name = product_name_loc.getText();

			assertEquals(product_name, Product_decr);
			HTMLReportGenerator.StepDetails("Pass",
					"- Seleted product and actully product same in card " + product_name, "",
					TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));

		} catch (Exception e) {
			Assert.fail("Failed to load Home Page");
			HTMLReportGenerator.StepDetails("Fail", "-  Wrong product is added in card", "",
					TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
		}
	}
}
