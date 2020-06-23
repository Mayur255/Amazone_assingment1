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
public class TakeScreenShot {
	public static String TakeScreenShot(String ImagePath, WebDriver driver) throws IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date = new Date();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\screenshots\\Automation_Reports\\img2\\" + formatter.format(date) + ".png");
		FileUtils.copyFile(src, dest);
		ImagePath = "img2/" + formatter.format(date) + ".png"; 
		return ImagePath;
	}
}
