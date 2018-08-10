package genericlibrary.global;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.IExtentTestClass;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;

import org.openqa.selenium.JavascriptExecutor;
import genericlibrary.testrail.APIClient;
import genericlibrary.testrail.APIException;
import stepDefinition.TestUtils;

public class GenericAbstract {
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");
	// Config Properties
	public static String browser = readProperty("browser");
	public static WebDriver driver = null;
	public String previousUserName = null;
	public static ExtentReports extent = null;
	public static String file = null;

	// Environment
	public String environment = readProperty("environment");
	public String url = readProperty(environment.toLowerCase() + "_admin_url");
	public String username = readProperty(environment.toLowerCase() + "_admin_username");
	public String password = readProperty(environment.toLowerCase() + "_admin_password");
	public boolean hasLoggedIn = false;

	// Login Page elements
	By txtUsername = url.contains("jdserv") ? By.name("username") : By.id("xpressdocs-username");
	By txtPassword = url.contains("jdserv") ? By.name("password") : By.id("xpressdocs-password");
	By btnLogin = url.contains("jdserv") ? By.xpath("//*[@id=\"content_wide\"]/div[2]/fieldset/form/input[4]")
			: By.id("xpressdocs-login");
	By btnClosePopup = By.id("fancybox-close");
	By btnLogout = By.xpath("//*[@id=\"utility_nav\"]/ul/li[3]");

	By JdUsername = By.name("username");
	By JdPassword = By.name("password");
	By JdLogin = By.xpath("//*[@id=\"content_wide\"]/div[2]/fieldset/form/input[4]");

	// Test Rail Access
	public String TESTRAIL_SWITCH = readProperty("testrail_switch");
	public String TESTRAIL_USERNAME = readProperty("testrail_username");
	public String TESTRAIL_PASSWORD = readProperty("testrail_password");
	public String RAILS_ENGINE_URL = readProperty("testrail_engine_url");
	public String TEST_RUN_ID = readProperty("test_runId");
	public final int TEST_CASE_PASSED_STATUS = 1;
	public final int TEST_CASE_FAILED_STATUS = 5;

	// Build page declaration
	public By txtSearchLogin;
	public By lnkLogin;
	public By btnSearchLogin;
	public By lnkLogout;

	public By lnkcompanylogin;
	public By btneditcompany;
	public By tabpreferences;
	public By rdobuildpagebno;
	public By btnupdatecompany;
	public By tabhome;

	// ScreenShot Switch
	public String SCREENSHOT_SWITCH = readProperty("screenshot_switch");

	// Database Switch
	public String DB_ACTIONS_SWITCH = readProperty("db_actions_switch");
	
	// After method
	public ExtentTest test;
	public String message = "";
	public int stepNo = 1;
	public String testCaseID;
	public String testCaseName;
	public String testRailId;

	@BeforeSuite
	public void beforeSuite() throws Exception {
		buildPages();
		File dir1 = new File(".");
		String file = dir1.getCanonicalPath() + File.separator + "src" + File.separator + "reports" + File.separator
				+ "TestReports" + ".html";
		extent = new ExtentReports(file);

	}

	@AfterSuite
	public void afterSuite() {
		// driver.quit();
		extent.flush();
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		try {
			driver.quit();
			driver = null;
		} catch (Exception e) {

		} finally {
			Thread.sleep(12000);
		}
	}

