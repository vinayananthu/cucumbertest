#Author: Vinay Ananthu
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@orderMainPart1 
Feature: Order Main Agent work flow  for Coldwell Bank Florida. 

Background: 
	Given I start running the following tests
		|CaseNo	|
		|C698	|
		|C700	|
		|C701	|
		|C702	|
		|C703	|
		|C704	|
		|C708	|
#	When I impersonate "Agent" user "325DEMODEM" 
				
@C698 
Scenario: User can not proceed further from build.php if valid info is not entered. 
#	And Click "start a new order" link 
#	And Click "Property Postcards" link under "Property Marketing" category 
#	And Click "Select" button under "4862" template 
#	And Click "Next" button 
#	And Click "Continue" button 
#	Then Verify text "Error!Your order does not contain the number of photos required to place this order." is "visible" 
#	And Click "Back" button 
#	And Click "Upload Import Photos" button 
#	And Browse "700.jpg" 
#	And Type "test" in "Name Your Photo" field 
#	And Click "Insert into Order Gallery" button 
#	And Select "test" in "Photo 1" dropdown 
#	And Click "Continue" button 
#	And Click "Next" button 
#	Then Verify text "Warning!You must complete the customer agreement below to continue." is "visible"
	Then End of test. 
	
	
@C700 
Scenario: Verify that if pdf download function is unchecked - it will not be available at the order complete page. 
#	When I impersonate "Agent" user "325DEMODEM"
#	And Click "start a new order" link 
#	And Click "Property Postcards" link under "Property Marketing" category 
#	And Click "Select" button under "279780" template 
#	And Click "Next" button 
#	And Click "Skip Proof" button 
#	And Click "Pickup" radio button 
#	And Click "Next" button 
#	And Click "Next" button 
#	And Click "No" radio button under "PDF Download" 
#	And Click "Next" button 
#	And Select "Pay by Credit or Debit Card ( Pay by Credit or Debit Card )" in "Billing" dropdown 
#	And Click "Proceed to Checkout" button
#	And Verify text "PDF Download" is "not visible"
#	And Click "Order Details" link 
#	And Delete existing credit card details 
#	And Click "No" radio button for "Do you want to save your credit card" 
#	And Type "4111111111111111" in "cardnumber" field 
#	And Type "123" in "cardcvv" field 
#	And Type "12/20" in "expirationdate" field 
#	And Store "amountdue" label
#	And Type amountdue in "AMOUNT DUE FOR THIS ORDER" field 
#	And Click "Complete Checkout" button 
#	And Verify text "PDF Download" is "not visible"
#	And Verify text "PDF Download" is "not visible"
#	And Click "Order Details" link 
#	And Click "Logout" button 
#	Then Verify "/next/landing/index.php" page should be displayed. 
	Then End of test. 
	
@C701 
Scenario: Test Order Minimum Quantity functionality 
#	And Click "start a new order" link 
#	And Click "Property Postcards" link under "Property Marketing" category 
#	And Click "Select" button under "279780" template 
#	And Click "Next" button 
#	And Click "Skip Proof" button 
#	And Click "Ship Order to me" radio button 
#	And Click "Next" button 
#	And Verify radio button "Do NOT add addresses to my cards" is "selected" 
#	And Click "Next" button 
#	And Type "0" in "Order Unaddressed Cards" field 
#	And Click "Next" button 
#	Then Verify text "Error!Your order requires a minimum quantity of at least 25 items." is "visible"
#	And Verify the field "Order Unaddressed Cards" is equal to "25"
#	And Click "Next" button 
#	And Click "Next" button 
#	And Verify "Qty" field in the table is equal to "25"
#	And Click "Options" link 
#	And Verify radio button "Ship Order to me" is "selected" 
#	And Click "Next" button 
#	And Click "Radius List" link 
#	And Type "1115 Forest Park" in "property address" field 
#	And Type "76110" in "zip code" field 
#	And Select "Single and Multi-family" in "address type" dropdown 
#	And Type "24" in "search quantity" field 
#	And Click "search" button 
#	And Verify "Manage Your Address List" label is "present" 
#	And Verify "approved" button is "inactive" 
#	And Click "I agree to the terms and conditions" checkbox 
#	And Verify "approved" button is "active" 
#	And Click "approved" button 
#	And Verify "Select Address Lists" checkbox is "selected" 
#	And Click "Next" button 
#	And Type "0" in "Order additional cards" field 
#	And Click "Next" button 
#	And Verify the field "Order Unaddressed Cards" is equal to "1"
#	And Type "2" in "Order additional cards" field 
#	And Click "Next" button 
#	And Click "Next" button 
#	And Verify "Qty" field in the table is equal to "26"
	Then End of test. 
	
