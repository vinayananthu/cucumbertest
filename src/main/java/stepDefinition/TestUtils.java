package stepDefinition;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestUtils {
	public static ExtentTest test;
	public static ExtentReports extent = null;
	public static String currentTime="";
	static {
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	Date date = new Date();
	currentTime = dateFormat.format(date);
	try {
	File dir1 = new File(".");
	String file = dir1.getCanonicalPath() + File.separator + "src\\main\\java" + File.separator + "reports" + File.separator
			+ "TestReports" +TestUtils.currentTime+ ".html";
	extent = new ExtentReports(file);
	}catch(Exception e) {
		System.out.println(e);
		e.printStackTrace();
	}
	
	}
	@BeforeSuite
	public void  beforeSuite() {
		System.out.println("Inside before suite.");
	}
	
	@AfterSuite
	public void AfterSuite() {
	System.out.println("Inside After suite.");
	}
	
	public static String generateFailScreenShotName(String tcid,int stepNo) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");
		Date date = new Date();
		String fileName =  tcid+ "_stepNo_" +stepNo+" "+ sdf.format(date);
		return fileName;

	}

}


