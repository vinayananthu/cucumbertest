package genericlibrary.xadmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

import genericlibrary.global.GenericAbstract;

public class WrapperMethods extends GenericAbstract {

	// Login
	public By txtSearchLogin;
	public By lnkLogin;
	public By btnSearchLogin;
	public By lnkLogout;

	public By btnPrintCartReceipt;
	public By lnkHome;

	public By lnkMobileAdCancel;
	public By rdoShipOrderToMe;

	// View Larger
	public By icnTopViewLarger;
	public By icnBottomViewLarger;

	// photo_headshot
	public String photo_headshot_name;
	public By lblsearchtemplate;
	public By lnkdirectories;

	// Store Values
	public String storeVal;
	public String FedExType;

	// Popup Boxes
	public By lnkPreview;
	public By lnkViewAsPDfPopUp;
	public By ddlOffice;
	public By lblOrderId;
//	public String mlsid;
//	public String amountdue;
//	public String order_id;

	public static Home homeObject = new Home();

	/**
	 * This method is used to click on a specific element when the element is
	 * identified by elementType and elementName. Eg. Click 'Verify' button || Click
	 * 'Start a New Order' link
	 * 
	 * @param elementType
	 *            -- Type of the element Eg. Button, Link, etc
	 * @param elementName
	 *            -- Name of the element Eg. Verify, Start a New Order
	 * @return boolean true if successfully clicked on the specified element
	 * @throws Exception 
	 */

	public Boolean click(String elementType, String elementName) throws Exception {

		try {
			if (elementName.equalsIgnoreCase("ok")) {
				handleAlert();
				return true;
			} else if (driver.getCurrentUrl().contains("/next/account/history.php")) {
				By path = getPropertyFile(homeObject.removeSpecialChar(convertPath(elementType, elementName)));
				scroll(path);
				click(path);
				return true;
			} else if (elementName.equalsIgnoreCase("browse")) {
				return true;
			} else if (homeObject.removeSpecialChar(elementName).equalsIgnoreCase("confirm the order deletion")) {
				handleAlert();
				handleAlert();
				return true;
			} else if (elementName.contains("close")) {
				homeObject.closeModal();
				return true;
			} else if (elementType.toLowerCase().equalsIgnoreCase("icon")
					&& elementName.toLowerCase().equalsIgnoreCase("delete")
					&& (driver.getCurrentUrl().contains("next/checkout.php"))) {
				homeObject.deleteCreditCard();
				return true;
			} else if (elementName.equalsIgnoreCase("shipordertome")) {
				rdoShipOrderToMe = getProperty("next_distribution", "rdoshipordertome");
				if (isElementPresent(rdoShipOrderToMe)) {
					scroll(rdoShipOrderToMe);
					click(rdoShipOrderToMe);
				}
				return true;
			}
			By path = getPropertyFile(homeObject.removeSpecialChar(convertPath(elementType, elementName)));
			String name = elementName.replaceAll("\\s", "").toLowerCase();
			switch (name) {
			case "startaneworder":
			case "startneworder":
				if (!driver.getCurrentUrl().contains("/next/start.php")) {
					homeObject.startNewOrder(elementType, elementName);
				} else {
					click(path);
				}
				break;
			case "addnew":
				homeObject.deleteOffice(path);
				break;
			case "orderdetail":
			case "orderdetails":
				String getUrl = driver.getCurrentUrl();
				if (getUrl.contains("next/account/history.php")) {
					homeObject.searchOrderId(elementType, elementName);
				} else {
					scroll(path);
					click(path);
				}
				break;
			case "clickheretochargeamountduetomultiplecards":
				homeObject.addMultiCard(path);
				break;
			case "viewcartreceipt":
				homeObject.searchCartId(elementType, elementName);
			case "fedexinternationaleconomy":
			case "fedexinternationalpriority":
			case "fedexground":
			case "fedexstandardovernight":
			case "fedexpriorityovernight":
				scroll(path);
				click(path);
				FedExType = elementName;
				break;
			case "senddirectemail":
			case "city":
			case "zip":
				click(path);
				break;
			case "delete":
				if (driver.getCurrentUrl().contains("next/account/headshot.php")) {
					homeObject.manageDeleteImage();
				} else {
					if (isElementPresent(path)) {
						scroll(path);
						click(path);
					}
				}
				break;
			case "donotshowmethisagain":
			case "addnewaddress":
				if (isElementDisplayed(path)) {
					scroll(path);
					click(path);
				}
				break;

			case "mobileadpopup":
				homeObject.mobilePopUp();
				break;

			case "addcard":
				homeObject.addCard(path);
				break;
			case "searchfortemplates":
				click(path);
				lblsearchtemplate = getProperty("next_xadmin_templates_search", "lblsearchtemplate");
				switchToNewWindow("Template Management", lblsearchtemplate, "Search Template");
				break;
			case "Directories":
				lnkdirectories = getProperty("next_categories", "lnkdirectories");
				click(path);
				break;
			case "approve":
				scroll(path);
				click(path);
				handleAlert();
				Thread.sleep(3000);
				break;
			case "deleteorder":
				handleAlert();
				handleAlert();
				break;
			case "cancelorder":
				click(path);
				handleAlert();
				handleAlert();
				break;
			case "completecheckout":
			case "editbilling":
			case "editoptions":
			case "editcontent":
			case "editdelivery":
			case "continue":
				homeObject.completecheckout(path);
				break;
			case "proceedtocheckout":
				homeObject.proceedToCheckout(path);
				break;

			case "selectuser":
				click(path);
				type("User", "Agent");
				Actions act = new Actions(driver);
				Thread.sleep(1000);
				act.sendKeys(Keys.ENTER).build().perform();
				break;
			case "finished":
				homeObject.uploadFinished(path);
				break;
			case "usecreditcard":
			case "usecreditcard1":
			case "usecreditcard2":
				if (!driver.findElement(path).isSelected()) {
					click(path);
				}
				return true;
			default:
				scroll(path);
				click(path);
			}
			return true;
		} catch (Exception e) {
//			Assert.fail("could not type" + elementName);
//			e.printStackTrace();
			throw e;
		}
//		return false;
	}

