package genericlibrary.xadmin;

public interface InterfaceMethods {

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
	 */
	Boolean click(String elementType, String elementName) throws Exception;

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
	 */
	Boolean click(String identifierType, String identifierDetail, String elementDetail) throws Exception;

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
	 */
	Boolean verifyExpectedResult(String resultType, String resultValue) throws Exception;

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
	 */
	Boolean verifyExpectedResult(String resultType, String resultValue, String resultState) throws Exception;

	/**
	 * This method is used to verify the entered Field value is correct or not.
	 * 
	 * @param resultType
	 * @param resultValue
	 * @param resultState
	 * @param text
	 * @return boolean true if verified successfully
	 */
	Boolean verifyExpectedResult(String resultType, String resultValue, String resultState, String text) throws Exception;

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
	 */
	Boolean type(String elementName, String textToType) throws Exception;

	/**
	 * This method is used to select/check a value Eg. Select checkbox next to
	 * uploaded list || Select the 'FedEx Ground' radio
	 * 
	 * @param elementName
	 *            -- Name of the element Eg. uploaded list, FedEx Ground, etc.
	 * @return boolean true if successfully selected
	 *
	 */
	Boolean select(String elementType, String elementName)throws Exception;

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
	 */
	Boolean select(String elementType, String elementName, String textToSelect) throws Exception;

	/**
	 * This method used to login into xpressdocs home page & login as impersonate
	 * user.
	 * 
	 * @param userType
	 *            -- type of the user to impersonate company / office / agent
	 * @param id
	 *            -- user id to impersonate
	 * @return boolean true if successfully impersonated
	 */
	String impersonateUser(String userType, String id) throws Exception;

	/**
	 * This method used to navigate to specified url.
	 * 
	 * @param url
	 *            -- url to navigate
	 * @return boolean true if navigated successfully
	 */
	Boolean navigateTo(String url)throws Exception;

	/**
	 * This method is used to Browse the file for upload
	 * 
	 * @param elementName
	 *            -- Element name for which file is uploaded
	 * @param fileName
	 *            -- File name that needs to be uploaded
	 * @return boolean true if successfully browsed the file
	 *
	 */
	Boolean browse(String elementName, String fileName)throws Exception;

	/**
	 * This method is used to mouseOver the element
	 * 
	 * @param elementType
	 *            -- Type of the element
	 * @param elementName
	 *            -- Name of the element
	 * @return boolean true if successfully mouse over the element
	 */
	Boolean mouseOver(String elementType, String elementName) throws Exception;

	/**
	 * This method used to store the value in the textbox.
	 * 
	 * @param identifierType
	 *            -- Type of the element
	 * @param identifierName
	 *            -- Name of the element
	 * @return boolean true if is successfully executed, else false
	 */
	String store(String identifierType, String identifierName)throws Exception;

	/**
	 * This method used to store the value in the textbox.
	 * 
	 * @param identifierType
	 *            -- Type of the element
	 * @param identifierDetail
	 *            -- Detail of the element
	 * @param identifierName
	 *            -- Name of the element
	 * @return boolean true if is successfully executed, else false
	 */

	String store(String identifierType, String identifierDetail, String identifierName)throws Exception;

	/**
	 * @param elementType
	 *            -- Type of the element
	 * 
	 * @param elementName
	 *            -- Name of the element This method checks whether the checkbox is
	 *            enabled If it is enabled then it returns true if it is not enabled
	 *            then it will enable the checkbox and returns true
	 * @return boolean true if is successfully executed, else false
	 * @page:Customize your Order
	 */

	Boolean set(String elementType, String elementName, String value) throws Exception;

	/**
	 * This method is used to close
	 * 
	 * @param name
	 * @return boolean true if is successfully executed, else false
	 */

	Boolean close(String name) throws Exception;

	Boolean mouseOver(String elementType, String elementName, String elementDetail) throws Exception;

	/**
	 * This method used to store the value in the textbox.
	 * 
	 * @param identifierType
	 *            -- Type of the element
	 * @param identifierName
	 *            -- Name of the element
	 * @return boolean true if is successfully executed, else false
	 */

}
