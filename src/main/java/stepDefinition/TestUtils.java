package stepDefinition;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;

public class TestUtils {
	public static ExtentTest test;
	public static ExtentReports extent = null;
	public static String currentTime="";
	public static String agentname="";
	public static String companyname="";
	public static String companyname2="";
	public static String address="";
	public static String address2="";
	public static String email="";
	public static String website="";
	public static String mlsid="";
	public static String amountDue="";
	public static String orderid="";
	public static HashMap<String, String> mapVariables= new HashMap<String, String>();
	static {
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	Date date = new Date();
	currentTime = dateFormat.format(date);
	try {
	File dir1 = new File(".");
	String file = dir1.getCanonicalPath() + File.separator + "reports" + File.separator
			+ "TestReports" +TestUtils.currentTime+ ".html";
	extent = new ExtentReports(file);
	}catch(Exception e) {
		System.out.println(e);
		e.printStackTrace();
	}
	
	}
	
	//This method gets executed after every Scenario. Right here it is used to end the current test formalities.
	@After
	public void afterScenario(){
		try {
			test = TestStepDefinitions.test;
			test.log(LogStatus.INFO, "End of current test.");
			TestUtils.extent.endTest(test);
			System.out.println("End of test "+TestConstants.tcid+".");
			TestConstants.stepNo=1;
			}catch(Exception e) {
				e.printStackTrace();
				throw e;
			}
	}
	
	public static String generateFailScreenShotName(String tcid,int stepNo) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");
		Date date = new Date();
		String fileName =  tcid+ "_stepNo_" +stepNo+" "+ sdf.format(date);
		return fileName;

	}

}