	/**
	 * This method is used to click on a specific element when the element is
	 * identified by adjacent element / text. Eg. Click 'Postcards' link under
	 * 'Property Marketing' category || Click thumbnail under "{template_id}"
	 * template
	 * 
	 * @param identifierType
	 *            -- Type of the identifier Eg. category, template, etc.
	 * @param identifierDetail
	 *            -- Details of the identifier Eg. Property Marketing, template_id,
	 *            etc
	 * @param elementDetail
	 *            -- Details of the element to be acted on Eg. Postcards, thumbnail,
	 *            etc
	 * @return boolean true if successfully clicked on the specified element
	 * @throws Exception 
	 */

	public Boolean click(String identifierType, String identifierDetail, String elementDetail) throws Exception {
		try {
			if (elementDetail.toLowerCase().equalsIgnoreCase("popup")) {
				if(driver.getCurrentUrl().contains("/next/account/listing")) {
					By txtPath = getPropertyFile(
							homeObject.removeSpecialChar(convertPath(identifierType, identifierDetail.concat(elementDetail))));
					click(txtPath);
					return true;
				}else if (driver.getCurrentUrl().contains("/next/account/history.php")) {
					By path = getPropertyFile(
							homeObject.removeSpecialChar(convertPath(identifierType, identifierDetail)));
					click(path);
					return true;
				}
			}
			if (identifierDetail.equalsIgnoreCase("view larger")) {
				if (elementDetail.equalsIgnoreCase("top")) {
					icnTopViewLarger = getProperty("next_proof", "icntopviewlarger");
					click(icnTopViewLarger);
					return true;
				} else {
					icnBottomViewLarger = getProperty("next_proof", "icnbottomviewlarger");
					Thread.sleep(3000);
					click(icnBottomViewLarger);
					return true;
				}
			} else if (identifierDetail.toLowerCase().equalsIgnoreCase("place/edit")
					|| identifierDetail.toLowerCase().equalsIgnoreCase("incart")) {
				if (identifierDetail.contains("incart")) {
					homeObject.inCart(elementDetail);
				} else {
					homeObject.findOrderId(elementDetail);
				}
				return true;
			}
			By elementPath;
			if ((identifierDetail.equalsIgnoreCase("delete")) || (identifierDetail.equalsIgnoreCase("make default"))
					|| (identifierDetail.equalsIgnoreCase("remove default"))) {
				By categoryPath = getPropertyFile(convertPath(identifierType, identifierDetail));
				String path1 = categoryPath.toString().replace("$1$", elementDetail);
				String value = path1.replace("By.xpath:", "");
				elementPath = By.xpath(value);
				driver.findElement(elementPath).click();
				return true;

			}
			switch (identifierType.toLowerCase()) {
			case "checkbox":
			case "icon":
				if (driver.getCurrentUrl().contains("/next/account/history.php")
						|| driver.getCurrentUrl().contains("/next/start.php")) {
					By elementPaths = getPropertyFile(convertPath(identifierType, identifierDetail));
					String path = elementPaths.toString().replace("$1$", elementDetail);
					String val = path.replace("By.xpath:", "");
					elementPath = By.xpath(val);
					driver.findElement(elementPath).click();
				} else {
					String rmveSpace = identifierDetail.replaceAll("\\s", "");
					String rmvQuestionMark = rmveSpace.replace("?", "");
					String name = rmvQuestionMark.concat(elementDetail).toLowerCase();
					click(identifierType, name);
				}
				return true;

			case "radio":
				String rmSpace = identifierDetail.replaceAll("\\s", "");
				String rmQuestionMark = rmSpace.replace("?", "");
				String elementName = rmQuestionMark.concat(elementDetail).toLowerCase();
				click(identifierType, elementName);
				return true;
			case "template":
				elementPath = homeObject.getTemplatePath(identifierDetail, elementDetail);
				break;
			case "category":
				By elementPaths = getProperty("next_index", "lnkcategory");
				String path = elementPaths.toString().replace("$1$", identifierDetail);
				path = path.replace("$2$", elementDetail);
				String val = path.replace("By.xpath:", "");
				elementPath = By.xpath(val);
				break;
			case "button":
				if (driver.getCurrentUrl().contains("/next/account/history.php")) {
					By identifierPaths = getPropertyFile(convertPath(identifierType, identifierDetail));
					String identifierPath = identifierPaths.toString().replace("$1$", elementDetail);
					String value = identifierPath.replace("By.xpath:", "");
					elementPath = By.xpath(value);
					driver.findElement(elementPath).click();

				} else if (homeObject.removeSpecialChar(identifierDetail).equalsIgnoreCase("mobileadpopup")) {
					if (elementDetail.toLowerCase().equalsIgnoreCase("cancel")) {
						homeObject.mobilePopUp();
					}
					return true;
				} else if (elementDetail.toLowerCase().equalsIgnoreCase("edit")) {
					String getUrl = driver.getCurrentUrl();
					if (getUrl.contains("next/build.php")) {
						elementPath = (By.xpath(
								"//legend[contains(text(),'" + identifierDetail + "')]//..//..//input[@value='Edit']"));
					} else {
						elementPath = (By.xpath(
								"//p[contains(text(),'" + identifierDetail + "')]//..//..//input[@value='Edit']"));

					}
					break;
				}
				return true;
			default:
				throw new RuntimeException("Unknown Root Element Type :: " + identifierType);
			}
			scroll(elementPath);
			click(elementPath);
			return true;
		} catch (Exception e) {
//			Assert.fail("could not type" + elementDetail);
//			e.printStackTrace();
			throw e;
		}
//		return false;
	}

