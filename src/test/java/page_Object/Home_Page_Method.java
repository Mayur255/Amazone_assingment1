package page_Object;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.business_logic.Base_class;
import com.business_logic.Exl_input_data;

import HTML_REPORTS.HTMLReportGenerator;
import HTML_REPORTS.TakeScreenShot;

import io.appium.java_client.TouchAction;

public class Home_Page_Method extends Base_class {


	Home_Page_Obj obj=new Home_Page_Obj(driver);
	WebDriverWait wait=new WebDriverWait(driver, 20);
	
	
	public void HomePageDisplayed() throws IOException, InterruptedException {
		
		try {
		
			wait.until(ExpectedConditions.visibilityOfAllElements(obj.txtBoxSearch));

			
			assertTrue(obj.txtBoxSearch.isDisplayed());
			
			HTMLReportGenerator.StepDetails("Pass"  , "-  login successfilly and home page is displyed", "",TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));
			} catch (NoSuchElementException e) {
			Assert.fail("Failed to load Home Page");
			HTMLReportGenerator.StepDetails("Fail"  , "-  login unsuccessfilly and home page is not displyed", "",TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));

		}
	
	}
	
	/**
	 * Enter the search keyword in search box and select value from auto suggestion
	 */
	
	public void EnterSearchItem() {
		try {
		
	
		obj.txtBoxSearch.click();
		
		obj.txtBoxSearch.sendKeys("Sumsang a50 mobile phone");
		
		Thread.sleep(2000);
		HTMLReportGenerator.StepDetails("Pass"  , "- Click on search field and Enter search Item ", "",TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));

		
		WebElement productSelected=driver.findElement(By.xpath("//*[@resource-id='com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text']"));

		
		obj.productSelected.click(); 
		
		HTMLReportGenerator.StepDetails("Pass"  , "- Selected search Item in dropdown list ", "",TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));

		Thread.sleep(2000);
		
		} catch (Exception e) {
			Assert.fail("Search process failed");
		}
		
	}
	public void verify_product() throws InterruptedException, IOException
	{
		
		String Product_decr="Samsung Galaxy A50s (Prism Crush White, 4GB RAM, 128GB Storage) with No Cost EMI/Additional Exchange Offers";
		
		obj.Selected_product.click();
		
		Thread.sleep(2000);
		
		HTMLReportGenerator.StepDetails("Pass"  , "Select perticular item ", "",TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));

		wait.until(ExpectedConditions.visibilityOfAllElements(obj.product_name));
		
		
		 String pro_name=obj.product_name.getText();
		 
		 System.out.println("########"+pro_name);
		 assertEquals(pro_name, Product_decr);
		 HTMLReportGenerator.StepDetails("Pass"  , "- Verify search text "+pro_name, "",TakeScreenShot.TakeScreenShot(Base_class.Get_ImageFilePath(), driver));

		
	}
	
}
