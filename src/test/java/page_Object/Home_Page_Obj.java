package page_Object;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Home_Page_Obj {

	public Home_Page_Obj(WebDriver driver) {
			
			PageFactory.initElements(driver,this);
		}
			
	
	
		
	@FindBy(how=How.XPATH, using= "//*[@resource-id='com.amazon.mShop.android.shopping:id/rs_search_src_text']")
	public WebElement txtBoxSearch;
	
	@FindBy(how=How.XPATH, using= "//*[@resource-id=\"com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_query_builder\"]")
	public WebElement buttonAppendSearch;
	
	@FindBy(how=How.XPATH, using= "//*[@resource-id='com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text']")
	public WebElement productSelected;
	
	@FindBy(how=How.XPATH, using= "//*[@resource-id='com.amazon.mShop.android.shopping:id/item_title']")
	public WebElement Selected_product;
	
	@FindBy(how=How.XPATH, using= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View[13]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View")
	public WebElement product_name;
	
}
