package page_Object;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;




public class Sign_In_Page_Obj{

	
	public Sign_In_Page_Obj(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	

	
	
	@FindBy(how=How.XPATH, using="//*[@resource-id='com.amazon.mShop.android.shopping:id/sign_in_button']")
	public WebElement buttonSignIn;
	
	
	

	
	
}
