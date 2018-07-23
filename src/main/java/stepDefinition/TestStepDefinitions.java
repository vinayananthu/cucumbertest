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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

//import org.esi.TestCucumber.TestRunner2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import genericlibrary.global.GenericAbstract;
import genericlibrary.xadmin.Home;
import genericlibrary.xadmin.InterfaceMethods;
import genericlibrary.xadmin.WrapperMethods;
//Test Comment
public class TestStepDefinitions {
	
	WrapperMethods wMethods = new WrapperMethods();
	Home home = new Home();
	static WebDriver driver;
	String message="";
	String tcid ="";
	int stepNo=1;
	public static ExtentTest test;
	private GenericAbstract genericAbstract = new GenericAbstract();
	static {
		// driver.quit();
		TestUtils testUtils = new TestUtils();
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
	
	@When("I Start running test case {string}")
	public void site_is_open(String tcid) throws Throwable {
		this.tcid = tcid;
		test = TestUtils.test;
		test = TestUtils.extent.startTest(tcid);
		System.out.println("Started running test case "+tcid);
		test.log(LogStatus.PASS, "Started running test case "+tcid);
		TestUtils.extent.endTest(test);
	}
		
	
	@When("I impersonate {string} user {string}")
	public void i_impersonate_user(String userType, String id) throws Throwable {
		message = "Impersonate User "+id+" "+userType;
		if(test==null) {
			test = TestUtils.test;
			test = TestUtils.extent.startTest("Impersonate User");
		}
		String result="";
		try {
			String response = wMethods.impersonateUser(userType, id);
		if(response.equals("pass")) {
		System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - executed Successfully");
		test.log(LogStatus.PASS, (stepNo) + " - " +  message+ " - executed Successfully. Note: this is for next scenario in the feature.");
		}
		else {
			test.log(LogStatus.FAIL, (stepNo) + " - " + message+ " - failed with "+response);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed with "+response);
		}
//		stepNo++;
		
		}catch(Exception e) {

			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
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
			String response = wMethods.impersonateUser(userType, id);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - executed Successfully");
			test.log(LogStatus.PASS, (stepNo) + " - " +  message+ " - executed Successfully. Note: this is for next scenario in the feature.");
			stepNo++;
		}catch(Exception e) {

			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
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
		wMethods.navigateTo(string);
		System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - executed Successfully");
		test.log(LogStatus.PASS, (stepNo) + " - " +  message+ " - executed Successfully. Note: this is for next scenario in the feature.");
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}finally {
			TestUtils.extent.endTest(test);
		}
	}
	
	@Given("navigate to {string}")
	public void navigate_to(String string) throws Throwable{
		message = "I login to "+string;
		if(test==null) {
			test = TestUtils.test;
			test = TestUtils.extent.startTest("Login to "+string);
		}
		try{
		wMethods.navigateTo(string);
		System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - executed Successfully");
		test.log(LogStatus.PASS, (stepNo) + " - " +  message+ " - executed Successfully. Note: this is for next scenario in the feature.");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	

//-------------------------------------Click methods below-------------------------------------------//
	
	@When("Click {string} link under {string} category")
	public void click_on_link_under_link(String arg1, String arg2) throws Throwable {
//	    Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
		message = "Click on "+arg1 +" link under "+arg2;
		try {
		
		wMethods.click("category", arg2, arg1);
		wMethods.verifyExpectedResult("url", "next/template.php");
		System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - executed Successfully");
		test.log(LogStatus.PASS, (stepNo) + " - " +  message+ " - executed Successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@When("Click {string} button under {string} template")
	public void click_button_under_template(String arg1, String arg2) throws Throwable {

		message = "Click "+arg1+" button under "+arg2+ " template";
		try {
		wMethods.click("template", arg2, arg1);
		wMethods.verifyExpectedResult("url", "next/template_back.php");
		System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - executed Successfully");
		test.log(LogStatus.PASS, (stepNo) + " - " +  message+ " - executed Successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@When("Click {string} button")
	public void click_button(String buttonName) throws Throwable {
		message = "Click "+buttonName+" button";
		try {
		wMethods.click("Button", buttonName);
		System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - executed Successfully");
		test.log(LogStatus.PASS, (stepNo) + " - " +  message+ " - executed Successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@Given("Click {string} tab")
	public void click_tab(String tabName) throws Throwable{
		message = "Click "+tabName+" tab ";
		try {
		wMethods.click("tab", tabName);
		System.out.println( tcid+" : " + (stepNo) + " - " +message+ " --> executed Successfully");
		test.log(LogStatus.PASS, (stepNo) + " - " +  message+ " --> executed Successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@Given("Click {string} radio button for {string}")
	public void click_radio_button_for(String arg1, String arg2) throws Throwable {
		message = "Click "+arg1+" radio button for "+arg2+" ?";
		try {
	    wMethods.click("radio", arg2, arg1);
	    test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
		System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
//	C701: Click "I agree to the terms and conditions" "checkbox"
	@Given("Click {string} {string}")
	public void click(String arg1, String arg2) throws Throwable {
		message = "Click "+arg1+" "+arg2;
		try {
		    wMethods.click(arg2, arg1);
		    test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
			System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
			stepNo++;
			}catch(Exception e) {
				genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
				System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
				e.printStackTrace();
				throw e;
			}
	}
	

	
	@Given("Click {string} radio button")
	public void click_radio_button(String radioButtonName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		message = "Click "+radioButtonName+" radio button";
		try {
		wMethods.click("radio", radioButtonName);
		test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
		System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@Given("Click {string} radio button under {string}")
	public void click_radio_button_under(String radioButtonName, String arg2) throws Throwable {

		message = "Click at "+ radioButtonName+ " radio button under "+ arg2+"." ;
		try {
		wMethods.click("radio",arg2,radioButtonName);
		test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
		System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	//C2671: And Click "Send Direct Mail" dropdown
	@When("Click {string} dropdown")
	public void click_dropdown(String string) throws Throwable{
	    message = "Click "+ string+ " dropdown";
		try {
		wMethods.click("dropdown", string);
		System.out.println(tcid+" : " + (stepNo) + " - " + "Verified the error.");
		test.log(LogStatus.PASS, (stepNo) + " - " + "Verified the error.");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@Given("Click {string} link")
	public void click_link(String linkName) throws Throwable {
		message = "Click "+linkName+" link";
		try {
		wMethods.click("Link", linkName);
		test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
		System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}

	
	//C388: Click "Edit" icon
	@When("Click {string} icon")
	public void click_icon(String string) throws Throwable{
		message = "Click "+string+" icon";
		click("icon","Edit");
		try {
			wMethods.click("icon",string);
			test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
			System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
			stepNo++;
			}catch(Exception e) {
				genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
				System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
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
		wMethods.select("Dropdown", arg2, arg1);
		test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
		System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	//Check usage
	@Given("Select {string} {string} as {string}")
	public void select_as(String arg1, String arg2, String arg3) throws Throwable {
		message = "Select "+arg1+ " "+arg2+" as "+arg3;
		try {
		wMethods.select(arg1, arg2, arg3);
		test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
		System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@Given("Delete existing credit card details")
	public void delete_existing_credit_card_details() throws Throwable {
		message = " Delete existing credit card details";
		try {
		home.deleteCreditCard();
		test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
		System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	

	//-----------------------------------------Type methods below-------------------------------------------------//
	
	@Given("Type {string} in {string} field")
	public void type_in_field(String arg1, String arg2) throws Throwable {
		message= "type "+arg1+" in "+arg2+" field";
		try {
		wMethods.type(arg2, arg1);
		test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
		System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@Given("Type amountdue in {string} field")
	public void type_amountdue_in_field(String arg1) throws Throwable {
		
		
		message = "type amount due in "+arg1+".";
		try {
		String amountDue=wMethods.store("label","amountdue");
		wMethods.type(arg1,amountDue);
		test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
		System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
		
	}
	
	
	//C2671: Type mlsid in "Search My Listings" field
	@Given("Type mlsid in {string} field")
	public void type_mlsid_in_field(String string)throws Throwable {
		message= "Type mlsid in "+string+" field";
		try {
		wMethods.type(string,wMethods.mlsid);
		test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
		System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	
	//--------------------------------- Verify Section (Expected results)------------------------------//
	
	@Then("Verify error {string}")
	public void Verify_error(String error) throws Throwable {
		message = "I receive an error: "+error;
		try {
		wMethods.verifyExpectedResult("label", "error",error);
		System.out.println(tcid+" : " + (stepNo) + " - " + "Verified the error.");
		test.log(LogStatus.PASS, (stepNo) + " - " + "Verified the error.");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	// C700: Verify "/next/landing/index.php" page should be displayed.
	@Then("Verify {string} page should be displayed.")
	public void page_should_be_displayed(String arg1) throws Throwable {
		message = "Verify "+ arg1+" page.";
		try {
		wMethods.verifyExpectedResult("url", arg1);
		test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
		System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@Given("Verify {string} button {string} is {string}")
	public void verify_button_is(String arg1, String arg2, String arg3) throws Throwable {
		message = "Verify "+arg1 +" button \""+arg2+ "\" is "+arg3;
		try {
		wMethods.verifyExpectedResult(arg1,arg2, arg3);
		test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
		System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@When("Verify {string} {string} should be {string}")
	public void should_be(String arg1, String arg2, String arg3) throws Throwable {
		message=arg1+ " "+arg2+ " should be "+arg3;
		try {
		wMethods.verifyExpectedResult(arg1, arg2, "field", arg3);
		test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
		System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
		
	}
	
	
	@Then("Verify {string} {string} should be {string} in Order Summary")
	public void should_be_in_Order_Summary(String arg1, String arg2, String arg3) throws Throwable {
			message = arg1+ " "+arg2+" should be "+arg3+" in Order Summary";
			try {
			wMethods.verifyExpectedResult("link", arg1, arg2, arg3);
			test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
			System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
			stepNo++;
			}catch(Exception e) {
				genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
				System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
				e.printStackTrace();
				throw e;
			}
	}
	
	
	//C701: Verify "Manage Your Address List" label is "present"
	@Given("Verify {string} label is {string}")
	public void verify_label_is(String arg1, String arg2) throws Throwable {
		message = "Verify "+arg1+" label is "+arg2;
		try {
		wMethods.verifyExpectedResult("label", arg1, arg2);
		test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
		System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	
	// C701: Verify "approved" button is "inactive"
	@Given("Verify {string} button is {string}")
	public void verify_button_is(String arg1, String arg2) throws Throwable {
		message = "Verify "+arg1+" button is "+arg2;
		try {
		wMethods.verifyExpectedResult("button", arg1, arg2);
		test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
		System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	//Alternative to above.
	@Given("Check {string} button is {string}")
	public void check_button_is(String arg1, String arg2) throws Throwable {
		message = "Verify "+arg1+" button is "+arg2;
		try {
		wMethods.verifyExpectedResult("button", arg1, arg2);
		test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
		System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
		stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@When("Verify {string} checkbox is {string}")
	public void verify_checkbox_is(String string, String string2) throws Exception {
		message="Verify "+ string+" checkbox is "+ string2;
		try {
			wMethods.verifyExpectedResult("checkbox", string, string2);
			test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
			System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
			stepNo++;
			}catch(Exception e) {
				genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
				System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
				e.printStackTrace();
				throw e;
			}
	}
	
	
	//C2671 : And Verify "Street Address" label "value" should be "1115 Forest Park" 
	@When("Verify {string} label {string} should be {string}")
	public void verify_label_should_be(String string, String string2, String string3) throws Exception{
		message = "Verify "+string +" label "+ string2+" should be "+string3;
		try {
			wMethods.verifyExpectedResult("label", string,string2,string3);
			test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
			System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
			stepNo++;
			}catch(Exception e) {
				genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
				System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
				e.printStackTrace();
				throw e;
			}
	}
	
	
	//C2671: And Store "mlsid" textbox
	@When("Store {string} textbox")
	public void store_textbox(String string) throws Throwable{
		message= "Store "+string+" textbox";
		try {
			wMethods.store("textbox", string);
			test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
			System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
			stepNo++;
			}catch(Exception e) {
				genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
				System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
				e.printStackTrace();
				throw e;
			}
	}
	
	
	// C2671: And Mouse over "Select Marketing" "dropdown"
	@When("Mouse over {string} dropdown")
	public void mouse_over_dropdown(String string) throws Throwable{
		message= "Mouse over "+string+" dropdown";
		try {
			wMethods.mouseOver("dropdown", "Select Marketing");
			test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
			System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
			stepNo++;
			}catch(Exception e) {
				genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
				System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
				e.printStackTrace();
				throw e;
			}
	}
	
	
	//C388: Browse "1000_FOREST_PARK_BLVD-250.xls"
	@When("Browse {string}")
	public void browse(String string) throws Throwable{
	    message="Browse "+string;
	    try {
			wMethods.browse("Browse", string);
			test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
			System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
			stepNo++;
			}catch(Exception e) {
				genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
				System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
				e.printStackTrace();
				throw e;
			}
	}
	
	//C2671: Close popup
	@Given("Close popup")
	public void close_popup() throws Throwable{
		message = "close popup";
		
		try{
			home.closeModal();
			test.log(LogStatus.PASS, stepNo + " - " + message + " -- executed successfully");
			System.out.println(tcid+" : " + stepNo + " - " + message + " -- executed successfully");
			stepNo++;
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	
	//-------------------------------------End formalities (logging etc.,)-----------------------------//
	@Then("End of test.")
	public void end_of_test() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		message= "Ending test"+tcid;
		try {
		test.log(LogStatus.INFO, "End of current test.");
		TestUtils.extent.endTest(test);
		System.out.println("End of test "+tcid+".");
		}catch(Exception e) {
			genericAbstract.logFailFormalities(e,message,tcid, test, stepNo);
			System.out.println( tcid+" : " + (stepNo) + " - " +message+ " - failed. Error:"+e.getLocalizedMessage()+e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@Given("Execution complete")
	public void execution_complete() throws Throwable {
		
	}
	
	
	@When("End of Execution")
	public void end_of_Execution() throws Throwable {
		test = TestUtils.extent.startTest("Exit");
		test.log(LogStatus.PASS, "End of Execution.");
		TestUtils.extent.flush();
		System.out.println("End of Execution.");
	}

}
