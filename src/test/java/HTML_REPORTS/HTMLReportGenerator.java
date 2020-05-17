package HTML_REPORTS;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class HTMLReportGenerator {

	public static ExtentReports report1=null;
	public static ExtentTest logger; 
	
	public static void TestSuiteStart(String ResultHTMLFilePath,String UserName) throws UnknownHostException
	{
		report1=new ExtentReports(ResultHTMLFilePath,false,NetworkMode.ONLINE);
	//	report1=new ExtentReports(ResultHTMLFilePath,false,NetworkMode.OFFLINE);
		System.out.println("report1" + report1 ) ;
		
		report1
			.addSystemInfo("Host Name", InetAddress.getLocalHost().getHostName())
	        .addSystemInfo("Environment", "Production Environment")
	        .addSystemInfo("User Name", "Vodafone Web");
	}
	public static void TestSuiteEnd()
	{
		report1.flush();report1.close();
	}
	public static void TestCaseStart(String TestName,String Description)
	{
		
		logger=report1.startTest(TestName, Description);
	}
	public static void TestCaseEnd()
	{
		report1.endTest(logger);
		
		
	}
	public static void StepDetails(String Status,String StepName,String StepDetails,String objectImagePath)
	{
	//	System.out.println("@@@@@@@@@@@@@@@@@@@@@");

		

	//	System.out.println(logger);
		String tbl=StepDetails+"<br>"+logger.addScreenCapture(objectImagePath);
	//	System.out.println(tbl);
	//	String tbl=StepDetails+logger.addScreenCapture(objectImagePath);
	
		if(Status.equalsIgnoreCase("pass"))
		{		logger.log(LogStatus.PASS,StepName,tbl);}
		else if(Status.equalsIgnoreCase("fail"))
		{		logger.log(LogStatus.FAIL,StepName, tbl);}
		else if(Status.equalsIgnoreCase("error"))
		{		logger.log(LogStatus.ERROR,StepName, tbl);}
		else if(Status.equalsIgnoreCase("info"))
		{		logger.log(LogStatus.INFO,StepName, tbl);}
		else
		{logger.log(LogStatus.INFO,StepName, tbl);}
	
		
	}
	public static void main(String[] args) throws UnknownHostException {
	
	//	System.out.println("**********Hello***********");
		TestSuiteStart("C:\\screenshots\\VodaIdea.html", "Idea_Cellular");
		TestCaseStart("this is test name", "this is description");
		StepDetails("pass", "this is step1", "this is step details1","C:\\screenshots\\DSCN0778.jpg");
		StepDetails("fail", "this is step2", "this is step details2","C:\\screenshots\\DSCN0778.jpg");
		System.out.println("============");
		TestCaseEnd();
		/*
		TestCaseStart("this is test name", "this is description");
		StepDetails("pass", "this is step1", "this is step details1"); 
		StepDetails("fail", "this is step2", "this is step details2");
		TestCaseEnd();
		TestSuiteEnd();*/

	}

}
