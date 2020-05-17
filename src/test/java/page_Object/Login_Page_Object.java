package page_Object;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.MobileElement;

public class Login_Page_Object{
	
	public Login_Page_Object(WebDriver driver){
		
		PageFactory.initElements(driver,this);
	}

	@FindBy(how=How.XPATH, using= "//*[@resource-id='ap_email_login']")
    public MobileElement textBoxMobileNumber;
	
	@FindBy(how=How.XPATH, using= "//*[@resource-id='ap_password']")
	public MobileElement textBoxPassword;
	
	@FindBy(how=How.XPATH, using= "//*[@resource-id='signInSubmit']")
	public MobileElement buttonLogin;
	
	@FindBy(how=How.XPATH, using= "//*[@resource-id='continue']")
	public MobileElement buttonContinue;
	
	

}
