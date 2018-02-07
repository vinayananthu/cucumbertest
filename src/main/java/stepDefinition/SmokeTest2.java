package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//Test Comment
public class SmokeTest2 {
	
	WebDriver driver;
	@Given("^Open Chrome$")
	public void open_firefox() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","C://Vinay//sws//chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
	    //throw new PendingException();
	}

	@Given("^start application$")
	public void start_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		driver.get("https://netchexonline.net");
	}

	@When("^I enter valid \"([^\"]*)\" and valid \"([^\"]*)\"$")
	public void i_enter_valid_username_and_valid_password(String uname, String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
	    //throw new PendingException();
	}

	@Then("^user should be able to login successfully$")
	public void user_should_be_able_to_login_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("btnLogin")).click();
	    //throw new PendingException();
	}
}