	/**
	 * This method is used to type value in textbox or searchable dropdown Eg. Type
	 * "123123123" into 'MLS ID' field || Type "60010" in 'Zip' field
	 * 
	 * @param elementType
	 *            -- Type of the element Eg. textbox
	 * @param elementName
	 *            -- Name of the element Eg. MLS ID, Zip
	 * @param textToType
	 *            -- Value to type in the textbox Eg. 123123123, 60010
	 * @return boolean true if successfully typed into the field
	 * @throws Exception 
	 */

	public Boolean type(String elementName, String textToType) throws Exception {

		try {

			String val = elementName.replaceAll("#", "");

			String name = elementName.replaceAll("\\s", "").toLowerCase();
			switch (name) {
			case "creditcardnumber":
			case "creditcard":
			case "cardnumber":
			case "cvv":
			case "expiration":
			case "cardcvv":
			case "expirationdate":
			case "cardnumber:":
			case "cardcvv:":
			case "expirationdate:":
				homeObject.creditCard(elementName, textToType);
				break;
			case "nameyourphoto":
				By path = getPropertyFile(homeObject.removeSpecialChar(convertPath("textbox", val)));
				scroll(path);
				click(path);
				type(path, textToType);
				photo_headshot_name = textToType;
			case "searchfield":
				By element = getPropertyFile(homeObject.removeSpecialChar(convertPath("textbox", val)));
				click(element);
				type(element, textToType);
				break;
			case "cardnumber2":
			case "cardcvv2":
			case "expirationdate2":
				Actions act = new Actions(GenericAbstract.driver);
				act.sendKeys(Keys.TAB).sendKeys(Keys.BACK_SPACE);
				Thread.sleep(1000);
				act.sendKeys(textToType).build().perform();
				break;
			default:
				By elements = getPropertyFile(homeObject.removeSpecialChar(convertPath("textbox", val)));
				scroll(elements);
				click(elements);
				type(elements, textToType);
				break;
			}

			return true;
		} catch (Exception e) {
//			Assert.fail("could not type" + textToType);
//			e.printStackTrace();
			throw e;
		}
//		return false;
	}

	/**
	 * This method is used to select/check a value Eg. Select checkbox next to
	 * uploaded list || Select the 'FedEx Ground' radio
	 * 
	 * @param elementType
	 *            -- Type of the element Eg. checkbox, radio, etc.
	 * @param elementName
	 *            -- Name of the element Eg. uploaded list, FedEx Ground, etc.
	 * @return boolean true if successfully selected
	 * @throws Exception 
	 *
	 */

	public Boolean select(String elementType, String elementName) throws Exception {
		try {
			By path = getPropertyFile(homeObject.removeSpecialChar(convertPath(elementType, elementName)));

			if (elementType.equalsIgnoreCase("link") || elementType.equalsIgnoreCase("button")) {
				scroll(path);
				click(path);
				return true;

			}

			if (elementType.equalsIgnoreCase("checkbox")) {
				scroll(path);
				if (!driver.findElement(path).isSelected()) {
					click(path);
				}
				return true;

			}
			String name = elementName.replaceAll("\\s", "").toLowerCase();
			switch (name) {
			case "fedexground":
				if (isElementPresent(path)) {
					scroll(path);
					click(path);

				}
				break;
			default:
				scroll(path);
				click(path);
			}
			return true;

		} catch (Exception e) {
//			Assert.fail("could not select" + elementName);
//			e.printStackTrace();
			throw e;
		}
		
	}

	/**
	 * This method is used to Select value from dropdown Eg. Select 'ERA' in
	 * SelectCompany dropdown || select 'Pay by Credit or Debit Card' option in
	 * 'Billing' drop down list
	 * 
	 * @param elementType
	 *            -- Type of the element Eg. dropdown, etc
	 * @param elementName
	 *            -- Name of the element Eg. SelectCompany, Billing, etc
	 * @param textToSelect
	 *            -- Value to select Eg. ERA, Pay by Credit or Debit Card, etc.
	 * @return boolean true if the value is successfully selected
	 * @throws Exception 
	 */

