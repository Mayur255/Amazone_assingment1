package HTML_REPORTS;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
//import org.ejagruti.generic.Generic.UniqueValueEnum;
//import org.ejagruti.modules.LaunchApp;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * @
 *
 */
public class TakeScreenShot {

	public static String TakeScreenShot(String ImagePath,WebDriver driver) throws IOException{
		
		 SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");  
		    Date date = new Date();
		    File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\screenshots\\Automation_Reports\\img2\\"+ formatter.format(date)+".png");
			FileUtils.copyFile(src, dest);
					
			ImagePath="img2/"+ formatter.format(date)+".png";	//Trial 

			return ImagePath;
		
		
	}
/*public static String TakeScreenShot(String ImagePath,WebDriver driver) throws IOException{
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File s1=new File("C:\\screenshots\\img");
			File dest = new File(ImagePath);
			FileUtils.copyFile(src, s1);
			String s = dest.toString();
			return s;
	}*/
	/*public static String TakeScreenShot1(String ImagePath,WebDriver driver) throws IOException
	{
		//WebDriver driver= null;
		TakeScreenShot("c:\\screenshots",driver);
		return null;
	}*/

	
	
	
	public static void main(String[] args) throws InterruptedException, IOException
	{
		
		String path = System.getProperty("user.dir") + "\\Driver\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", path);
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.ideacellular.com");
		Thread.sleep(3000);
		TakeScreenShot("c:\\screenshots\\abc.png",driver);
	}

}
