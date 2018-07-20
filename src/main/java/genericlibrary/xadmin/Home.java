package genericlibrary.xadmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Home extends WrapperMethods implements InterfaceMethods {

	// start New Order
	public By lnkStartNewOrder;
	public By closeXd_pop;

	public By lnkViewAddressses;
	public By txtSearchAddress;
	public By btnFindAddress;
	public By deleteAddress;

	// empty cart
	public By lnkCart;
	public By lnkproceedCheck;
	public By imgremoveOrder;
	public By tabHome;
	public By lnkCcRemove;
	public By icnCart;

	// Shipping Address
	public By rdoBusinessAddressYes;
	public By txtName;
	public By txtCompany;
	public By txtAddress;
	public By txtCity;
	public By ddlState;
	public By txtZip;
	public By ddlCountry;
	public By txtPhoneNumber;
	public By btnSaveAddress;

	// Select Billing
	public By ddlSelectBillingOption;
	public By mobilePop;

	// SearchOrderID
	public By btnsearchorders;
	public By txtOrderId;
	public By btnSearchOrderId;

	// Delete Address
	public By btnManageDoNotMailList;
	public By tabAccount;
	public By addNewAddress;

	// Delete Credit Card
	public By imgDeleteCard;
	public By lblRemove;
	public By creditCard1;
	public By creditCard2;

	// Credit card save Yes
	public By txtCardNumber;
	public By txtCardCvv;
	public By txtExpirationDate;

	// Credit Card Save No
	public By rdoNoSave;
	public By txtCreditCardNumberNO;
	public By txtCvvNO;
	public By txtExpirationNO;

	// Specification
	public String agentname;
	public String companyname;
	public String companyname2;
	public String address;
	public String address2;
	public String email;
	public String website;

	public By txtcartid;
	public By btnsearch;
	public By shipAddress;
	public By chooseContinue;

	public By lblSearchOffice;
	public By delSearchOffice;

	public static String[] image = new String[100];

	// Delete All headshot
	public By icnDelete;
	public int count;
	public By deleteImage;

	// Agent Smart Search
	public static String phone1;
	public static String phone2;
	public static String phone3;
	public static String email1;
	public static String website1;
	public static String title2;

	public String Order_Id;
	public String Total;
	public String OrderId;
	public String URL;
	public String Order_id_2;

	// Search MyListing Quantity
	public String company_qty;
	public String branch_qty;
	public String agent_qty;
	public String list_branch_qty;
	public String list_agent_qty;

	// iframe_headshot_or_photo
	public By iframeHeadshot;
	public By iframePhoto;
	public By txtuploadFiles;
	public By pricingAdmin;
	public By comboBox;

	/**
	 * This method handles (close) the popup in the company/branch/agent home page
	 * 
	 * @return boolean true if successfully closed the popup else false
	 * @page Page:: Company / Branch / Agent Home
	 */
	public boolean closeModal() {

		boolean xdPopup = false;
		try {
			if (driver.getCurrentUrl().contains("/next/proof.php")) {
				Thread.sleep(4000);
			}
			Thread.sleep(1000);
			closeXd_pop = getProperty("next_index", "closexd_pop");
			WebDriverWait wait = new WebDriverWait(driver, 250);
			if (isElementDisplayed(closeXd_pop)) {
				driver.findElement(closeXd_pop).click();
				Thread.sleep(1000);
			}
			xdPopup = true;
		} catch (Exception e) {
			Assert.fail("could not click xdPopup");
		}
		return xdPopup;

	}

	/**
	 * This method used to empty the Cart first then click Start New Order.
	 * 
	 * @page Page: Home
	 * @return elementType & elementName.
	 */
	public String startNewOrder(String elementType, String elementName) {

		try {
			lnkStartNewOrder = getProperty("next_index", "lnkstartaneworder");
			click(lnkStartNewOrder);
			closeModal();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return elementType + elementName;
	}

	/**
	 * This method used to make the cart as empty.
	 * 
	 * @return boolean true if successfully deleted the address, else false.
	 * @page Page: Checkout
	 */
	public boolean emptyCart() {

		int i;
		boolean emptycart = false;
		try {
			lnkCart = getProperty("next_index", "lnkcart");
			lnkproceedCheck = getProperty("next_index", "lnkproceedcheck");
			imgremoveOrder = getProperty("next_index", "imgremoveorder");
			tabHome = getProperty("next_index", "tabhome");
			icnCart = getProperty("next_index", "icncart");
			String text = driver.findElement(icnCart).getText();
			String splitValue = text.split("\\(")[1];
			String value = splitValue.replace(")", "");
			int x = Integer.parseInt(value);
			if (x != 0) {
				click(lnkCart);
				click(lnkproceedCheck);
				for (i = 0; i < x; i++) {
					click(imgremoveOrder);
					Thread.sleep(2000);
					Actions act = new Actions(driver);
					act.sendKeys(Keys.ENTER).build().perform();
					Thread.sleep(2000);
					handleAlert();
				}
				click(tabHome);
			}
			emptycart = true;
		} catch (Exception e) {
			Assert.fail("could not empty cart items");
		}
		return emptycart;
	}

	/**
	 * This method delete an existing address.
	 * 
	 * @return boolean true if successfully deleted the address, else false.
	 * @page Page:: Shipping Options
	 */
	public boolean deleteAddress() {

		boolean DeleteAddress = false;
		int count;
		try {
			if (driver.findElements(By.linkText("Delete")).size() != 0) {
				count = driver.findElements(By.linkText("Delete")).size();
				for (int i = 1; i <= count; i++) {
					driver.findElement(By.linkText("Delete")).click();
					handleAlert();
				}
				return true;
			}
			DeleteAddress = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DeleteAddress;
	}

	/**
	 * This method used to enter address (IsBusiness, Name, Company, Address, City,
	 * State, Zip and Phone).
	 * 
	 * @param data
	 *            instance of class to fetch test data from excel property file
	 * @param testCaseID
	 *            This is the id of current test case that is being executed
	 * @return boolean true if is successfully executed, else false.
	 * @page Page:: Shipping Options
	 */
	public boolean enterAddress(String bussinessAddress, String name, String company, String address, String city,
			String state, String zip, String country, String phone) {
		boolean EnterAddress = false;

		try {
			rdoBusinessAddressYes = getProperty("next_shipping", "rdobusinessaddressyes");
			txtName = getProperty("next_shipping", "txtname");
			txtCompany = getProperty("next_shipping", "txtcompany");
			txtAddress = getProperty("next_shipping", "txtaddress");
			txtCity = getProperty("next_shipping", "txtcity");
			ddlState = getProperty("next_shipping", "ddlstate");
			txtZip = getProperty("next_shipping", "txtzip");
			ddlCountry = getProperty("next_shipping", "ddlcountry");
			txtPhoneNumber = getProperty("next_shipping", "txtphone");
			btnSaveAddress = getProperty("next_shipping", "btnsaveaddress");
			if (bussinessAddress.equalsIgnoreCase("yes")) {
				Thread.sleep(1000);
				click(rdoBusinessAddressYes);
			} else if (bussinessAddress.equalsIgnoreCase("no")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,200)");
				driver.findElement(By.id("radio_residential")).click();
			}
			type(txtName, name);
			type(txtCompany, company);
			type(txtAddress, address);
			type(txtCity, city);
			selectFromDropDown(ddlState, state);
			type(txtZip, zip);
			type(txtPhoneNumber, phone);
			EnterAddress = true;
		} catch (Exception e) {
			Assert.fail("Could not enter address");
		}
		return EnterAddress;
	}

	/**
	 * This method used to select billing option from the dropdown.
	 * 
	 * @return boolean true if selected the billing option successfully, else false.
	 * @page Page:: Order Summary
	 */
	public boolean selectBilling() {

		boolean selectBilling = false;
		try {
			ddlSelectBillingOption = getProperty("next_summary", "ddlselectbillingoption");
			if (driver.findElements(ddlSelectBillingOption).size() != 0) {
				click(ddlSelectBillingOption);
				selectByIndex(ddlSelectBillingOption, 1);
			}
			selectBilling = true;
		} catch (Exception e) {
			Assert.fail("Could not select billing");
		}
		return selectBilling;
	}

	/**
	 * This method is to edit order in edit options function click edit button icon
	 * click edit options textBox
	 * 
	 * @return boolean true if is successfully executed, else false.
	 * @page Page::
	 */
	public boolean editOptions(By path, By optionSelect) {
		boolean Editoptions = false;
		try {
			Thread.sleep(2000);
			click(path);
			scroll(optionSelect);
			Thread.sleep(2000);
			click(optionSelect);
			Thread.sleep(7000);
			Editoptions = true;

		} catch (Exception e) {
			Assert.fail("Could not select edit option");
		}
		return Editoptions;
	}

	/**
	 * This method handles (clicks cancel) mobile ad popup that occurs in Checkout
	 * page.
	 * 
	 * @return boolean true if clicked 'Cancel' in Mobile Ad pop-up successfully,
	 *         else false.
	 * @page page:: Checkout
	 */
	public boolean mobilePopUp() {

		boolean MobilePopup = false;
		try {
			mobilePop = getProperty("next_summary", "mobilepop");
			if (driver.findElements(mobilePop).size() != 0) {
				click(mobilePop);
			}
			MobilePopup = true;
		} catch (Exception e) {
			Assert.fail("Could not select mobile popup");
		}
		return MobilePopup;
	}

	/**
	 * This method is used to click or select image,template.
	 * 
	 * @return boolean true if successfully closed the popup else false
	 *
	 */
	public By getTemplatePath(String templateType, String templateID) {
		try {
			switch (templateID.toLowerCase()) {
			case "image":
			case "thumbnail":
				return By.xpath("//img[@class='template_thumb'][@name='front[" + templateType + "]']");
			case "button":
			case "select":
				return By.xpath("//input[@id='template_" + templateType + "']");
			case "select1":
				return By.xpath("//input[@name='front[" + templateType + "]']");
			default:
				throw new RuntimeException("Unknown Root Element Type :: " + templateType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method used to logout from home page.
	 * 
	 * @throws InterruptedException
	 * @return boolean true if is successfully executed, else false.
	 * @page Page::
	 */

	public boolean logout() throws InterruptedException {
		boolean Logout = false;
		try {
			driver.navigate().refresh();
			click(lnkLogout);
			wait(2);
			driver.close();
			driver = null;
			Logout = true;
		} catch (Exception e) {
			Assert.fail("Could not logout from the application");
		}
		return Logout;
	}

	/**
	 * This method used to mouse hover and click to the textbox content.
	 * 
	 * @return boolean true if is successfully executed, else false
	 */

	public boolean mouseOverClick(By category) {
		boolean MouseHoverClick = false;
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			if (!driver.getCurrentUrl().contains("next/build.php")) {
				js.executeScript("window.scrollBy(0,500)");
			}
			scroll(category);
			WebElement menu = driver.findElement(category);
			Actions builder = new Actions(driver);
			builder.moveToElement(menu).build().perform();
			MouseHoverClick = true;

		} catch (Exception e) {
			Assert.fail("could not mouse hover and click");

		}
		return MouseHoverClick;
	}

	/**
	 * This method searches 'order id' in xAdmin home page. It enters the 'Order ID'
	 * and clicks 'Search' button
	 * 
	 * @return boolean true if is successfully executed, else false.
	 * @throws InterruptedException
	 * @page Page:: XpressAdmin : Home
	 */
	public boolean searchOrderId(String elementType, String elementName) throws InterruptedException {
		boolean SearchOrder = false;
		try {
			btnsearchorders = getProperty("next_account_history", "btnsearchorders");
			txtOrderId = getProperty("next_account_history", "txtorderid");
			btnSearchOrderId = getProperty("next_account_history", "btnsearchorderid");

			By path = getPropertyFile(convertPath(elementType, elementName));
			click(btnsearchorders);
			Thread.sleep(1000);
			if (orderid != null) {
				type(txtOrderId, orderid);
			} else {
				type(txtOrderId, order_id);
			}
			click(btnSearchOrderId);
			scroll(path);
			click(path);
			SearchOrder = true;
		} catch (Exception e) {
			Assert.fail("Could not search order id");
		}
		return SearchOrder;
	}

	/**
	 * This method is used to Delete existing Address
	 * 
	 * @return boolean true if is successfully executed, else false.
	 * @page Page:: XpressAdmin : Do Not Mail Address
	 */
	public boolean deleteMailAddress() {
		boolean SearchOrder = false;
		try {
			lnkViewAddressses = getProperty("next_account_do_not_mail", "lnkviewaddressses");
			txtSearchAddress = getProperty("next_account_do_not_mail", "txtsearchaddress");
			btnFindAddress = getProperty("next_account_do_not_mail", "btnfindaddress");
			deleteAddress = getProperty("next_account_do_not_mail", "icndelete");
			btnManageDoNotMailList = getProperty("next_account_index", "btnmanagedonotmaillist");
			tabAccount = getProperty("next_index", "tabaccount");
			click(btnManageDoNotMailList);
			click(lnkViewAddressses);
			click(lnkViewAddressses);
			type(txtSearchAddress, "3544");
			click(btnFindAddress);
			if (driver.findElements(deleteAddress).size() != 0) {
				click(deleteAddress);
				handleAlert();
			}
			click(tabAccount);
			SearchOrder = true;
		} catch (Exception e) {
			Assert.fail("Could not search order id");
		}
		return SearchOrder;
	}

	/**
	 * This method is to delete the credit card details which is already exits If
	 * already used card details are present it delete the details click DeleteCard
	 * button To handle the alert box handleAlert function is used
	 * 
	 * @return boolean true if is successfully executed, else false.
	 * @page Page::
	 */
	public boolean deleteCreditCard() {
		boolean DeleteCreditCard = false;
		try {
			imgDeleteCard = getProperty("next_checkout", "imgDeleteCard");
			lblRemove = getProperty("next_checkout", "lblremove");
			int pro = driver.findElements(By.className("cc_remove")).size();
			for (int count = 1; count <= pro; count++) {
				if (driver.findElements(lblRemove).size() != 0) {
					click(imgDeleteCard);
					Actions act = new Actions(driver);
					Thread.sleep(2000);
					act.sendKeys(Keys.ENTER).build().perform();
					Thread.sleep(3000);
					handleAlert();
					Thread.sleep(3000);

				} else {
					break;
				}
			}
			DeleteCreditCard = true;
		} catch (Exception e) {
			Assert.fail("Could not delete credit card");
		}
		return DeleteCreditCard;
	}

	/**
	 * This method used to add Credit Card
	 * 
	 * @page Page: Checkout
	 * @return elementPath
	 */
	public String addCard(By elementPath) {

		try {
			lblRemove = getProperty("next_checkout", "lblremove");
			if (driver.findElements(lblRemove).size() != 0) {
				scroll(elementPath);
				click(elementPath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean uploadFiles(String elementName, String filename) {

		boolean uploadFiles = false;
		try {
			// Thread.sleep(2000);
			iframeHeadshot = getProperty("next_build", "iframeheadshot");
			iframePhoto = getProperty("next_build", "iframephoto");
			txtuploadFiles = getProperty("next_build", "uploadfiles");
			if (isElementPresent(iframeHeadshot)) {
				driver.switchTo().frame("id_iframe_headshot");
			} else if (isElementPresent(iframePhoto)) {
				driver.switchTo().frame("id_iframe");
			}
			Thread.sleep(1000);
			WebElement uploadElement = driver.findElement(txtuploadFiles);
			// enter the file path onto the file-selection input field
			uploadElement.sendKeys(readProperty("browseImage") + filename);

			uploadFiles = true;
		} catch (Exception e) {
			Assert.fail("could not upload files");
		}
		return uploadFiles;
	}

	/**
	 * This method used to click complete check out button.
	 * 
	 * @page Page: Checkout
	 * @return elementPath
	 */
	public String completecheckout(By elementPath) {

		try {
			scroll(elementPath);
			click(elementPath);
			Thread.sleep(15000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * This method store the shipping service detail it checks on which counter
	 * value the fedex type is stored then it saves the Estimated arrival and price
	 * detail by using split function
	 * 
	 * @return boolean true if is successfully executed, else false
	 */

	public String storeShippingServiceDetail(By path, String elementName) {
		String value = "";
		try {

			String name = elementName.replaceAll(" ", "").toLowerCase();
			switch (name) {
			case "estimatedarrival":
				String getEstimatedArrival = getText(path);
				String splitEstimatedArrival = getEstimatedArrival.split("Estimated Arrival:")[1];
				value = splitEstimatedArrival;
				break;

			case "price":
				String getSeriviceDetail = getText(path);
				String splitPrice = getSeriviceDetail.split(" ")[0];
				value = splitPrice;
				break;
			default:
				throw new RuntimeException("Could Not Store :: " + elementName);
			}

		} catch (Exception e) {
			Assert.fail("could not store Shipping Service Detail");
		}
		return value;
	}

	/**
	 * This method used to type credit card number
	 * 
	 * @param elementname
	 * @param textToType
	 * @page Page:Checkout
	 * @return elementname,textToType
	 */

	public boolean creditCard(String elementname, String textToType) {

		boolean creditcard = false;
		try {
			String name = elementname.replaceAll("\\s", "").toLowerCase();
			rdoNoSave = getProperty("next_checkout", "rdonosavecc");
			if (driver.findElement(rdoNoSave).isSelected()) {
				Actions action = new Actions(driver);
				switch (name) {
				case "cardnumber:":
				case "cardnumber":
				case "creditcardnumber":
					txtCreditCardNumberNO = getProperty("next_checkout", "txtcardnumberno");
					click(txtCreditCardNumberNO);
					action.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)).build().perform();
					action.sendKeys(textToType).build().perform();
					break;

				case "cardcvv:":
				case "cardcvv":
				case "cvv":
					txtCvvNO = getProperty("next_checkout", "txtcardcvvno");
					click(txtCvvNO);
					action.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)).build().perform();
					action.sendKeys(textToType).build().perform();
					break;

				case "expirationdate:":
				case "expirationdate":
				case "expiration":
					txtExpirationNO = getProperty("next_checkout", "txtexpirationdateno");
					click(txtExpirationNO);
					action.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)).build().perform();
					action.sendKeys(textToType).build().perform();
					break;

				}
			} else {
				Actions action = new Actions(driver);
				switch (name) {
				case "cardnumber":
				case "creditcardnumber":
					txtCardNumber = getProperty("next_checkout", "txtcreditcardnumber");
					click(txtCardNumber);
					action.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)).build().perform();
					action.sendKeys(textToType).build().perform();
					break;
				case "cardcvv":
				case "cvv":
					txtCardCvv = getProperty("next_checkout", "txtcvv");
					click(txtCardCvv);
					action.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)).build().perform();
					action.sendKeys(textToType).build().perform();
					break;
				case "expirationdate":
				case "expiration":
					txtExpirationDate = getProperty("next_checkout", "txtexpiration");
					click(txtExpirationDate);
					action.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)).build().perform();
					action.sendKeys(textToType).build().perform();
					break;
				}
			}
			creditcard = true;
		} catch (Exception e) {
			Assert.fail("could not upload files");
		}
		return creditcard;
	}

	/**
	 * This method used to add address and click radio button corresponding to that
	 * address.
	 * 
	 * @page Page: Shipping
	 * @return boolean true if is successfully executed, else false.
	 **/
	public boolean clickAddAddress() throws Exception{

		boolean ClickAddAddress = false;
		String type = "Is this a business address? ";
		addNewAddress = getProperty("next_shipping", "addnewaddress");
		try {
			deleteAddress();
			if (getText(addNewAddress).contains(type)) {
				enterAddress("yes", "TEST", "Xpressdocs", "4901 N Beach Street", "Fort Worth", "Texas", "76137", "USA",
						"866-977-3627");
				click("Button", "Save this Address");
				ClickAddAddress = true;
			}

		} catch (Exception e) {
			Assert.fail("Could not click add address");
		}
		return ClickAddAddress;

	}

	/**
	 * This method used to verify credit card present or not else enter creditcard
	 * details.
	 * 
	 * @page Page: Checkout
	 * @return boolean true if is successfully executed, else false.
	 */
	public boolean verifyCreditCard() {

		boolean VerifyCreditCard = false;
		try {
			creditCard1 = getProperty("next_checkout", "creditcard1");
			creditCard2 = getProperty("next_checkout", "creditcard2");
			if (driver.findElements(creditCard1).size() != 0) {
				if (driver.findElements(creditCard2).size() != 0) {

					return true;
				} else {

					deleteCreditCard();
					type("creditcardnumber", "4111111111111111");
					type("cvv", "123");
					type("expiration", "12/20");
					click("button", "Save Card");
					click("link", "Add Card");
					type("creditcardnumber", "4242424242424242");
					type("cvv", "123");
					type("expiration", "12/20");
					click("button", "Save Card");
					VerifyCreditCard = true;
				}

			}

		} catch (Exception e) {
			Assert.fail("Could not click add address");
		}
		return VerifyCreditCard;

	}

	/*
	 * this method find the stored order id in pending order list it checks which
	 * pending order contains the order_id if it fetches the order id then it click
	 * Place/Edit link
	 * 
	 * @return boolean true if is successfully executed, else false.
	 */
	public boolean findOrderId() {
		boolean order = false;
		String ordername = "gfl162935";
		String ordername1 = "gfl162935_New";
		try {
			int counter = 2;
			while (counter < 7) {
				if (driver.findElement(By.xpath("//html//div[@class='tab-container']//tr[" + counter + "]//td[4]"))
						.getText().contains(order_id)) {
					click(By.xpath("//html//div[@class='tab-container']//tr[" + counter + "]//td[2]/a"));
					break;
				} else
					counter++;
			}
			while (counter < 7) {
				if (driver.findElement(By.xpath("//html//div[@class='tab-container']//tr[" + counter + "]//td[4]"))
						.getText().contains(ordername)) {
					click(By.xpath("//html//div[@class='tab-container']//tr[" + counter + "]//td[2]/a"));
					break;
				} else
					counter++;
			}
			while (counter < 7) {
				if (driver.findElement(By.xpath("//html//div[@class='tab-container']//tr[" + counter + "]//td[4]"))
						.getText().contains(ordername1)) {
					click(By.xpath("//html//div[@class='tab-container']//tr[" + counter + "]//td[2]/a"));
					break;
				} else
					counter++;
			}
			order = true;
		} catch (Exception e) {
			Assert.fail("could not Find Order Id");
		}
		return order;
	}

	/**
	 * This method checks the click specify shiptoaddress radio button
	 * 
	 * @return boolean true if is successfully executed, else false
	 * 
	 * @page:Shipping Options
	 */
	public boolean invalidShipAddress() throws Exception{

		boolean invalidShipAddress = false;
		String addressType = "Invalid Shipping Address";
		shipAddress = getProperty("next_shipping", "shipaddress");
		chooseContinue = getProperty("next_shipping", "choosecontinue");
		try {
			if (getText(shipAddress).contains(addressType)) {
				click(chooseContinue);

				click("radio", "Fedex Ground (Home)");
				click("button", "Next");

			}
			invalidShipAddress = true;
		} catch (Exception e) {
			Assert.fail("Could not invalid address");
		}
		return invalidShipAddress;

	}

	/**
	 * This method Used to remove special character
	 * 
	 * @return boolean true if is successfully executed, else false
	 * 
	 * 
	 */
	public String removeSpecialChar(String name) {

		String removeSpecialChar = "";
		try {
			String rmExclamatory = name.replaceAll("!", "");
			String rmSlash = rmExclamatory.replaceAll("/", "");
			String rmSpace = rmSlash.replaceAll("\\s", "");
			String rmHash = rmSpace.replaceAll("#", "");
			String rmAnd = rmHash.replaceAll("&", "");
			String rmOpenBrackets = rmAnd.replace("(", "");
			String rmUnderScore = rmOpenBrackets.replace("_", "");
			String rmQuotes = rmUnderScore.replace("'", "");
			String rmHyphen = rmQuotes.replace("-", "");
			String rmComma = rmHyphen.replace(",", "");
			String rmCloseBrackets = rmComma.replace(")", "");
			String rmcolon = rmCloseBrackets.replace(":", "");
			String rmplus = rmcolon.replace("+", "");
			String rmdot = rmplus.replace(".", "");
			String rmasterick = rmdot.replace("*", "");
			String rmQuestion = rmasterick.replace("?", "").toLowerCase();
			removeSpecialChar = rmQuestion;

		} catch (Exception e) {
			Assert.fail("Could not Remove Special Cahracter");
		}
		return removeSpecialChar;

	}

	/**
	 * This method used to Delete the existing Branch.
	 * 
	 * @page Page: Order Approval Admin
	 * @return elementPath.
	 */
	public Boolean deleteOffice(By elementPath) {
		boolean deleteoffice = false;
		try {
			lblSearchOffice = getProperty("next_xadmin_order_approval_admin_index", "lblsearchoffice");
			delSearchOffice = getProperty("next_xadmin_order_approval_admin_index", "delsearchoffice");
			if (getText(lblSearchOffice).equalsIgnoreCase("Gfl_test")) {
				click(delSearchOffice);
				handleAlert();
			}
			click(elementPath);
			deleteoffice = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteoffice;
	}

	/**
	 * This method checks whether the checkbox is enabled If it is enabled then it
	 * returns true if it is not enabled then it will enable the checkbox and
	 * returns true
	 * 
	 * @return boolean true if is successfully executed, else false.
	 * @page:Customize your Order
	 */

	public Boolean checkbox(By by, String value) {
		boolean returnValue = false;
		try {
			if (value == "Enabled" || value == "True" || value == "Checked") {
				if (!(driver.findElement(by).isSelected())) {
					driver.findElement(by).click();
					returnValue = true;
				}

				else {
					returnValue = true;
				}
			} else if (value == "Disabled" || value == "False" || value == "unChecked") {

				if ((driver.findElement(by).isSelected())) {
					driver.findElement(by).click();
					returnValue = true;
				}

				else {
					returnValue = true;
				}
			}

		} catch (Exception e) {
			Assert.fail("Could not verify");
			e.printStackTrace();

		}
		return returnValue;
	}

	/**
	 * This message is used to count All Images
	 * 
	 * @page myAccount
	 * 
	 * @return boolean true if is successfully executed, else false.
	 */
	public boolean countImage() {
		boolean countImage = false;
		try {
			deleteImage = getProperty("next_account_headshot", "deleteimage");
			if (driver.findElements(deleteImage).size() != 0) {
				int pro = driver.findElements(deleteImage).size();
				System.out.println(pro);
				count = pro;
				Thread.sleep(1000);
			} else {
				count = 2;
			}
			countImage = true;
		} catch (Exception e) {
			Assert.fail("could not count image ");
		}
		return countImage;
	}

	/**
	 * This message is used to delete All Images
	 * 
	 * @page myAccount
	 * 
	 * @return boolean true if is successfully executed, else false.
	 */
	public boolean manageDeleteImage() {
		boolean manageDeleteImage = false;
		try {
			countImage();
			icnDelete = getProperty("next_account_headshot", "icndelete");
			for (int i = 1; i < count; i++) {
				if (driver.findElements(icnDelete).size() != 0) {
					click(icnDelete);
					handleAlert();
					Thread.sleep(3000);
				}
			}
			manageDeleteImage = true;
		} catch (Exception e) {
			Assert.fail("could not manage delete image ");
		}
		return manageDeleteImage;
	}

	public boolean searchCartId(String elementType, String elementName) throws InterruptedException {

		boolean searchCartId = false;
		try {
			txtcartid = getProperty("next_account_history", "txtcartid");
			btnsearch = getProperty("next_account_history", "btnsearch");

			By path = getPropertyFile(convertPath(elementType, elementName));
			scroll(txtcartid);
			type(txtcartid, Cartid);
			click(btnsearch);
			scroll(path);
			click(path);
			searchCartId = true;
		} catch (Exception e) {
			Assert.fail("Could not search cart id");
		}
		return searchCartId;
	}

	/**
	 * This message is used to delete Pricing Admin
	 * 
	 * @page Product Pricing Grid
	 * 
	 * @return boolean true if is successfully executed, else false.
	 */
	public boolean deletePricingAdmin() {
		boolean deletePricingAdmin = false;
		try {
			pricingAdmin = getProperty("next_xadmin_pricing_admin", "pricingadmin");
			for (int i = 1; i < 5; i++) {
				if (driver.findElements(pricingAdmin).size() != 0) {
					driver.findElement(pricingAdmin).click();
					type("comments", "gfl_test1");
					click("Button", "Save Product");
					Thread.sleep(2000);
					click("icon", "Edit");
				} else {
					break;
				}
				i++;
			}
			deletePricingAdmin = true;
		} catch (Exception e) {
			Assert.fail("could not manage delete image ");
		}
		return deletePricingAdmin;
	}

	/*
	 * this method find the stored order id in pending order list it checks which
	 * pending order contains the order_id if it fetches the order id then it click
	 * Cart Place/Edit link
	 * 
	 * @return boolean true if is successfully executed, else false.
	 */
	public boolean inCart() {
		boolean cart = false;
		try {
			int counter = 2;
			while (counter < 7) {
				if (driver.findElement(By.xpath("//html//div[@class='tab-container']//tr[" + counter + "]//td[4]"))
						.getText().contains(order_id)) {
					click(By.xpath("//html//div[@class='tab-container']//tr[" + counter + "]//td[1]/a"));
					break;
				} else
					counter++;
			}
			cart = true;
		} catch (Exception e) {
			Assert.fail("could not Find Order Id");
		}
		return cart;
	}

	public boolean verifyAndClickDeleteIcon() {

		boolean VerifyAndClickDeleteIcon = false;
		int counter = 2;
		try {
			while (counter < 10) {
				if (getText(By.xpath("//*[@id=\"tab-1\"]/table/tbody/tr[" + counter + "]/td[4]")).contains(orderid)) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,500)");
					click(By.xpath("//*[@id=\"tab-1\"]/table/tbody/tr[" + counter + "]/td[8]/a/img"));
					VerifyAndClickDeleteIcon = true;
					break;
				} else {
					counter++;
				}
			}
		} catch (Exception e) {
			Assert.fail("could not verify and click delete icon ");
		}
		return VerifyAndClickDeleteIcon;
	}

	/*
	 * this method delete credit details if credit card detail exits it deletes else
	 * it give credit card details
	 * 
	 */
	public boolean addMultiCard(By elementPath) {
		boolean card = false;
		try {
			lnkCcRemove = getProperty("next_checkout", "lnkccremove");
			if (isElementDisplayed(lnkCcRemove)) {
				scroll(elementPath);
				click(elementPath);
			} else {
				click("radio", "Do you want to save your credit card", "yes");
				type("cardnumber", "4242424242424242");
				type("cardcvv", "123");
				type("expirationdate", "12/20");
				click("Button", "SaveCard");
				click(elementPath);
			}
			card = true;
		} catch (Exception e) {
			Assert.fail("could not delete card ");
		}
		return card;
	}

	/**
	 * This method is used to select the values from the combo box dropdown
	 * 
	 * @param path
	 * @param textToSelect
	 * @return boolean true if is successfully executed, else false.
	 */

	public boolean comboBoxSelect(By path, String textToSelect) {
		boolean val = false;
		try {
			// List<WebElement> options;
			comboBox = getProperty("next_account_manage_lists", "combobox");

			if (driver.getCurrentUrl().contains("account/agent.php")
					|| (driver.getCurrentUrl().contains("account/branch.php"))) {
				click(path);
				type("comboboxselect", textToSelect);
				Thread.sleep(1000);
				Actions act = new Actions(driver);
				act.sendKeys(Keys.ENTER).build().perform();
				return true;
			}
			WebElement webElement = driver.findElement(path);
			webElement.click();
			Thread.sleep(2000);
			List<WebElement> options = webElement.findElements(comboBox);
			for (int i = 0; i < options.size(); i++) {
				String abc = options.get(i).getText().trim().toLowerCase();
				System.out.println(abc);
				if (abc.contains((textToSelect).toLowerCase())) {
					options.get(i).click();
					break;
				}
			}

			val = true;
		} catch (Exception e) {
			Assert.fail("could not select the combo box value ");
		}
		return val;
	}

	/**
	 * This method used to click Finished button after we upload files.
	 * 
	 * @page Page: Upload_Analyze_CASS Results
	 * @return elementPath
	 */
	public String uploadFinished(By elementPath) {

		try {
			Thread.sleep(70000);
			click(elementPath);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * This method is used to click Proceed to checkout and handles (clicks cancel)
	 * mobile ad popup that occurs in Checkout page.
	 * 
	 * @return boolean true if clicked 'Cancel' in Mobile Ad pop-up successfully,
	 *         else false.
	 * @page page:: Checkout,Order Summary
	 */
	public boolean proceedToCheckout(By path) {

		boolean proceedToCheckout = false;
		try {
			mobilePop = getProperty("next_summary", "mobilepop");
			scroll(path);
			click(path);
			mobilePopUp();
			Thread.sleep(7000);
			proceedToCheckout = true;
		} catch (Exception e) {
			Assert.fail("Could not click proceedToCheckout and select mobile popup");
		}
		return proceedToCheckout;
	}

}