@C702 
Scenario: Add, Edit, Delete On ShippingAddress 
#	When I impersonate "Agent" user "325DEMODEM" 
#	And Click "start a new order" link 
#	And Close popup 
#	And Click "Property Postcards" link under "Property Marketing" category 
#	And Click "Select" button under "118394" template 
#	And Click "Next" button 
#	And Click "Skip Proof" button 
#	And Click "Ship Order to me" radio button 
#	And Click "Next" button 
#	And Click "Next" button 
#	And Click "Next" button 
#	And Click "Specify Ship to Address" radio button 
#	And Click "Add New Address" button 
#	And Click "Save This Address" button 
#	And Verify text "Error!Please enter a phone number for contact purposes." is "visible"
#	And Type "847-381-0300" in "phone" field
#	And Click "Save This Address" button
#	And Verify text "Error!Please enter your postal code." is "visible"
#	And Type "60010" in "zip" field
#	And Click "Save This Address" button
#	And Verify text "Error!Please enter your state." is "visible"
#	And Select "Illinois" in "State" dropdown
#	And Click "Save This Address" button
#	And Verify text "Error!Please enter your city." is "visible"
#	And Type "BARRINGTON" in "City" field
#	And Click "Save This Address" button
#	And Verify text "Error!Please enter your street address." is "visible"
#	And Type "508 S NORTHWEST HWY" in "Address" field
#	And Click "Save This Address" button
#	And Verify text "Error!Please enter your name." is "visible"	
#	And Type "QA Auto Test" in "Name" field
#	And Click "Save This Address" button
#	And Verify text "Error!Please tell us what type of address this is." is "visible"
#	And Click "Yes" radio button under "Business Address"
#	And Click "Save This Address" button
#	And Verify text "Error!Please enter the name of your company." is "visible"
#	And Type "QA Auto Company" in "Company" field
#	And Verify radio button "Business Address Yes" is "active" 
#	And Verify the following fields 
#		|Name:			|QA Auto Test			|			
#		|Company:		|QA Auto Company		|
#		|Address:		|508 S NORTHWEST HWY	|
#		|City:			|BARRINGTON				|
#		|Zip:			|60010					|
#		|Phone:			|847-381-0300			|
#	And Click "Save This Address" button
#	And Click "edit" link
#	And Click "Noupdate" radio button under "Is this a business address"
#	And Type the following 
#		|TEST NAME				|Name1			|
#		|!Leave the field empty	|Company1		|
#		|1830 N HUDSON AVE		|Address1update	|
#		|CHICAGO				|City1			|
#		|60614					|zip1			|
#		|321-654-0987			|phone1			|
#	And Select "Illinois" in "State1" dropdown
#	And Select "U.S.A" in "Country1" dropdown
#	And Click "Update This Address" button
#	And Click "Delete" link
#	And Click "ok" link
#	And Click "Add New Address" button
#	And Click "Yes" radio button under "Business Address"
#	And Type the following 
#		|QA AUTO TEST			|Name			|
#		|Xpressdocs				|Company		|
#		|1111 Forest Park BLVD	|Address		|
#		|Fort Worth				|City			|
#		|76110					|zip			|
#		|123-456-7890			|phone			|
#	And Click "State" dropdown
#	And Select "Texas" in "State" dropdown
#	And Click "Country" dropdown
#	And Select "USA" in "Country" dropdown
#	And Click "Save This Address" button
#	And Click "Back" button
#	And Navigate to "xadmin"
#	And Click "Company Office User" link
#	And Select "Coldwell Banker Florida" in "Company" dropdown
#	And Select "XDDEV_TEST (6NEWBRANCH)" in "Office" dropdown
#	And Click "editoffice" button
#	And Click "Yes" radio button under "User Active"
#	And Click "Update Office" button
#	And Impersonate "branch" user "6NEWBRANCH" 
#	And Click "My Account" link
#	And Click "Edit Office Info" button
#	And Click "Edit" button under "Shipping Address:"
#	And Impersonate "agent" user "325DEMODEM"
#	And Close popup
#	And Click "start a new order" link
#	And Click "Property Postcards" link under "Property Marketing" category 
#	And Click "Select" button under "118394" template 
#	And Click "Next" button 
#	And Click "Skip Proof" button 
#	And Click "Ship Order to me" radio button
#	And Click "Next" button 
#	And Click "Next" button 
#	And Click "Next" button 
#	And Click "Specify Ship to Address" radio button 
#	And Click "Add New Address" button  
#	And Click "Load Office Address" button 
	Then End of test.
	
	