	public Boolean select(String elementType, String elementName, String textToSelect) throws Exception {
		try {
			String rmexclamatory = elementName.replaceAll("!", "");
			String rmslash = rmexclamatory.replaceAll("/", "");
			String name = rmslash.replaceAll("\\s", "").toLowerCase();
			By path = getPropertyFile(homeObject.removeSpecialChar(convertPath(elementType, name)));

			if (driver.findElements(path).size() != 0) {
				scroll(path);
				click(path);
				if (elementName.contains("billing")) {
					if (isElementPresent(path)) {
						WebElement pro = driver.findElement(path);
						List<WebElement> options = pro.findElements(By.tagName("option"));
						scroll(path);
						click(path);
						for (int i = 0; i < options.size(); i++) {
							String val = options.get(i).getText().trim();
							if (val.equalsIgnoreCase(textToSelect.trim())) {
								options.get(i).click();
								break;
							}
						}
					}
					return true;
				}
				WebElement pro = driver.findElement(path);
				List<WebElement> options = pro.findElements(By.tagName("option"));
				scroll(path);
				click(path);
				switch (name) {

				case "selectoffices":
					click(path);
					click("textbox", "officessearch");
					type("officessearch", textToSelect);
					click("checkbox", "officesfilter");
					break;
				case "selectagents":
					click(path);
					click("textbox", "userssearch");
					type("userssearch", textToSelect);
					click("checkbox", "usersfilter");
					break;
				case "filter2":
					click(path);
					click("textbox", "filtersearch");
					type("filtersearch", textToSelect);
					click("checkbox", "Filter 2");
					break;
				case "selectoffice":
				case "office":
				case "user":
				case "searchagent":
				case "searchuser":
				case "selectuser":
				case "searchbyoffice":
				case "chooseuser":
					if (driver.getCurrentUrl().contains("account/manage_lists.php")
							|| driver.getCurrentUrl().contains("next/account/agent.php")
							|| driver.getCurrentUrl().contains("/next/account/branch.php")) {
						homeObject.comboBoxSelect(path, textToSelect);
					} else {
						for (int i = 0; i < options.size(); i++) {
							String val = options.get(i).getText().trim();
							if (val.contains(textToSelect.trim())) {
								options.get(i).click();
								break;
							}
						}
					}
					break;
				case "selectcompany":
				case "company":
				case "frequency":
					for (int i = 0; i < options.size(); i++) {
						String val = options.get(i).getText().trim();
						if (val.equalsIgnoreCase(textToSelect.trim())) {
							options.get(i).click();
							break;
						}
					}
					break;
				case "billing":
				case "selectbilling":
					if (isElementPresent(path)) {
						for (int i = 0; i < options.size(); i++) {
							String val = options.get(i).getText().trim();
							if (val.equalsIgnoreCase(textToSelect.trim())) {
								options.get(i).click();
								break;
							}
						}
					}
					break;

				default:
					for (int i = 0; i < options.size(); i++) {
						String val = options.get(i).getText().trim();
						if (val.equalsIgnoreCase(textToSelect.trim())) {
							options.get(i).click();
							break;
						} else if (val.contains(textToSelect.trim())) {
							options.get(i).click();
							break;
						}
					}

				}
			}
			return true;
		} catch (Exception e) {
			throw e;
		}
//		return false;
	}