	public boolean db_Actions(String testcaseId,String status, String message, String executionTime) throws Exception{
		boolean db_Actions = false;
		try {
			String url = readProperty("db_url");
			String username = readProperty("db_username");
			String password = readProperty("db_password");
			// Load the Connector/J driver
			Class.forName("com.mysql.jdbc.Driver");
			// Establish connection to MySQL
			Connection conn = DriverManager.getConnection(url, username, password);
			String query = "INSERT INTO test_case_execution (case_id,result, execution_time, comments) VALUES ('" + testRailId + "','" + status+ "', '" + executionTime + "', '" + message + "')";
			// create the java statement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			// execute the preparedstatement
			preparedStmt.execute();
			conn.close();
			db_Actions = true;
		} catch (Exception e) {
			throw e;
		}
		return db_Actions;
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			extent.addSystemInfo("Browser", readProperty("browser"));
			extent.addSystemInfo("Environment", readProperty("environment"));
			extent.addSystemInfo("URL",readProperty(readProperty("environment").toLowerCase()+"_admin_url"));
			if (result.getStatus() == ITestResult.FAILURE) {
				test.log(LogStatus.FAIL, message + "- FAIL");

				if (DB_ACTIONS_SWITCH.trim().toLowerCase().equals("on")) {
					db_Actions(testCaseID,"FAIL", message, dateFormat.format(date));
				}
				addResultForTestCase(testRailId, TEST_CASE_FAILED_STATUS, testCaseName + " Failed to Execute");
				test.log(LogStatus.FAIL, result.getThrowable());
				String screenShotPath = capture(driver, generateFileName(result));
				
				test.log(LogStatus.FAIL,
						"Snapshot below: " + result.getMethod() + test.addScreenCapture(screenShotPath + ".png"));
			} else {
				test.log(LogStatus.PASS, testCaseName + " Executed Successfully - PASS");
				if (DB_ACTIONS_SWITCH.trim().toLowerCase().equals("on")) {
					db_Actions(testCaseID,"PASS", "succesfully completed execution", dateFormat.format(date));
				}
				// Test Rail Pass Status
				addResultForTestCase(testRailId, TEST_CASE_PASSED_STATUS,
						testCaseName + " Executed Successfully - PASS");
			}
			extent.endTest(test);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logFailFormalities(Exception e,String msg, String tcid,ExtentTest failedTest,int stepNo) throws Exception {
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		 failedTest.log(LogStatus.FAIL, (stepNo) + " - " + msg+ " - failed. Error: "+e.getLocalizedMessage()+errors.toString());
//		 String screenShotPath = capture(driver, TestUtils.generateFailScreenShotName(tcid, stepNo));
//		 failedTest.log(LogStatus.FAIL,
//					"Snapshot below: "  + failedTest.addScreenCapture(screenShotPath + ".png"));
		 takeFullScreenShot(tcid, stepNo, failedTest);
	}

	public void fetchURLandCredentials(String applicationName) throws Exception {
		url = readProperty(environment.toLowerCase() + "_" + applicationName.toLowerCase() + "_url");
		username = readProperty(environment.toLowerCase() + "_" + applicationName.toLowerCase() + "_username");
		password = readProperty(environment.toLowerCase() + "_" + applicationName.toLowerCase() + "_password");
	}

	public void loginToXDPublicSite() throws Exception{
		fetchURLandCredentials("Public");
		hasLoggedIn = false;
		loginToXadmin();
	}

	public void loginToXDAdmin() throws Exception{
		fetchURLandCredentials("Admin");
		hasLoggedIn = false;
		loginToXadmin();
	}

	public void loginToJDServe() throws Exception{
		fetchURLandCredentials("JDServ");
		hasLoggedIn = false;
		loginToXadmin();
	}

	public void loginToXadmin() throws Exception{

		try {
			launchDriver();
			getURL();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);

			if (!hasLoggedIn) {
				type(txtUsername, username);
				type(txtPassword, password);
				click(btnLogin);
			}

		} catch (Exception e) {
			throw e;
		}
	}

