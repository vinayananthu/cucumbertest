package stepDefinition;

/*
 * This class is the link between Gherkin steps to Selenium methods in the back end.
 * Steps Include:
 * 
 * 1. Click
 * 2. Select
 * 3. Delete
 * 4. Verify
 * 5. Mouse Over
 * 6. Impersonate
 * 7. Login etc.,
 * 
 * @Author: Vinay Kumar Ananthu
 */

import java.io.File;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.esi.TestCucumber.TestRunner2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import genericlibrary.global.GenericAbstract;
import genericlibrary.xadmin.Home;
import genericlibrary.xadmin.WrapperMethods;
import io.cucumber.datatable.DataTable;
//Test Comment
public class TestStepDefinitions {
	
	WrapperMethods wMethods = new WrapperMethods();
	Home home = new Home();
	static WebDriver driver;
	String message="";
	Boolean result =false;
//	static String TestConstants.tcid ="";
//	static int TestConstants.stepNo=1;
	public static ExtentTest test;
	private GenericAbstract genericAbstract = new GenericAbstract();
	static {
		// driver.quit();
		TestConstants.stepNo=1;
		TestConstants.tcNo=1;
	}
	
	
	@Given("^Open Chrome$")
	public void open_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","C://Vinay//sws//chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
	    //throw new PendingException();
	}
	
	
	@Given("I start running the following tests")
	public void i_start_running_the_following_tests(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<List<String>> data = dataTable.asLists();
		if(TestConstants.tcNo < data.size()){
		TestConstants.tcid = data.get(TestConstants.tcNo).get(0);
		test = TestUtils.test;
		test = TestUtils.extent.startTest(TestConstants.tcid);
		System.out.println("Started running test case "+TestConstants.tcid);
		test.log(LogStatus.PASS, "Started running test case "+TestConstants.tcid);
		TestUtils.extent.endTest(test);
		TestConstants.tcNo++;
		}else{
			System.out.println("Please re-verify if the test case numbers are correctly added in the Background.");
		}
	}
	
	
	@When("I Start running test case {string}")
	public void site_is_open(String tcid) throws Throwable {
		TestConstants.tcid = tcid;
		test = TestUtils.test;
		test = TestUtils.extent.startTest(TestConstants.tcid);
		System.out.println("Started running test case "+TestConstants.tcid);
		test.log(LogStatus.PASS, "Started running test case "+TestConstants.tcid);
		TestUtils.extent.endTest(test);
	}
		
	
	@When("I impersonate {string} user {string}")
	public void i_impersonate_user(String userType, String id) throws Throwable {
		message = "Impersonate User "+id+" "+userType;
//		if(test==null) {
//			test = TestUtils.test;
//			test = TestUtils.extent.startTest("Impersonate User");
//		}
//		String result="";
		try {
			Boolean response = wMethods.impersonateUser(userType, id);
		if(response) {
		System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - executed Successfully");
		test.log(LogStatus.PASS, (TestConstants.stepNo) + " - " +  message+ " - executed Successfully. Note: this is for next scenario in the feature.");
		}
		else {
			test.log(LogStatus.FAIL, (TestConstants.stepNo) + " - " + message+ " - failed with "+response);
			System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed with "+response);
		}
		TestConstants.stepNo++;
		
		}catch(Exception e) {

			genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}finally {
			TestUtils.extent.endTest(test);
		}
	}
	
	
	@Given("Impersonate {string} user {string}")
	public void impersonate_user(String userType, String id) throws Throwable{
		message = "Impersonate User "+id+" "+userType;
		try {
			Boolean response = wMethods.impersonateUser(userType, id);
		if(response) {
		System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - executed Successfully");
		test.log(LogStatus.PASS, (TestConstants.stepNo) + " - " +  message+ " - executed Successfully. Note: this is for next scenario in the feature.");
		}
		else {
			test.log(LogStatus.FAIL, (TestConstants.stepNo) + " - " + message+ " - failed with "+response);
			System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed with "+response);
		}
		TestConstants.stepNo++;
		
		}catch(Exception e) {

			genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
//	Given I login to "Xadmin"
	@Given("I login to {string}")
	public void i_login_to(String string) throws Throwable {
		message = "I login to "+string;
		if(test==null) {
			test = TestUtils.test;
			test = TestUtils.extent.startTest("Login to "+string);
		}
		try{
		result=wMethods.navigateTo(string);
		if(result){
			test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
			System.out.println(TestConstants.tcid+" : " + TestConstants.stepNo + " - " + message + " -- executed successfully");
			TestConstants.stepNo++;
			}else{
				Exception e = new Exception(message+" failed");
				genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
				throw e;
			}
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}finally {
//			TestUtils.extent.endTest(test);
		}
	}
	
	@Given("Navigate to {string}")
	public void navigate_to(String string) throws Throwable{
		message = "Navigate to "+string;
		if(test==null) {
			test = TestUtils.test;
			test = TestUtils.extent.startTest("Login to "+string);
		}
		try{
		result=wMethods.navigateTo(string);
		if(result){
			test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
			System.out.println(TestConstants.tcid+" : " + TestConstants.stepNo + " - " + message + " -- executed successfully");
			TestConstants.stepNo++;
			}else{
				Exception e = new Exception(message+" failed");
				genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
				throw e;
			}
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}

	
	//C7908: Navigate to "next/xadmin/user_mgmt/company_edit.php" url
	@When("Navigate to {string} url")
	public void navigate_to_url(String url)throws Throwable {
		message = "Navigate to "+url+" url";
		try{
			result=wMethods.navigateTo(url);
			if(result){
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid+" : " + TestConstants.stepNo + " - " + message + " -- executed successfully");
				TestConstants.stepNo++;
				}else{
					Exception e = new Exception(message+" failed");
					genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
					System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
					throw e;
				}
			}catch(Exception e) {
				genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
				e.printStackTrace();
				throw e;
			}
	}
	

//-------------------------------------Click methods below-------------------------------------------//
	
	@When("Click {string} link under {string} category")
	public void click_on_link_under_link(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		message = "Click on " + arg1 + " link under " + arg2;
		try {

			result = wMethods.click("category", arg2, arg1);
			// wMethods.verifyExpectedResult("url", "next/template.php");
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		} catch (Exception e) {
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@When("Click {string} button under {string} template")
	public void click_button_under_template(String arg1, String arg2) throws Throwable {

		message = "Click " + arg1 + " button under " + arg2 + " template";
		try {
			result = wMethods.click("template", arg2, arg1);
			// wMethods.verifyExpectedResult("url", "next/template_back.php");
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		} catch (Exception e) {
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@When("Click {string} button")
	public void click_button(String buttonName) throws Throwable {
		message = "Click " + buttonName + " button";
		try {
			result = wMethods.click("Button", buttonName);
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		} catch (Exception e) {
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@Given("Click {string} tab")
	public void click_tab(String tabName) throws Throwable {
		message = "Click " + tabName + " tab ";
		try {
			result = wMethods.click("tab", tabName);
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		} catch (Exception e) {
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	@Given("Click {string} radio button for {string}")
	public void click_radio_button_for(String arg1, String arg2) throws Throwable {
		message = "Click " + arg1 + " radio button for " + arg2 + " ?";
		try {
			result = wMethods.click("radio", arg2, arg1);
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		} catch (Exception e) {
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
//	C701: Click "I agree to the terms and conditions" checkbox
	@Given("Click {string} checkbox")
	public void click(String arg1) throws Throwable {
		message = "Click " + arg1 + " checkbox";
		try {
			result = wMethods.click("checkbox", arg1);
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		} catch (Exception e) {
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	

	
	@Given("Click {string} radio button")
	public void click_radio_button(String radioButtonName) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		message = "Click " + radioButtonName + " radio button";
		try {
			result = wMethods.click("radio", radioButtonName);
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		} catch (Exception e) {
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@Given("Click {string} radio button under {string}")
	public void click_radio_button_under(String radioButtonName, String arg2) throws Throwable {

		message = "Click at " + radioButtonName + " radio button under " + arg2 + ".";
		try {
			result = wMethods.click("radio", arg2, radioButtonName);
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		} catch (Exception e) {
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	//C2671: And Click "Send Direct Mail" dropdown
	@When("Click {string} dropdown")
	public void click_dropdown(String string) throws Throwable {
		message = "Click " + string + " dropdown";
		try {
			result = wMethods.click("dropdown", string);
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		} catch (Exception e) {
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	
	//Click "start a new order" link 
	@Given("Click {string} link")
	public void click_link(String linkName) throws Throwable {
		message = "Click " + linkName + " link";
		try {
			result = wMethods.click("Link", linkName);
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		} catch (Exception e) {
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	//
	@Given("I Click {string} link")
	public void i_click_link(String linkName) throws Throwable {
		click_link(linkName);
	}

	
	//C388: Click "Edit" icon
	@When("Click {string} icon")
	public void click_icon(String string) throws Throwable {
		message = "Click " + string + " icon";
		try {
			result = wMethods.click("icon", string);
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		} catch (Exception e) {
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	
	//C1892: And Click "Cancel" on "Mobile Ad pop up"
	@When("Click {string} button on {string}")
	public void click_on(String string, String string2) throws Throwable {
		message = "Click " + string + " on" + string2;
		try {
			result = wMethods.click("Button", "Mobile Ad pop up", "cancel");
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		} catch (Exception e) {
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	
	//C7908: Click "Edit" button under "General Information:"
	@When("Click {string} button under {string}")
	public void click_button_under(String string, String string2) throws Throwable {
		message = "Click " + string + " button under " + string2;
		try {
			result = wMethods.click("Button", string2, string);
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		} catch (Exception e) {
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	
	//C709: Click "View Larger" icon on the "bottom"
	@Given("Click {string} icon on the {string}")
	public void click_icon_on_the(String string, String string2) throws Throwable{
		message = "Click "+string+" icon on the "+string2;
		try {
			result=wMethods.click("icon", string, string2);
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
			}catch(Exception e) {
				genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
				e.printStackTrace();
				throw e;
			}
	}
	
	
	//C345: Click "Edit" icon next to "Follow Up" 
	@Given("Click {string} icon next to {string}")
	public void click_icon_next_to(String string, String string2) throws Throwable{
		message = "Click "+string+" icon next to "+string2;
		try {
			result=wMethods.click("icon", string, string2);
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
			}catch(Exception e) {
				genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
				e.printStackTrace();
				throw e;
			}
	}
	
	//----------------------------------------------Select Methods below-------------------------------------------------------//
	
	//C701: Select "Single and Multi-family" in "address type" dropdown
	@Given("Select {string} in {string} dropdown")
	public void select_in_dropdown(String arg1, String arg2) throws Throwable {
		message = "Select "+arg1+" in "+arg2+" dropdown";
		try {
			result = wMethods.select("Dropdown", arg2, arg1);
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	//Check usage
	@Given("Select {string} {string} as {string}")
	public void select_as(String arg1, String arg2, String arg3) throws Throwable {
		message = "Select " + arg1 + " " + arg2 + " as " + arg3;
		try {
			result = wMethods.select(arg1, arg2, arg3);
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		} catch (Exception e) {
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@Given("Delete existing credit card details")
	public void delete_existing_credit_card_details() throws Throwable {
		message = " Delete existing credit card details";
		try {
			result = home.deleteCreditCard();
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		} catch (Exception e) {
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	

	//-----------------------------------------Type methods below-------------------------------------------------//
	
	@Given("Type {string} in {string} field")
	public void type_in_field(String arg1, String arg2) throws Throwable {
		message = "Type " + arg1 + " in " + arg2 + " field";
		try {
			result = wMethods.type(arg2, arg1);
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		} catch (Exception e) {
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@Given("Type amountdue in {string} field")
	public void type_amountdue_in_field(String arg1) throws Throwable {
		
		
		message = "type amount due in "+arg1+".";
		try {
		String amountDue=wMethods.store("label","amountdue");
		result=wMethods.type(arg1,amountDue);
		if (result) {
			test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
			System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
					+ " -- executed successfully");
			TestConstants.stepNo++;
		} else {
			Exception e = new Exception(message + " failed");
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			throw e;
		}
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
		
	}
	
	
	//C2671: Type mlsid in "Search My Listings" field
	@Given("Type mlsid in {string} field")
	public void type_mlsid_in_field(String string) throws Throwable {
		message = "Type mlsid in " + string + " field";
		try {
			result = wMethods.type(string, TestUtils.mapVariables.get("mlsid"));
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		} catch (Exception e) {
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			e.printStackTrace();
			throw e;
		}
	}

	
	//C1914: Type half the amountdue in "enteramounttocharge1" field
	@When("Type half the amountdue in {string} field")
	public void type_half_the_amountdue_in_field(String string) throws Throwable{
		message = "Type half the amountdue in "+string+ " field";
		try {
			double value = Double.valueOf(TestUtils.mapVariables.get("amountdue")); 
			double amount=value/2;
			String splitAmount=String.valueOf(amount);
			result=wMethods.type(string,splitAmount);
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
			}catch(Exception e) {
				genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
				e.printStackTrace();
				throw e;
			}
	}
	
	
	//@C1914: And Type remaining amountdue in "Enter amount to charge3" field 
	@Given("Type remaining amountdue in {string} field")
	public void type_remaining_amountdue_in_field(String string) throws Throwable{
		message = "Type remaining amountdue in "+string+ " field";
		try {
			double value = Double.valueOf(TestUtils.mapVariables.get("amountdue")); 
			double amount=value-50;
			String splitAmount=String.valueOf(amount);
			TestUtils.mapVariables.put("splitAmount", splitAmount);
			result=wMethods.type(string,splitAmount);
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
			}catch(Exception e) {
				genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
				e.printStackTrace();
				throw e;
			}
	}
	
	//C7908 : Type unique "email" in "email" field
	@When("Type unique {string} in {string} field")
	public void type_unique_in_field(String string, String string2)throws Throwable {
		message = "Type unique "+string+" in "+string2+" field";
		try {
			Date dNow = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
			String uniqueDateTime = ft.format(dNow);
			result=wMethods.type(string, "test" + uniqueDateTime + "@gmail.com");
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
			}catch(Exception e) {
				genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
				e.printStackTrace();
				throw e;
			}
	}
	
	//C1914: Add 10 to amountdue and type the result in "enteramounttocharge"
	@When("Add {int} to amountdue and type the result in {string}")
	public void add_to_amountdue_and_type_the_result_in(Integer int1, String string) throws Throwable {
		message = "Add " + int1 + " to amountdue and type the result in " + string;
		try {
			double value = Double.valueOf(TestUtils.mapVariables.get("amountdue"));
			double amount = (value / 2) + int1;
			String splitAmount = String.valueOf(amount);
			result = wMethods.type(string, splitAmount);
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		} catch (Exception e) {
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@When("Type order_id in {string} field")
	public void type_order_id_in_field(String string) throws Throwable {
		message = "Type order_id in " + string + " field";
		try {
			result = wMethods.type(string, TestUtils.mapVariables.get("orderid"));
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
		} catch (Exception e) {
			genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
					+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
			e.printStackTrace();
			throw e;
		}
	}

	
	//
	@When("Store {string} label")
	public void store_label(String string)throws Throwable {
		
		message= "Store "+ string+ " label";
		String variableName = string.replaceAll("\\s", "").replaceAll("_","").toLowerCase().trim();

		try {
			String storedValue = wMethods.store("label", string);
			TestUtils.mapVariables.put(variableName, storedValue);
	
			test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
			System.out.println(TestConstants.tcid+" : " + TestConstants.stepNo + " - " + message + " -- executed successfully");
			TestConstants.stepNo++;
			}catch(Exception e) {
				genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
				e.printStackTrace();
				throw e;
			}
	}
	
	//C2671: And Store "mlsid" textbox
		@When("Store {string} textbox")
		public void store_textbox(String string) throws Throwable{
			message= "Store "+string+" textbox";
			String variableName = string.replaceAll("\\s", "").toLowerCase().trim();

			try {
				String storedValue = wMethods.store("textbox", string);
				TestUtils.mapVariables.put(variableName, storedValue);
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid+" : " + TestConstants.stepNo + " - " + message + " -- executed successfully");
				TestConstants.stepNo++;
				}catch(Exception e) {
					genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
					System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
					e.printStackTrace();
					throw e;
				}
		}
	
	
	// C2671: And Mouse over "Select Marketing" "dropdown"
	@When("Mouse over {string} dropdown")
	public void mouse_over_dropdown(String string) throws Throwable{
		message= "Mouse over "+string+" dropdown";
		try {
			result=wMethods.mouseOver("dropdown", "Select Marketing");
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
			}catch(Exception e) {
				genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
				e.printStackTrace();
				throw e;
			}
	}
	
	
	//C388: Browse "1000_FOREST_PARK_BLVD-250.xls"
	@When("Browse {string}")
	public void browse(String string) throws Throwable{
	    message="Browse "+string;
	    try {
	    	result=wMethods.browse("Browse", string);
			if (result) {
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid + " : " + TestConstants.stepNo + " - " + message
						+ " -- executed successfully");
				TestConstants.stepNo++;
			} else {
				Exception e = new Exception(message + " failed");
				genericAbstract.logFailFormalities(e, message, TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println(TestConstants.tcid + " : " + (TestConstants.stepNo) + " - " + message
						+ " - failed. Error:" + e.getLocalizedMessage() + e.toString());
				throw e;
			}
			}catch(Exception e) {
				genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
				System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
				e.printStackTrace();
				throw e;
			}
	}
	
	//C2671: Close popup
	@Given("Close popup")
	public void close_popup() throws Throwable{
		message = "Close popup";
		
		try{
			home.closeModal();
			test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
			System.out.println(TestConstants.tcid+" : " + TestConstants.stepNo + " - " + message + " -- executed successfully");
			TestConstants.stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}

	
	//C1914
	@When("Handle the alert")
	public void handle_the_alert() throws Throwable{
		message="Handle the alert";
		try{
			genericAbstract.handleAlert();
			test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
			System.out.println(TestConstants.tcid+" : " + TestConstants.stepNo + " - " + message + " -- executed successfully");
			TestConstants.stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	//C1892: Add address
	@When("Add address")
	public void add_address() throws Throwable{
		message = "Add address";
		try{
			result=home.clickAddAddress();
			test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
			System.out.println(TestConstants.tcid+" : " + TestConstants.stepNo + " - " + message + " -- executed successfully");
			TestConstants.stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,TestConstants.tcid, test, TestConstants.stepNo);
			System.out.println( TestConstants.tcid+" : " + (TestConstants.stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	//-------------------------------------End formalities (logging etc.,)-----------------------------//
	@Then("End of test.")
	public void end_of_test() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println();
	}
	
	
	@Given("Execution complete")
	public void execution_complete() throws Throwable {
		
	}
	
	
	//End of "Order Main"
	@Then("End of {string}")
	public void end_of(String string) {
		test = TestUtils.extent.startTest("End of "+string+".");
		test.log(LogStatus.INFO, "End of "+string+".");
		TestUtils.extent.flush();
		TestConstants.tcNo=1;
		System.out.println("End of "+string+".");
	}
	
	@When("End of Execution")
	public void end_of_Execution() throws Throwable {
//		test = TestUtils.extent.startTest("Exit");
		test.log(LogStatus.INFO, "End of Execution.");
		TestUtils.extent.flush();
		System.out.println("End of Execution.");
	}

}