	/**
	 * This method is used to verify the expected result Eg. next/index.php page
	 * should open || Observe pop-up heading is "{template_name}"
	 * 
	 * @param resultType
	 *            -- Type of the expected result Eg. url, heading, etc.
	 * @param resultValue
	 *            -- Value of the expected result Eg. next/index.php ,
	 *            template_name, etc.
	 * @return boolean true if verified successfully
	 * @throws Exception 
	 */
	public Boolean verifyExpectedResult(String resultType, String resultValue) throws Exception {
		Boolean returnValue = false;
		try {
			switch (resultType.toLowerCase()) {
			case "url":
				// get current url and verify
				Thread.sleep(1000);
				String url = driver.getCurrentUrl();
				if (url.contains(resultValue.trim())) {
					return true;
				} else {
					returnValue = false;
				}
				break;
			case "heading":
				driver.findElement(getPropertyFile(homeObject.removeSpecialChar(convertPath("label", resultType))))
						.getText().contains(resultValue);
				break;
			case "header":
				// get current page title
				Assert.assertEquals(driver.getTitle().toLowerCase(), resultValue.toLowerCase());
				break;
			case "status":
				By path = getPropertyFile(homeObject.removeSpecialChar(convertPath("label", resultType)));
				if (resultValue.equalsIgnoreCase("CANCELLED")) {
					Assert.assertEquals(getText(path), resultValue);
				}
				break;
			case "creditcard":
				homeObject.verifyCreditCard();
				break;
			case "ordername":
				if (driver.getCurrentUrl().contains("/next/start.php")) {
					By path1 = getPropertyFile(homeObject.removeSpecialChar(convertPath("label", resultType)));
					if (resultValue.equalsIgnoreCase("Test1")) {
						Assert.assertEquals(getText(path1), resultValue);
					}
				}
				break;

			case "alert":
				WebDriverWait wait = new WebDriverWait(driver, 100);
				if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
					System.out.println("alert was present");
					return true;
				} else {
					System.out.println("alert was not present");
					return false;
				}
			default:
				throw new RuntimeException("Unknown URL :: " + resultType);
			}
		} catch (Exception e) {
		throw e;
		}
		return returnValue;
	}

	/**
	 * This method is used to verify the element is Present,available, open or not.
	 * Eg. 'Search' button is present || template preview pop-up should open
	 * 
	 * @param resultType
	 *            -- Type of the expected result Eg. button, pop-up, etc.
	 * @param resultValue
	 *            -- Value of the expected result Eg. Search , template preview,
	 *            etc.
	 * @param resultState
	 *            -- State expected Eg. present, open, etc.
	 * @return boolean true if verified successfully
	 * @throws Exception 
	 */
	public Boolean verifyExpectedResult(String elementType, String elementName, String elementState) throws Exception {
		boolean returnvalue = false;
		try {

			By elementPath = null;
			String alertText = null;
			if (elementType.equalsIgnoreCase("text") || elementType.equalsIgnoreCase("option")
					|| elementType.equalsIgnoreCase("alert") || elementType.equalsIgnoreCase("link")
					|| elementType.equalsIgnoreCase("form") || elementType.contains("Order")
					|| elementType.contains("photo") || elementType.equalsIgnoreCase("popup")
					||elementType.equalsIgnoreCase("link")
					|| elementType.equalsIgnoreCase("row")
					|| elementType.contains("field")) {
				if (elementName.contains(".")) {
					elementName = elementName.substring(0, elementName.indexOf("."));
					if (elementName.contains("!")) {
						if (!elementName.trim().endsWith("!")) {
							elementName = elementName.split("!")[1].trim();
						}
					}
				} else {
					if (elementName.contains("Alert")) {
						elementName = elementName.replace("Alert", "").trim();
					}

				}
				elementPath = By.xpath("//*[contains(text(),\"" + elementName + "\")]");
			} if (elementType.equalsIgnoreCase("message")||elementType.equalsIgnoreCase("confirmation")) {
				driver.switchTo().alert();
				alertText = driver.switchTo().alert().getText();
			} else {
			    if (elementName.equalsIgnoreCase("Cart ID:")) {
					elementPath = By.xpath("//*[contains(text(),\"" + elementName + "\")]");
				} else {
					elementPath = getPropertyFile(homeObject.removeSpecialChar(convertPath(elementType, elementName)));
				}
			}if(elementName.contains("results for")) {
				elementPath = By.xpath("//*[contains(text(),\'" + elementName + "\')]");
			} 
			switch (elementState.toLowerCase()) {
			case "visible":
			case "present":
			case "displayed":
			case "open":
			case "available":
			case "tablevalue":
			case "appears":
				if (elementType.equalsIgnoreCase("message")||elementType.equalsIgnoreCase("confirmation")) {
					Assert.assertEquals(elementName.toLowerCase(), alertText.toLowerCase());
					return true;
				} else if (isElementPresent(elementPath)) {
					Thread.sleep(1000);
					return true;	
					
				} else if(elementName.contains("current_date")) {
					elementPath = getPropertyFile(homeObject.removeSpecialChar(convertPath(elementType, elementName)));
					String getTextValue = getText(elementPath);
					storeVal = getTextValue;
				}else {
					return false;
				}
			case "close":
			case "not available":
			case "not visible":
				return !(isElementPresent(elementPath));
			case "enabled":
			case "active":
			case "set":
			case "clicked":
				if (driver.findElement(elementPath).isEnabled()) {
					return true;
				} else {
					return false;
				}
			case "inactive":
				if (!driver.findElement(elementPath).isEnabled()) {
					return true;
				} else {
					return false;
				}
			case "unavailable":
				if (!isElementPresent(elementPath)) {
					return true;
				}
				break;
			case "selected":
				if (driver.findElement(elementPath).isSelected()) {
					return true;
				} else {
					return false;
				}
			default:
				throw new RuntimeException("Unknown URL :: " + elementType);
			}

		} catch (Exception e) {
			throw e;
		}
		return returnvalue;
	}

	/**
	 * This method is used to verify the entered Field value is correct or not.
	 * 
	 * @param resultType
	 * @param resultValue
	 * @param resultState
	 * @param text
	 * @return boolean true if verified successfully
	 * @throws Exception 
	 */
	public Boolean verifyExpectedResult(String resultType, String resultValue, String resultState, String text) throws Exception {
		Boolean returnValue = false;
		try {
			if (resultState.contains("present")) {
				By elementPath;
				By categoryPath = getPropertyFile(homeObject.removeSpecialChar(convertPath(resultType, resultValue)));
				String path1 = categoryPath.toString().replace("$1$", text);
				String values = path1.replace("By.xpath:", "");
				elementPath = By.xpath(values);
				if (isElementPresent(elementPath))
					return isElementPresent(elementPath);
				return true;
			} else if (resultState.toLowerCase().contains("equals")
					|| resultState.toLowerCase().contains("greater than")) {
				if (driver.getCurrentUrl().contains("next/mylisting_results.php")) {
					String result = resultValue.split("results")[0].trim();
					String result2 = text.split("results")[0].trim();
					int sourceQty = Integer.parseInt(result);
					int targetQty = Integer.parseInt(result2);
					if (sourceQty >= targetQty || sourceQty <= targetQty || sourceQty > targetQty) {
						return true;
					}
				}
			}
			switch (resultState.toLowerCase()) {
			case "equals":
			case "visible":
			case "under":
			case "enabled":
			case "displayed":
				By txtPath;
				if (resultType.contains("radio")) {
					txtPath = getPropertyFile(
							homeObject.removeSpecialChar(convertPath(resultType, resultValue.concat(text))));
				} else {
					txtPath = getPropertyFile(homeObject.removeSpecialChar(convertPath(resultType, resultValue)));
				}
				if (driver.getCurrentUrl().contains("address_upload/view")
						|| driver.getCurrentUrl().contains("xadmin/orders/index.php")) {
					String path1 = txtPath.toString().replace("$1$", text);
					String values = path1.replace("By.xpath:", "");
					txtPath = By.xpath(values);
				}
				if (resultType.equalsIgnoreCase("field") || resultType.equalsIgnoreCase("textbox")) {
					Assert.assertEquals(text.toLowerCase().trim(), getAttribute(txtPath).toLowerCase().trim());
				} else if (text.equalsIgnoreCase("selected")||resultState.equalsIgnoreCase("enabled")) {
					if (driver.findElement(txtPath).isSelected()) {
						return true;
					}
				} else {
					Assert.assertEquals(text.toLowerCase().trim().replace("$", ""),
							getText(txtPath).toLowerCase().replace("$", "").trim());
				}
				return true;
			case "field":
			case "set":
			case "specification":
			case "selected":
				By path;
				if (resultType.contains("radio")) {
					path = getPropertyFile(
							homeObject.removeSpecialChar(convertPath(resultType, resultValue.concat(text))));
					if (driver.findElement(path).isSelected()) {
						return true;
					}
				}
			   path = getPropertyFile(homeObject.removeSpecialChar(convertPath(resultType, resultValue)));

				if (resultType.toLowerCase().equalsIgnoreCase("dropdown")) {
					Select select = new Select(driver.findElement(path));
					WebElement option = select.getFirstSelectedOption();
					String defaultItem = option.getText();
					text.contains(defaultItem);
					return true;
				}
				if (driver.getCurrentUrl().contains("next/account/agent.php")) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,500)");
				}
				Assert.assertEquals(text.toLowerCase().trim(), getAttribute(path).toLowerCase().trim());
				return true;
			case "value":
			case "text":
				By path1 = getPropertyFile(homeObject.removeSpecialChar(convertPath(resultType, resultValue)));
				Assert.assertEquals(text.toLowerCase().trim(), getText(path1).toLowerCase().trim());
				return true;
			case "price":
				By path2 = getPropertyFile(homeObject.removeSpecialChar(convertPath(resultType, resultValue)));
				if (driver.getCurrentUrl().contains("mylisting_results.php")) {
					String listingPrice = getText(path2).replace("$", "");
					String Price = listingPrice.replace(",", "");
					Assert.assertEquals(text.toLowerCase().trim(), Price);

				} else if (driver.getCurrentUrl().contains("build.php")) {
					String listingPrice = getAttribute(path2).replace("$", "");
					String Price = listingPrice.replace(",", "");
					Assert.assertEquals(text.toLowerCase().trim(), Price);
				} else {

					String price = getText(path2).replaceAll("$", "");
					String Price = price.replace(",", "");
					Price = Price.substring(1, 5);
					Assert.assertEquals(text.toLowerCase().trim(), Price);
				}
				return true;

			default:
				throw new RuntimeException("Unknown URL :: " + resultType);
			}
		} catch (Exception e) {
			throw e;
		}