	public void launchDriver() throws Exception {
		try {
			if (driver == null) {
				if (browser.trim().toLowerCase().equals("firefox")) {
					driver = new FirefoxDriver();
				} else if (browser.trim().toLowerCase().equals("chrome")) {
					System.setProperty("webdriver.chrome.driver", readProperty("chrome"));
					driver = new ChromeDriver();
				} else if (browser.trim().toLowerCase().equals("ibrowser")) {
					System.setProperty("webdriver.ie.driver", readProperty("ibrowser"));
					driver = new InternetExplorerDriver();
				} else if (browser.trim().toLowerCase().equals("edge")) {
					System.setProperty("webdriver.edge.driver", readProperty("edge"));
					driver = new EdgeDriver();
				} else {
					System.setProperty("webdriver.safari.driver", "/Users/Anil/Downloads/safaridriver.exe");
					driver = new SafariDriver();
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public void getURL() throws Exception{
		try {

			if ((browser.trim().toLowerCase().equals("edge")) || (browser.trim().toLowerCase().equals("ibrowser"))) {
				Runtime.getRuntime().exec("C:\\Xd_Path\\AutoIt\\xadminLogin.exe");
				driver.navigate().to(url);
			} else {
				if (url.startsWith("http://www") && url.contains("/next/xadmin/")) {
					url = url.replace("http://www", "");
					url = "http:// " + username + ":" + password + "@www" + url;
					hasLoggedIn = true;
				}
				// driver.navigate().to("https://www.stage.xpressdocs.com/next/checkout.php?uuid=d45971726f7606f2a7a42fee6f6c6c8580c2ca0a");
				driver.get(url);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public void click(By by) {
		try {

			isElementClickable(by);
			driver.findElement(by).click();
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean isElementClickable(By by) {
		boolean returnValue = false;
		try {

			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(by));
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	public void scroll(By by) throws Exception{
		try {
			waitForElementToVisible(by);
			Thread.sleep(1000);
			WebElement scroll = driver.findElement(by);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
			Thread.sleep(1000);
		} catch (Exception e) {
			throw e;
		}
	}

	public void type(By by, String textToType) {
		try {
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(textToType);
		} catch (Exception e) {
			throw e;
		}
	}

	public String getText(By by) throws Exception{
		String returnValue = "";
		try {
			Thread.sleep(1000);
			returnValue = driver.findElement(by).getText();
		} catch (Exception e) {
			throw e;
		}
		return returnValue;
	}

	/*
	 * This method is used to handle the alert box
	 */
	public Boolean handleAlert() throws Exception{
		// String message = null;
		boolean foundAlert = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			message = alert.getText();
			alert.accept();
			foundAlert = true;
		} catch (Exception e) {
			throw e;
		}
		return foundAlert;
	}

	/*
	 * This method is used to switching between multiple windows
	 */
	public boolean switchToNewWindow(String windowName) {
		boolean returnValue = false;
		try {
			Set<String> s = driver.getWindowHandles();
			Iterator<String> ite = s.iterator();
			int window = 1;
			while (ite.hasNext() && window < 10) {
				String popUpHandle = ite.next().toString();
				driver.switchTo().window(popUpHandle);
				if (driver.getTitle().equalsIgnoreCase(windowName)) {
					returnValue = true;
					break;
				}
				window++;
			}
		} catch (Exception e) {
			throw e;
		}
		return returnValue;
	}

	public boolean switchToNewWindow(String windowName, By id, String text) throws Exception{
		boolean returnValue = false;
		try {
			Set<String> s = driver.getWindowHandles();
			Iterator<String> ite = s.iterator();
			int window = 1;
			while (ite.hasNext() && window < 10) {
				String popUpHandle = ite.next().toString();
				driver.switchTo().window(popUpHandle);
				if (driver.getTitle().equalsIgnoreCase(windowName) && getText(id).equalsIgnoreCase(text)) {
					returnValue = true;
					break;
				}
				window++;
			}
		} catch (Exception e) {
			throw e;
		}
		return returnValue;
	}

	public boolean selectFromDropDown(By textBox, String Value) {
		boolean DropDown = false;
		try {
			WebElement pro = driver.findElement(textBox);
			List<WebElement> options = pro.findElements(By.tagName("option"));
			for (int i = 0; i < options.size(); i++) {
				String val = options.get(i).getText().trim();
				if (val.equalsIgnoreCase(Value)) {
					options.get(i).click();
				}
			}

			DropDown = true;
		} catch (Exception e) {
			throw e;
		}
		return DropDown;
	}

	public void selectByVisibleText(By by, String textToSelect) {
		try {
			Select select = new Select(driver.findElement(by));
			select.selectByVisibleText(textToSelect);
		} catch (Exception e) {
			throw e;
		}
	}

	public String selectText(String elementType, String elementName, String textToEnter) throws Exception{
		String returnValue = "";
		String value = convertPath(elementType, elementName);
		By element = getPropertyFile(value);
		selectByVisibleText(element, textToEnter);
		return returnValue;

	}

	public void selectByIndex(By by, int indexToSelect) {
		try {
			Select select = new Select(driver.findElement(by));
			select.selectByIndex(indexToSelect);
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean isElementPresent(By by) {

		boolean returnValue = false;
		try {
			driver.findElement(by);
			returnValue = true;
		} catch (Exception e) {
			throw e;
		}
		return returnValue;
	}

	public boolean isElementDisplayed(By by) {

		boolean returnValue = false;
		try {
			isElementPresent(by);
			returnValue = driver.findElement(by).isDisplayed();
		} catch (Exception e) {
//			throw e;
		}
		return returnValue;
	}

	public void clear(By by) {
		try {
			driver.findElement(by).clear();
		} catch (Exception e) {
			throw e;
		}
	}

	public static void main(String args[]) {

		// System.out.println(readProperty("testrail_engine_url"));

	}

	public static String readProperty(String key){
		try {
		String returnText = "";
			File file = new File("config.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			returnText = properties.getProperty(key);
			fileInput.close();
		return returnText;
		}catch(Exception e) {
			return "Error reading property";
		}
	}

	public String getAttribute(By by) {
		String returnValue = "";
		try {
			returnValue = driver.findElement(by).getAttribute("value");
		} catch (Exception e) {
			throw e;
		}
		return returnValue;
	}

	/*
	 * This method used to get By elements from property files & Convert String to
	 * By elements
	 * 
	 * @return By elements
	 */
	public By getProperty(String pageUrl, String key) throws Exception{

		String returnText = "";
		String type = "";
		String value = "";
		try {

			File dirl = new File(".");
			String file = dirl.getCanonicalPath() + File.separator + "src\\main\\java" + File.separator + "data" + File.separator
					+ "properties" + File.separator + pageUrl + ".properties";
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			returnText = properties.getProperty(key);
			Assert.assertNotNull(returnText);
			String splitPath[] = returnText.split(":", 2);
			type = splitPath[0];
			value = splitPath[1];
			switch (type.toLowerCase()) {
			case "id":
				return By.id(value);

			case "xpath":
				return By.xpath(value);

			case "name":
				return By.name(value);

			case "classname":
				return By.className(value);

			case "cssselector":
				return By.cssSelector(value);

			case "linktext":
				return By.linkText(value);

			case "tagname":
				return By.tagName(value);

			default:
				throw new RuntimeException("Unknown locator " + type + " : " + value);
			}

		}  catch (Exception e) {
			throw e;
		}

	}

	public By getPropertyFile(String key) throws Exception {

		String returnText = null;
		String type = null;
		String value = null;
		String pageUrl = null;
		try {
			File dirl = new File(".");
			String getUrl = driver.getCurrentUrl();
			String[] arrOfUrl = getUrl.split("/", 4);
			String currentUrl = arrOfUrl[3];
			
			if (currentUrl.contains(".php")) {
				pageUrl = currentUrl.split(".php")[0].replace("/", "_");
			} else if (currentUrl.contains("?")) {
				pageUrl = currentUrl.split("\\?")[0].replace("/", "_");
				pageUrl = pageUrl.substring(0, pageUrl.length() - 1);

			} else {
				pageUrl = currentUrl.replace("/", "_").replaceAll(":", "").replaceAll(".html","");
				pageUrl = pageUrl.substring(0, pageUrl.length() - 1);
			}
			String file = dirl.getCanonicalPath() + File.separator + "src//main//java" + File.separator + "data" + File.separator
					+ "properties" + File.separator + pageUrl + ".properties";
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			returnText = properties.getProperty(key);
//			Assert.assertNotNull(returnText);
			String splitPath[] = returnText.split(":", 2);
			type = splitPath[0];
			value = splitPath[1];
			switch (type.toLowerCase()) {
			case "id":
				return By.id(value);

			case "xpath":
				return By.xpath(value);

			case "name":
				return By.name(value);

			case "classname":
				return By.className(value);

			case "cssselector":
				return By.cssSelector(value);

			case "linktext":
				return By.linkText(value);

			case "tagname":
				return By.tagName(value);
			
			default:
				throw new RuntimeException("Unknown locator " + type + " : " + value);
			}
			
		} catch (Exception e) {
			throw e;
		}
		

	}

	public String convertPath(String type, String name) {

		try {
			String rmexclamatory = name.replaceAll("!", "");
			String rmslash = rmexclamatory.replaceAll("/", "").replaceAll(":","").replaceAll(".html","");
			String elementName = rmslash.replaceAll("\\s", "").toLowerCase();
			switch (type.toLowerCase()) {
			case "button":
				return "btn" + elementName;
			case "textbox":
			case "field":
				return "txt" + elementName;

			case "link":
				return "lnk" + elementName;

			case "radio":
				return "rdo" + elementName;

			case "dropdown":
				return "ddl" + elementName;

			case "tab":
			case "section":
				return "tab" + elementName;

			case "checkbox":
				return "chk" + elementName;

			case "table":
				return "tbl" + elementName;

			case "label":
				return "lbl" + elementName;

			case "popup":
			case "pop-up":
				return "pop" + elementName;

			case "icon":
				return "icn" + elementName;

			case "option":
				return "opt" + elementName;

			default:
				throw new RuntimeException("Unknown locator " + name);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public By loginType(String type) {
		switch (type.toLowerCase()) {
		case "agent":
			return By.id("agent_login");

		case "company":
			return By.id("company_login");

		case "branch":
			return By.id("branch_login");

		default:
			throw new RuntimeException("Unknown logintype");
		}
	}

	/*
	 * This method is used to wait for the element to visible
	 */
	public boolean waitForElementToVisible(By by) {
		boolean returnValue = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 250);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			returnValue = true;
		} catch (Exception e) {
			throw e;
		}
		return returnValue;
	}

	public void jdservLogin() throws Exception{
		try {
			driver.get("http://v3web01-dev.xpressdocs.com/jdserv/Account.do?operation=logout");
			type(JdUsername, readProperty("dev_jdserv_username"));
			type(JdPassword, readProperty("dev_jdserv_password"));
			click(JdLogin);

		} catch (Exception e) {
			throw e;
		}
	}

	public void addResultForTestCase(String testCaseId, int status, String message) throws IOException, APIException {

		int testRunId = Integer.parseInt(TEST_RUN_ID);
		if (TESTRAIL_SWITCH.trim().toLowerCase().equals("on")) {
			APIClient client = new APIClient(RAILS_ENGINE_URL);
			client.setUser(TESTRAIL_USERNAME);
			client.setPassword(TESTRAIL_PASSWORD);
			Map data = new HashMap();
			data.put("status_id", status);
			data.put("comment", "" + message + "");
			client.sendPost("add_result_for_case/" + testRunId + "/" + testCaseId + "", data);
		}
	}

	public void selectbydropdowncount(By by) throws Exception{
		try {
			Select select = new Select(driver.findElement(by));
			List<WebElement> options = select.getOptions();
			int count = options.size();
			int c = count - 1;
			selectByIndex(by, c);
			handleAlert();

		} catch (Exception e) {
			throw e;
		}

	}

	/*
	 * This method is used capturing screenshot
	 */
	public String capture(WebDriver driver, String screenShotName) throws IOException {
		if (SCREENSHOT_SWITCH.trim().toLowerCase().equals("on")) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String dest = System.getProperty("user.dir") + File.separator + "src\\main\\java" + File.separator + "reports"
					+ File.separator + screenShotName + ".png";
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
		}
		return screenShotName;
	}

	/**
	 * create generic file name
	 */
	public static String generateFileName(ITestResult result) {

		Date date = new Date();
		String fileName = result.getName() + "_" + sdf.format(date);
		return fileName;

	}

	/**
	 * changes build page B radio button to no.
	 */
	public void buildPages() throws Exception {

		try {
			txtSearchLogin = getProperty("next_index", "txtsearchlogin");
			lnkcompanylogin = getProperty("next_index", "lnkcompanylogin");
			btnSearchLogin = getProperty("next_index", "btnsearchlogin");
			btneditcompany = getProperty("next_xadmin_user_mgmt_index", "btneditcompany");
			tabpreferences = getProperty("next_xadmin_user_mgmt_company_edit", "tabpreferences");
			rdobuildpagebno = getProperty("next_xadmin_user_mgmt_company_edit", "rdobuildpagebno");
			btnupdatecompany = getProperty("next_xadmin_user_mgmt_company_edit", "btnupdatecompany");
			btnupdatecompany = getProperty("next_xadmin_user_mgmt_company_edit", "btnupdatecompany");
			tabhome = getProperty("next_xadmin_user_mgmt_company_edit", "tabhome");

			ArrayList<String> companyName = new ArrayList<String>(
					Arrays.asList("21windermerec", "e164a534", "102SOTHEBYSINTERNATI", "143ATPROPE", "201PRUDENT",
							"287TOWNRES", "289PRUDENT", "16COLDWELLBANKERFL42", "5fd1b4eb", "128PRUDENT", "7f335f82",
							"308ENCOMPA", "261ERA4B67", "135PUBLIC4", "aa5e5ba8", "130COLDWEL"));
			int count = companyName.size();
			for (int i = 0; i < count; i++) {
				loginToXadmin();
				By logintype = loginType("company");
				click(logintype);
				type(txtSearchLogin, companyName.get(i));
				click(btnSearchLogin);
				click(lnkcompanylogin);
				click(btneditcompany);
				click(tabpreferences);
				click(rdobuildpagebno);
				click(btnupdatecompany);
				click(tabhome);
			}

		} catch (Exception e) {
			throw e;

		}

	}
	
	public void takeFullScreenShot(String tcid,int stepNo,ExtentTest failedTest) throws IOException{
	    //WebDriver driver = new FirefoxDriver();
//	    System.setProperty("webdriver.chrome.driver", "yourpath to chromeDriver\\chromedriver.exe");
//	    WebDriver driver = new ChromeDriver();
//	    driver.get("http://www.w3schools.com/");
		String dest = System.getProperty("user.dir") + File.separator + "screenshots"
				+ File.separator + TestUtils.generateFailScreenShotName(tcid, stepNo) + ".png";
	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//	    driver.manage().window().maximize();
	    JavascriptExecutor jexec = (JavascriptExecutor)driver;
	    jexec.executeScript("window.scrollTo(0,0)"); // will scroll to (0,0) position 
	    boolean isScrollBarPresent = (boolean)jexec.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight");
	    long scrollHeight = (long)jexec.executeScript("return document.documentElement.scrollHeight");
	    long clientHeight = (long)jexec.executeScript("return document.documentElement.clientHeight");
	    int fileIndex = 1;
	    if(driver instanceof ChromeDriver){
	        if(isScrollBarPresent){
	            while(scrollHeight > 0){
	                File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	                dest = System.getProperty("user.dir")  + File.separator + "screenshots"
	        				+ File.separator + TestUtils.generateFailScreenShotName(tcid, stepNo) +fileIndex+ ".png";
	                FileUtils.copyFile(srcFile, new File(dest));
	                failedTest.log(LogStatus.FAIL,
	    					"Snapshot below: "  + failedTest.addScreenCapture(dest));
	                jexec.executeScript("window.scrollTo(0,"+clientHeight*fileIndex++ +")");
	                scrollHeight = scrollHeight - clientHeight;
	            }
	        }else{
	            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	            org.apache.commons.io.FileUtils.copyFile(srcFile, new File(dest+ fileIndex+".png"));
	            failedTest.log(LogStatus.FAIL,
    					"Snapshot below: "  + failedTest.addScreenCapture(dest));
	        }
	    }else{
	        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        org.apache.commons.io.FileUtils.copyFile(srcFile, new File(dest));
	        failedTest.log(LogStatus.FAIL,
					"Snapshot below: "  + failedTest.addScreenCapture(dest));
	    }
	    // Combine all the .jpg file to single file
	}

}
