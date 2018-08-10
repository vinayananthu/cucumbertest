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
public class TestStepDefinitions2 {
	
	WrapperMethods wMethods = new WrapperMethods();
	Home home = new Home();
	static WebDriver driver;
	String message="";
	static String tcid ="";
	static int stepNo=1;
	public static ExtentTest test;
	TestStepDefinitions testStepDefinitions = new TestStepDefinitions();
	VerifyStepDefinitions verifyStepDefinitions = new VerifyStepDefinitions();
	private GenericAbstract genericAbstract = new GenericAbstract();
	static {
		// driver.quit();
	}

//	C702: And Verify the following "textbox" fields	
//	|Name			|GFL TEST				|
//	|Company		|GFL COMPANY			|
	
	@When("Verify the following fields")
	public void verify_the_following_fields(DataTable dataTable) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<List<String>> data = dataTable.asLists();
		
		for (List<String> dataRow : data) {
			String fieldName = dataRow.get(0);
			String expectedText = dataRow.get(1);
			verifyStepDefinitions.verify_the_field_is_equal_to(fieldName, expectedText);
		}
	}
	
	
//	//C702: And Verify the following elements
//	|productcost		|inactive|
//	|shippingcost		|inactive|
	@When("Verify the following checkboxes")
	public void verify_the_following_elements(DataTable dataTable) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<List<String>> data = dataTable.asLists();
		
		for (List<String> dataRow : data) {
			String checkboxName = dataRow.get(0);
			String checkBoxStatus = dataRow.get(1);
			verifyStepDefinitions.verify_checkbox_is(checkboxName, checkBoxStatus);
		}
	}
	
	
//	C709:And Store following textboxes 
//	|Agent Name		|
//	|Company Name	|
//	|Company Name 2	|
	@Given("Store the following textboxes")
	public void store_following_textboxes(DataTable dataTable) throws Throwable{
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<List<String>> data = dataTable.asLists();
		
		for (List<String> dataRow : data) {
			String textboxName = dataRow.get(0);
			testStepDefinitions.store_textbox(textboxName);
		}
	}
	
	
	
	@When("Type the following")
	public void type_text_in_field(DataTable dataTable) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<List<String>> data = dataTable.asLists();
		
		for (List<String> dataRow : data) {
			testStepDefinitions.type_in_field(dataRow.get(0).toString(),dataRow.get(1).toString());
		}
	}
	
	
	// C709: And Verify the following textboxes with stored values
	// |Agent Name |
	// |Company Name |
	// |Company Name 2 |
	@Given("Verify the following textboxes with stored values")
	public void verify_the_following_textboxes_with_stored_values(DataTable dataTable) throws Throwable{
		List<List<String>> data = dataTable.asLists();

		for (List<String> dataRow : data) {
			verifyStepDefinitions.verify_textbox_with_stored(dataRow.get(0));
		}
	}
	
	@When("Verify the following table values")
	public void verify_the_following_table_values(DataTable dataTable) throws Throwable{
		List<List<String>> data = dataTable.asLists();
		for (List<String> dataRow : data) {
			verifyStepDefinitions.verify_field_in_the_table_is_equal_to(dataRow.get(0),dataRow.get(1));
		}
	}
	
	
	@When("I Create an order with following attributes")
	public void i_Create_an_order_with_following_attributes(DataTable dataTable) throws Throwable{
		List<List<String>> data = dataTable.asLists();
		String userType = data.get(0).get(1);
		String userId = data.get(1).get(1);
		String category = data.get(2).get(1);
		String template = data.get(3).get(1);
		String orderName = data.get(4).get(1);
		String quantity = data.get(5).get(1);
		String orderType = data.get(6).get(1);
		System.out.println("Creating order with following attributes");
		System.out.println("****************************************");
		
		if(userType.toLowerCase().trim().equals("any")){
			
		}

		
		for (List<String> dataRow : data) {
			System.out.println("|"+String.format("%1$-"+(30 - dataRow.get(0).length())+ "s",dataRow.get(0))+"|");
		}	
	
	}

}