@C703 
Scenario: Verify that user cannot refund mailorders on same business days
#	When I impersonate "Agent" user "325DEMODEM" 
#	And Click "start a new order" link 
#	And Close popup 
#	And Click "Property Postcards" link under "Property Marketing" category 
#	And Click "Select" button under "4862" template 
#	And Click "Next" button 
#	And Click "Skip Proof" button 
#	And Click "Use our Complete Mailing Service" radio button
#	And Click "Next" button
#	And Click "First Class Mail" radio button
#	And Click "Next" button
#	And Click "Upload List" icon
#	And Browse "1000_FOREST_PARK_BLVD-250.csv"
#	And Click "Upload" button
#	And Verify text "Our system analyzed your file and selected the fields below. Please examine the address shown here and correct it if necessary." is "visible"
#	And Click "Next" button
#	And Click "Approved" button
#	And Verify text "Certifying your addresses..." is "visible"
#	And Verify text "We have processed your list against US Postal Service data and identified invalid addresses. View the results below:" is "visible"
#	And Click "Finished" button
#	And Click "Next" button
#	And Click "Next" button
#	And Store "Order_ID" label
#	And Select "Pay by Credit or Debit Card ( Pay by Credit or Debit Card )" in "Billing" dropdown
#	And Click "Proceed To Checkout" button
#	And Delete existing credit card details
#	And Click "Add Card" link
#	And Click "No" radio button under "Do you want to save your credit card?"
#	And Type the following 
#		|4111111111111111		|Card Number	|
#		|123					|Cvv			|
#		|12/20					|Expiration		|
#	And Store "AMOUNT DUE:" label
#	And Type amountdue in "Enter amount to charge" field
#	And Click "Complete Checkout" button
#	And Navigate to "http://www.stage.xpressdocs.com/next/xadmin/"
#	And Type order_id in "Search for Order" field
#	And Click "Search Order" button
#	And Click "Transaction" link
#	And Click "Refund" link
#	And Verify text "Warning. No refunds may be processed on the same day of order completion. Please wait until next business day." is "visible"
#	And Verify the following checkboxes 
#		|Product Cost:	|inactive|
#		|Shipping Cost:	|inactive|
#		|Mailing Cost:	|inactive|
#		|Side 2			|inactive|
#		|Color Upgrade:	|inactive|
#	And Click "Get Sales Tax" button 
#	And Verify "Refund" button is "inactive"
#	And Type "Test" in "Reason" field
#	And Click "Back" button
#	And Click "Cancel Order" button
##	And Verify confirmation "Do you want cancel order?" is "visible"
##	And Click "Ok" button
##	And Verify confirmation "Order successfully cancelled, Auto refund process completed" is "visible"
##	And Click "Ok" button
#	And Verify "Status" field in the table is equal to "CANCELLED"
	Then End of test. 
	
	
	