//		return returnValue;
	}

	/**
	 * This method used to login into xpressdocs home page & login as impersonate
	 * user.
	 * 
	 * @param userType
	 *            -- type of the user to impersonate company / office / agent
	 * @param id
	 *            -- user id to impersonate
	 * @return boolean true if successfully impersonated
	 * @throws Exception 
	 */
	public Boolean impersonateUser(String userType, String id) throws Exception {
		Boolean autologin = false;
		try {
			txtSearchLogin = getProperty("next_index", "txtsearchlogin");
			lnkLogin = getProperty("next_index", "lnklogin");
			btnSearchLogin = getProperty("next_index", "btnsearchlogin");
			lnkLogout = getProperty("next_index", "lnklogout");

			loginToXadmin();
			By logintype = loginType(userType);
			click(logintype);
			type(txtSearchLogin, id);
			click(btnSearchLogin);
			click(lnkLogin);
			homeObject.closeModal();
			homeObject.emptyCart();
			Assert.assertEquals("Logout", getText(lnkLogout));
			autologin = true;

		} catch (Exception e) {
			throw e;
		}
		return autologin;
	}

	/**
	 * This method used to navigate to specified url.
	 * 
	 * @param url
	 *            -- url to navigate
	 * @return boolean true if navigated successfully
	 * @throws Exception 
	 */

	public Boolean navigateTo(String url) throws Exception {
		boolean navigateToXadmin = false;
		try {
			String name = url.replaceAll("\\s", "").toLowerCase();
			switch (name) {
			case "xadmin":
			case "xadmin_home_page":
			case "xadminhomepage":
				loginToXadmin();
				break;
			case "back":
				if (driver.getCurrentUrl().contains("/pending_transaction.php")
						|| driver.getCurrentUrl().contains("/categories.php")
						|| driver.getCurrentUrl().contains("/build.php")) {
					driver.navigate().back();
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,-200)");
					return true;
				} else {
					driver.navigate().back();
				}
				break;
			case "forward":
				driver.navigate().forward();
				break;
			default:
				loginToXadmin();
				driver.navigate().to(url);
			}

			navigateToXadmin = true;
		} catch (Exception e) {
			throw e;
		}
		return navigateToXadmin;
	}

	/**
	 * This method is used to Browse the file for upload
	 * 
	 * @param elementName
	 *            -- Element name for which file is uploaded
	 * @param fileName
	 *            -- File name that needs to be uploaded
	 * @return boolean true if successfully browsed the file
	 * @throws Exception 
	 *
	 */

	public Boolean browse(String elementName, String fileName) throws Exception {

		try {

			String getUrl = driver.getCurrentUrl();
			String[] arrOfUrl = getUrl.split("/", 4);
			String currentUrl = arrOfUrl[3];
			if (currentUrl.contains("next/build.php")) {

				homeObject.uploadFiles(elementName, fileName);
				return true;
			}
			By path = getPropertyFile(homeObject.removeSpecialChar(convertPath("Button", elementName)));
			if (currentUrl.contains("next/account/headshot.php")) {
				WebElement uploadElement = driver.findElement(path);
				// enter the file path onto the file-selection input field
				uploadElement.sendKeys(readProperty("browseImage") + fileName + "");
				return true;
			}
			WebElement uploadElement = driver.findElement(path);
			// enter the file path onto the file-selection input field
			uploadElement.sendKeys(readProperty("browseUpload") + fileName + "");
			return true;
		} catch (Exception e) {
			throw e;
		}
//		return false;
	}

	/**
	 * This method is used to mouseOver the element
	 * 
	 * @param elementType
	 *            -- Type of the element
	 * @param elementName
	 *            -- Name of the element
	 * @return boolean true if successfully mouse over the element
	 */
	public Boolean mouseOver(String categorytype, String categoryname) {
		boolean returnValue = false;
		try {
			By path = getPropertyFile(homeObject.removeSpecialChar(convertPath(categorytype, categoryname)));
			homeObject.mouseOverClick(path);
			returnValue = true;
		} catch (Exception e) {
		}
		return returnValue;
	}

	/**
	 * This method used to store the value in the textbox.
	 * 
	 * @param identifierType
	 *            -- Type of the element
	 * @param elementName
	 *            -- Name of the element
	 * @throws Exception 
	 */

	public String store(String identifierType, String identifierName) throws Exception {

		String storeVal = null;
		try {
			if (identifierName.contains("URL")) {
				String Url = driver.getCurrentUrl();
				return Url;
			}
			By path = getPropertyFile(homeObject.removeSpecialChar(convertPath(identifierType, identifierName)));
			String name = identifierName.replaceAll("\\s", "").toLowerCase().trim();
			switch (name.toLowerCase()) {
			case "orderid":
			case "order_id":
			case "orderid:":
			case "order_id2":
			case "createddate":
			case "modifieddate":
			case "created":
			case "modified":
			case "amount":
			case "qty":
			case "templatename":
			case "ordername":
				Thread.sleep(1000);
				String getTextValue = getText(path);
				storeVal = getTextValue;
				break;
			case "mlsid":
			case "agentname":
			case "companyname":
			case "companyname2":
			case "address":
			case "address2":
			case "email":
			case "website":
			case "nameyourphoto":
			case "styleid":
			case "basekeywords":
			case "approvalname":
			case "email1":
			case "website1":
			case "phone1":
			case "phone2":
			case "phone3":
			case "title2":
			case "namethisorder":
			case "phonenumberagent1":
			case "namelicensedasagent1":
			case "emailaddressagent1":
			case "phonenumberagent2":
			case "namelicensedasagent2":
			case "emailaddressagent2":
			case "nameyourlist":
			case "line5":
			case "line6":
			case "line7":
			case "line8":
			case "nameyourlist:":
			case "phone":
			case "zip":
			case "address1":
			case "city":
			case "name":
			case "company":
				String val = getAttribute(path);
				if (name.equalsIgnoreCase("basekeywords")) {
					String getVal = val.split(",")[0];
					storeVal = getVal;
				}
				storeVal = val;

				break;
			case "officeaddress":
				String getValue = getText(path);
				String OfficeAddress = getValue.replaceAll("\n", ",");
				storeVal = OfficeAddress;
				break;
			case "amountdueforthisorder":
			case "amountdue":
			case "amountdue:":
			case "total":
				String AmountDue = getText(path);
				String amount = AmountDue.replaceAll("[\\$,]", "");
				double value = Double.valueOf(amount);
				String amountdue = String.valueOf(value);
				storeVal = amountdue;
				break;
			case "addressesselected":
			case "addressesselected:":
				String Addresses_selected = getText(path);
				storeVal = Addresses_selected;
				break;
			case "pdfprice":
				String pdf_price = getText(path);
				storeVal = pdf_price;
				break;
			case "cartid":
				String cart_Id = getText(path);
				String Cartid = cart_Id.substring(9, 17);
				storeVal = Cartid;
				break;
				
			case "state":
		    case "country":
				Select select = new Select(driver.findElement(path));
				WebElement option = select.getFirstSelectedOption();
				String defaultItem = option.getText();
				storeVal = defaultItem;
				break;

			case "selectanoffice":
			case "selectauser":
				Select drpbranch = new Select(driver.findElement(path));
				List<WebElement> elementCount = drpbranch.getOptions();
				int iSize = elementCount.size();

				for (int i = 0; i < iSize; i++) {
					String sValue = elementCount.get(i).getText();
					if (sValue.equalsIgnoreCase("Demo Branch (30200DEMOB)")
							| sValue.equalsIgnoreCase("Smith, Jane (438179APRI)")) {
						System.out.println(sValue);
						String splitdrp = sValue.split("\\(")[0].trim();
						splitdrp = splitdrp.split("\\,")[0].trim();
						System.out.println(splitdrp);
						return splitdrp;

					}
				}
				break;
			default:
				throw new RuntimeException("Unknown Root elementName :: " + identifierName);
			}
		} catch (Exception e) {
			throw e;
		}
		return storeVal;

	}

	/**
	 * This method used to store the value in the textbox.
	 * 
	 * @param identifierType
	 *            -- Type of the element
	 * @param identifierDetail
	 *            -- Detail of the element
	 * @param identifierName
	 *            -- Name of the element
	 * @throws Exception 
	 */

	public String store(String identifierType, String identifierDetail, String identifierName) throws Exception {

		String storeVal = null;
		try {
			String elementName = identifierDetail.concat(identifierName).toLowerCase();
			By path = getPropertyFile(homeObject.removeSpecialChar(convertPath(identifierType, elementName)));
			String name = identifierName.replaceAll(" ", "").toLowerCase();
			switch (name.toLowerCase()) {
			case "fedextype":
				storeVal = FedExType;
				break;
			case "estimatedarrival":
			case "price":
				storeVal = homeObject.storeShippingServiceDetail(path, identifierName);
				break;
			default:
				throw new RuntimeException("Unknown Root elementName :: " + identifierName);
			}
		} catch (Exception e) {
			throw e;
		}
		return storeVal;

	}

	/**
	 * @param elementType
	 *            -- Type of the element
	 * @param elementName
	 *            -- Name of the element This method checks whether the checkbox is
	 *            enabled If it is enabled then it returns true if it is not enabled
	 *            then it will enable the checkbox and returns true
	 * 
	 * @return boolean true if is successfully executed, else false
	 * 
	 * @page:Customize your Order
	 */

	public Boolean set(String elementType, String elementName, String value) {
		boolean returnValue = false;
		try {

			switch (elementType.toLowerCase()) {
			case "radio":
				String eName;
				if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
					eName = elementName;
				} else {
					eName = elementName.concat(value);
				}
				click(elementType, homeObject.removeSpecialChar(eName));
				break;
			default:
				String val = convertPath(elementType, elementName);
				By path = getPropertyFile(val);
				homeObject.checkbox(path, value);
				break;
			}
			returnValue = true;
		} catch (Exception e) {
		}
		return returnValue;
	}

	/**
	 * This method is used to close
	 * 
	 * @param name
	 * @return boolean true if is successfully executed, else false
	 * @throws Exception 
	 */

	public Boolean close(String name) throws Exception {
		boolean returnValue = false;
		try {
			String getUrl = driver.getCurrentUrl();
			switch (name.toLowerCase()) {
			case "window":
				if (getUrl.contains("next/checkout_complete.php")) {
					btnPrintCartReceipt = getProperty("next_checkout_complete", "btnprintcartreceipt");
					lnkHome = getProperty("next_checkout_complete", "lnkhome");
					homeObject.switchToNewWindow("Checkout Complete", btnPrintCartReceipt, "Print Cart Receipt");
					driver.close();
					homeObject.switchToNewWindow("Checkout Complete", lnkHome, "Home");
					break;
				}
				driver.close();
				break;
			case "/next/preview.php":
				if (getUrl.contains("next/build.php")) {
					lnkPreview = getProperty("next_build", "lnkpreview");
					ddlOffice = getProperty("next_build", "ddloffice");
					homeObject.switchToNewWindow("Customize Your Order", lnkPreview, "Preview Page");
					driver.close();
					homeObject.switchToNewWindow("PreviewPage", ddlOffice, "Customize Your Order");
				}
				break;
			case "view as pdf":
				lnkViewAsPDfPopUp = getProperty("next_proof", "lnkviewaspdfpopup");// lblorderid
				lblOrderId = getProperty("next_proof", "lblorderid");
				homeObject.switchToNewWindow("Proofing Summary", lnkViewAsPDfPopUp, "PopUp Window");
				driver.close();
				homeObject.switchToNewWindow("PopupPage", lblOrderId, "proofing page");

				break;

			default:
				throw new RuntimeException("could not close :: " + name);
			}
			returnValue = true;
		} catch (Exception e) {
			throw e;
		}
		return returnValue;
	}

	/**
	 * This method is used to mouseOver the element
	 * 
	 * @param elementType
	 *            -- Type of the element
	 * @param elementName
	 *            -- Name of the element
	 * @return boolean true if successfully mouse over the element
	 */
	public Boolean mouseOver(String categorytype, String categoryname, String textToReplace) {
		boolean returnValue = false;
		try {
			String name = categoryname.replaceAll("\\s", "").toLowerCase();
			By categorypath = getPropertyFile(homeObject.removeSpecialChar(convertPath(categorytype, categoryname)));
			switch (name) {
			case "imagetools":
			case "cancel":
				String path = categorypath.toString().replace("$1$", textToReplace);
				String val = path.replace("By.xpath:", "");
				Thread.sleep(1000);
				categorypath = By.xpath(val);
				break;
			default:
				throw new RuntimeException("Unknown URL :: " + categorytype);
			}
			homeObject.mouseOverClick(categorypath);
			returnValue = true;
		} catch (Exception e) {
		}
		return returnValue;
	}

	/**
	 * This method is used to click on a specific element when the element is
	 * identified by identifierType,identifierCategory,identifierSubCategory and
	 * identifierDetail. Eg. Click 'Verify' button || Click 'Start a New Order' link
	 * 
	 * @param identifierType
	 *            -- Type of the element Eg. Button, Link, etc
	 * @param identifierCategory
	 *            -- Name of the element Eg. Contact information
	 * @param identifierSubCategory
	 *            -- Type of the element Eg.Agent name,Jane Agent
	 * @param identifierDetail
	 *            -- Name of the element Eg. Edit
	 * @return boolean true if successfully clicked on the specified element
	 * @throws Exception 
	 */

	public Boolean click(String identifierType, String identifierCategory, String identifierSubCategory,
			String identifierDetail) throws Exception {

		try {
			By elementPath;
			switch (identifierType.toLowerCase()) {

			case "button":
				String getUrl = driver.getCurrentUrl();
				if (identifierDetail.toLowerCase().equalsIgnoreCase("edit") && getUrl.contains("next/build.php")) {

					elementPath = By.xpath("//div/h1[contains(text(),'" + identifierCategory
							+ "')]/following::div//span/h4[contains(text(),'" + identifierSubCategory
							+ "')]/following::a[contains(text(),'Edit')]");
					scroll(elementPath);
					click(elementPath);
				}
				break;
			default:
				throw new RuntimeException("Unknown Root Element Type :: " + identifierType);
			}

			return true;
		} catch (Exception e) {
			throw e;
		}
//		return false;
	}

}