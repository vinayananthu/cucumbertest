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
public class VerifyStepDefinitions {
	
	WrapperMethods wMethods = new WrapperMethods();
	Home home = new Home();
	static WebDriver driver;
	String message = "";
	Boolean result = false;
	// static String TestConstants.tcid ="";
	// static int TestConstants.stepNo=1;
	public static ExtentTest test;
	private GenericAbstract genericAbstract = new GenericAbstract();
	static {
		test = TestStepDefinitions.test;
	}
	
	//--------------------------------- Verify Section (Expected results)------------------------------//
	
		@Then("Verify error {string}")
		public void Verify_error(String error) throws Throwable {
			message = "I receive an error: " + error;
			try {
				result = wMethods.verifyExpectedResult("label", "error", error);
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

		
		//@C702: And Verify notice error "Error!Please enter your state."
		@When("Verify notice error {string}")
		public void verify_notice_error(String error) throws Throwable {
			message = "Verify notice error " + error;
			try {
				result=wMethods.verifyExpectedResult("label", "notice error", error);
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

		
		// @C698: Verify warning "Warning!You must complete the customer agreement
		// below to continue."
		@Then("Verify warning {string}")
		public void verify_warning(String warning) throws Throwable {
			message = "Verify warning " + warning;
			try {
				result = wMethods.verifyExpectedResult("label", "warning", warning);
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
		
		// C700: Verify "/next/landing/index.php" page should be displayed.
		@Then("Verify {string} page should be displayed.")
		public void page_should_be_displayed(String arg1) throws Throwable {
			message = "Verify " + arg1 + " page.";
			try {
				result = wMethods.verifyExpectedResult("url", arg1);
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
		
		@Given("Verify radio button {string} is {string}")
		public void verify_radio_button_is(String arg1, String arg2) throws Throwable {
			message = "Verify radio button \"" + arg1 + "\" is " + arg2;
			try {
				result = wMethods.verifyExpectedResult("radio", arg1, arg2);
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
		
		@When("Verify {string} {string} should be {string}")
		public void verify_should_be(String arg1, String arg2, String arg3) throws Throwable {
			message = arg1 + " " + arg2 + " should be " + arg3;
			try {
				result = wMethods.verifyExpectedResult(arg1, arg2, "field", arg3);
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
		
		
		//possible replacement of the above method
		//C700: And Verify the field "Order Unaddressed Cards" is equal to "25"
		@Given("Verify the field {string} is equal to {string}")
		public void verify_the_field_is_equal_to(String string, String string2) throws Throwable{
			message = "Verify the field "+string+" is equal to "+string2;
			
			try {
				result = wMethods.verifyExpectedResult("field", string, "EQUALS", string2);
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
		
		
		@Then("Verify {string} {string} should be {string} in Order Summary")
		public void should_be_in_Order_Summary(String arg1, String arg2, String arg3) throws Throwable {
			message = arg1 + " " + arg2 + " should be " + arg3 + " in Order Summary";
			try {
				result = wMethods.verifyExpectedResult("link", arg1, arg2, arg3);
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
		
		
		// C701: Verify "Manage Your Address List" label is "present"
		@Given("Verify {string} label is {string}")
		public void verify_label_is(String arg1, String arg2) throws Throwable {
			message = "Verify " + arg1 + " label is " + arg2;
			try {
				result = wMethods.verifyExpectedResult("label", arg1, arg2);
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
		
		
		// C701: Verify "approved" button is "inactive"
		@Given("Verify {string} button is {string}")
		public void verify_button_is(String arg1, String arg2) throws Throwable {
			message = "Verify " + arg1 + " button is " + arg2;
			try {
				result = wMethods.verifyExpectedResult("button", arg1, arg2);
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
		
		// Alternative to above.
		@Given("Check {string} button is {string}")
		public void check_button_is(String arg1, String arg2) throws Throwable {
			message = "Verify " + arg1 + " button is " + arg2;
			try {
				result = wMethods.verifyExpectedResult("button", arg1, arg2);
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
		
		
		@When("Verify {string} checkbox is {string}")
		public void verify_checkbox_is(String string, String string2) throws Exception {
			message = "Verify " + string + " checkbox is " + string2;
			try {
				result = wMethods.verifyExpectedResult("checkbox", string, string2);
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
		
		
		// C2671 : And Verify "Street Address" label "value" should be "1115 Forest
		// Park"
		@When("Verify {string} label {string} should be {string}")
		public void verify_label_should_be(String string, String string2, String string3) throws Throwable {
			message = "Verify " + string + " label " + string2 + " should be " + string3;
			try {
				result = wMethods.verifyExpectedResult("label", string, string2, string3);
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
		
		
		// C703: And Verify "displayed" textbox is "present"
		@When("Verify {string} textbox is {string}")
		public void verify_textbox_is(String string, String string2) throws Throwable {
			message = "Verify " + string + " textbox is " + string2;
			try {
				result = wMethods.verifyExpectedResult("textbox", string, string2);
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
		
		//C708: Verify "Order Summary" header
		@Given("Verify {string} header")
		public void verify_header(String string)throws Throwable {
			message = "Verify "+string+" header";
			try {
				result=wMethods.verifyExpectedResult("header", string);
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
		
		
		//C704: Verify status is "CANCELLED"
		@Then("Verify status is {string}")
		public void verify_status_is(String string) throws Throwable{
			message= "Verify status is "+string;
			try {
				result=wMethods.verifyExpectedResult("status", string);
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
		
		//C709: Verify "Customize Your Order" heading
		@Given("Verify {string} heading")
		public void verify_heading(String string) throws Throwable{
		    message = "Verify "+string +" heading";
		    try {
		    	result=wMethods.verifyExpectedResult("heading", string);
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
		
		//C709: And Verify "Agent Name" textbox with stored value
		@Given("Verify {string} textbox with stored value")
		public void verify_textbox_with_stored(String string) throws Throwable{
			message = "Verify "+string+" textbox with stored value";
			String storedValue = "";
			String variableName=string.replaceAll("\\s", "").replaceAll("_","").toLowerCase().trim();
			storedValue = TestUtils.mapVariables.get(variableName);
			
//			switch (variableName){
//			case "agentname":
//				storedValue=TestUtils.agentname;
//				break;
//			case "companyname":
//				storedValue=TestUtils.companyname;
//				break;
//			case "companyname2":
//				storedValue=TestUtils.companyname2;
//				break;
//			case "address":
//				storedValue=TestUtils.address;
//				break;
//			case "address2":
//				storedValue=TestUtils.address2;
//				break;
//			case "email":
//				storedValue=TestUtils.email;
//				break;
//			case "website":
//				storedValue=TestUtils.website;
//				break;
//			} 
			
			
		    try {
		    	result=wMethods.verifyExpectedResult("textbox",string,"specification",storedValue);
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
		
		
		//
		@Given("Verify {string} table is {string}")
		public void verify_table_is(String string, String string2) throws Throwable{
			message = "Verify "+string +" table is "+string2;	
			
		    try {
		    	result=wMethods.verifyExpectedResult("table", string, string2);
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
		
		//C861: And Verify "office" field in the table is equal to "United, Realtors"
		@Given("Verify {string} field in the table is equal to {string}")
		public void verify_field_in_the_table_is_equal_to(String string, String string2) throws Throwable {
			message = "Verify " + string + " field in the table is equal to " + string2;

			try {
				result = wMethods.verifyExpectedResult("table", string, "Equals", string2);
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
			
		
		//C2649: Verify "Agent Name" textbox is set to "Jane Realtor"
		@Given("Verify {string} textbox is set to {string}")
		public void verify_textbox_is_set_to(String string, String string2) throws Throwable{
			message = "Verify "+string+" textbox is set to "+string2;
			try {
				result=wMethods.verifyExpectedResult("textbox", string,"set", string2);
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
		
		// C2671: And Verify text "Account successfully updated!" is "visible"
		@Given("Verify text {string} is {string}")
		public void verify_text_is(String string, String string2) throws Throwable{
			message= "Verify text "+string+" is "+string2;
			Boolean result;
			String[] stringArray= {};
			try {
				
				if(string.contains("\"")){
					System.out.println("String needs a split.");
					stringArray = string.split("\"");
					String temp="";
					for(int i=0;i<stringArray.length;i++){
						if(i<(stringArray.length-1)){
						stringArray[i]=stringArray[i]+"\\\"";
						}
						temp = temp+stringArray[i];
					}
					string = temp.trim();
					System.out.println("*************************************Split string: "+string);
				}
				
				result=wMethods.verifyExpectedResult("text", string, string2);
				if(result){
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid+" : " + TestConstants.stepNo + " - " + message + " -- executed successfully");
				TestConstants.stepNo++;
				}else{
					Exception e = new Exception("The element '"+string+"' is not'"+string2+"'");
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
		
		
		//C355:  Verify section "Search My Listings" is "visible"
		@Given("Verify section {string} is {string}")
		public void verify_section_is(String string, String string2) throws Throwable{
			message= "Verify section "+string+" is "+string2;
			Boolean result;
			try {
				
				result=wMethods.verifyExpectedResult("section", string, string2);
				if(result){
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid+" : " + TestConstants.stepNo + " - " + message + " -- executed successfully");
				TestConstants.stepNo++;
				}else{
					Exception e = new Exception("The element '"+string+"' is not'"+string2+"'");
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
		
		
		@Given("Verify link {string} is {string}")
		public void verify_link_is(String string, String string2) throws Throwable{
			message= "Verify link "+string+" is "+string2;
			Boolean result;
			try {
				
				result=wMethods.verifyExpectedResult("link", string, string2);
				if(result){
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid+" : " + TestConstants.stepNo + " - " + message + " -- executed successfully");
				TestConstants.stepNo++;
				}else{
					Exception e = new Exception("The element '"+string+"' is not'"+string2+"'");
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
		
		
		@Given("Verify popup {string} is {string}")
		public void verify_popup_is(String string, String string2) throws Throwable{
			message= "Verify popup "+string+" is "+string2;
			Boolean result;
			try {
				
				result=wMethods.verifyExpectedResult("popup", string, string2);
				if(result){
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid+" : " + TestConstants.stepNo + " - " + message + " -- executed successfully");
				TestConstants.stepNo++;
				}else{
					Exception e = new Exception("The element '"+string+"' is not'"+string2+"'");
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
		
		//C1914: And Verify form "*411111******1111" is "visible"
		@Given("Verify form {string} is {string}")
		public void verify_form_is(String string, String string2) throws Throwable{
			message = "Verify form "+string +" is "+string2;
			Boolean result;
			try {
				
				result=wMethods.verifyExpectedResult("form", string, string2);
				if(result){
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid+" : " + TestConstants.stepNo + " - " + message + " -- executed successfully");
				TestConstants.stepNo++;
				}else{
					Exception e = new Exception("The element '"+string+"' is not'"+string2+"'");
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
		
		
		//C1914: And Verify "USED CREDIT CARD1" field in the table is equal to remaining amount
		@Given("Verify {string} field in the table is equal to remaining amount")
		public void verify_field_in_the_table_is_equal_to_remaining_amount(String string)  throws Throwable{
			message = "Verify "+string+" field in the table is equal to remaining amount";
			Boolean result;
			try {
				result = wMethods.verifyExpectedResult("table", string, "Equals", TestUtils.mapVariables.get("splitAmount"));
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
		
		
		//@C1892
		@When("Verify message {string} is {string}")
		public void verify_message_is(String string, String string2) throws Throwable{
			message = "Verify message "+string +" is "+string2;
			Boolean result;
			try {
				
				result=wMethods.verifyExpectedResult("message", string, string2);
				if(result){
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid+" : " + TestConstants.stepNo + " - " + message + " -- executed successfully");
				TestConstants.stepNo++;
				}else{
					Exception e = new Exception("The element '"+string+"' is not'"+string2+"'");
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
		
		
		//C703: Verify confirmation "Do you want cancel order?" is "visible"
		@When("Verify confirmation {string} is {string}")
		public void verify_confirmation_is(String string, String string2)throws Throwable {
			message = "Verify confirmation "+string +" is "+string2;
			Boolean result;
			try {
				
				result=wMethods.verifyExpectedResult("confirmation", string, string2);
				if(result){
				test.log(LogStatus.PASS, TestConstants.stepNo + " - " + message + " -- executed successfully");
				System.out.println(TestConstants.tcid+" : " + TestConstants.stepNo + " - " + message + " -- executed successfully");
				TestConstants.stepNo++;
				}else{
					Exception e = new Exception("The element '"+string+"' is not'"+string2+"'");
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
	
}