@C704 
Scenario: Verify that user cannot refund mailorders on same business days 
#	When I impersonate "Agent" user "325DEMODEM" 
#	And Click "start a new order" link 
#	And Close popup 
#	And Click "Brochures" link under "Visionary Designs" category 
#	And Click "Select" button under "320236" template 
#	And Click "Next" button 
#	And Type " 3 Photos (01) (4865, 8)" in "Name This Order" field
#	And Click "Skip Proof" button 
#	And Click "Ship Order to me" radio button
#	And Click "Next" button
#	And Click "Next" button
#	And Click "Next" button
##	And Click "Next" button	
#	And Store "Order_ID" label	
#	And Select "Pay by Credit or Debit Card ( Pay by Credit or Debit Card )" in "billing" dropdown	
#	And Click "Proceed to checkout" button
#	And Click "No" radio button for "Do you want to save your credit card'?"
#	And Type the following 
#		|4111111111111111		|Card Number	|
#		|123					|cardcvv		|
#		|12/20					|Expiration		|
#	And Store "amountdue" label
#	And Type amountdue in "amounttocharge" field
#	And Click "Complete Checkout" button	
#	And Click "Logout" link
#	And Navigate to "http://www.stage.xpressdocs.com/next/xadmin/"
#	And Type order_id in "Search for Order" field
#	And Click "search order" button
#	And Click "Transaction" link
#	And Click "Refund" link
#	And Verify text "Warning. No refunds may be processed on the same day of order completion.Please wait until next business day." is "visible" 
#	And Verify the following checkboxes 
#		|Product Cost:	|inactive|
#		|Shipping Cost:	|inactive|
#		|Mailing Cost:	|inactive|
#		|Side 2			|inactive|
#	And Verify "refundsub" button is "inactive"
#	And Click "getsalestax" button
#	And Verify the following checkboxes 
#		|Product Cost:	|inactive|
#		|Shipping Cost:	|inactive|
#		|Mailing Cost:	|inactive|
#		|Side 2			|inactive|
#	And Verify "refundsub" button is "inactive"
#	And Type "test" in "reason" field
#	And Click "back" button
#	And Click "cancelorder" button 
#	And Verify "Status" field in the table is equal to "CANCELLED"
	Then End of test.
	
@C708 
Scenario: Add, Edit, Delete On ShippingAddress 
#	When I impersonate "Agent" user "325DEMODEM"
#	And Click "start a new order" link 
#	And Close popup 
#	And Click "Property Postcards" link under "Property Marketing" category 
#	And Click "Select" button under "118394" template 
#	And Click "Next" button 
#	And Type " 3 Photos (01) (4865, 8)" in "Name This Order" field
#	And Click "Skip Proof" button 
#	And Click "Ship Order to me" radio button
#	And Click "Next" button
#	And Click "Next" button
#	And Click "Next" button
#	And Click "Next" button
#	And Click "back" button
#	And Verify confirmation "Are you sure you want to leave this page? Your order information will not be saved unless you click the \"Continue Shopping\" button or \"Proceed to Checkout\" button." is "visible"
#	And Click "ok" button
#	And Verify text "Error" is "not visible"
#	And Verify text "Warning" is "not visible"
#	And Verify text "Fatal" is "not visible"
#	And Click "Next" button
#	And Verify "Order Summary" header
#	And Store "Order_ID" label
#	And Select "Pay by Credit or Debit Card ( Pay by Credit or Debit Card )" in "billing" dropdown
#	And Click "Continue Shopping" button
#	And Verify "On-Demand Marketing" header
#	And Navigate to "back"
#	And Verify "Orders" header
#	Then Verify error "Error!A problem has occurred during the ordering process. You may have opened another window with your current login. Your existing order data was not lost. If this problem persists, please contact us for more assistance."
#	And Verify "Pending Orders" label is "present"
#	And Navigate to "forward"
#	And Click "cart" link
#	And Click "Proceed to checkout" button
#	And Click "edit" icon
#	And Click "Edit Billing" link
#	And Verify "Order Summary" header
#	And Click "Options" link
#	And Click "Customize & Proof" link
#	And Verify "Customize and Proof" header
#	And Click "Choose Template" link
#	And Verify "Choose Template" header
#	And Click "Select a Product" link
#	And Verify "Select a Product" header
#	And Click "cart" link
# 	And Verify "cart item" textbox is "present"
#	And Click "Proceed to checkout" button
#	And Store "amountdue" label
#	And Click "nosavecc" radio button
#	And Type the following 
#		|4111111111111111		|Card Number	|
#		|123					|cardcvv		|
#		|12/20					|Expiration		|
#	And Type amountdue in "amounttocharge" field
#	And Click "Complete Checkout" button
#  	Then Verify "thank" label is "Thank you for your purchase! Your checkout is now complete.Please print and save this page for your records."
	Then End of test.



Scenario: End of Order Main 
	Then End of "Order Main Part 1"