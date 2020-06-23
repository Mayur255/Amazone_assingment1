package HTML_REPORTS;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class HTMLReportGenerator {

	public static ExtentReports report1 = null;
	public static ExtentTest logger;

	public static void TestSuiteStart(String ResultHTMLFilePath, String UserName) throws UnknownHostException {
		report1 = new ExtentReports(ResultHTMLFilePath, false, NetworkMode.ONLINE);
		System.out.println("report1" + report1);

		report1.addSystemInfo("Host Name", InetAddress.getLocalHost().getHostName())
				.addSystemInfo("Environment", "Production Environment").addSystemInfo("User Name", "Amazone_App");
	}

	public static void TestSuiteEnd() {
		report1.flush();
		report1.close();
	}

	public static void TestCaseStart(String TestName, String Description) {

		logger = report1.startTest(TestName, Description);
	}

	public static void TestCaseEnd() {
		report1.endTest(logger);
	}

	public static void StepDetails(String Status, String StepName, String StepDetails, String objectImagePath) {

		String tbl = StepDetails + "<br>" + logger.addScreenCapture(objectImagePath);
		if (Status.equalsIgnoreCase("pass")) {
			logger.log(LogStatus.PASS, StepName, tbl);
		} else if (Status.equalsIgnoreCase("fail")) {
			logger.log(LogStatus.FAIL, StepName, tbl);
		} else if (Status.equalsIgnoreCase("error")) {
			logger.log(LogStatus.ERROR, StepName, tbl);
		} else if (Status.equalsIgnoreCase("info")) {
			logger.log(LogStatus.INFO, StepName, tbl);
		} else {
			logger.log(LogStatus.INFO, StepName, tbl);
		}

	}

}
