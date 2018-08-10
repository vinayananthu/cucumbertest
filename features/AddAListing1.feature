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
@AddAListing
Feature: Test add a listing process.

Background:
	Given I start running the following tests
		|CaseNo		|
		|C2671		|
		|C360		|
		|C360-backup|
		|C345		|
		|C346		|
		|C355		|
		|C356		|
#	When I login to "Xadmin"

@C2671 @Sample
Scenario: Verify data entered during Listing creation is imported correctly into regular order.

#When I login to "Xadmin"
#When I Click "CompanyOfficeUser" link
#And Select "ERA" in "select Company" dropdown
#And Click "Edit Company" button
#And Click "Preferences" tab
#And Click "Yes" radio button for "Enable My Listings"
#And Click "Update Company" button
#And Verify text "Account successfully updated!" is "visible"
#And Impersonate "company" user "261ERA4B67"
#And Click "Account" link
#And Click "Add a Listing or Recipient" button
#And Select "Clark (f51592dfb7)" in "select branch" dropdown
#And Select "BROSTOSKI, SUSAN (72bd3c2c2a)" in "select office" dropdown
#And Click "cancel" button
#And Select "Just Sold / Closed" in "type" dropdown
#And Type "2018-06-05" in "Date sold or closed" field
#And Type "1234" in "MLS ID" field
#And Store "mlsid" textbox
#And Type "test" in "MLS Name" field
#And Type "1115 Forest Park" in "Listing Address" field
#And Type "Fort Worth" in "City" field
#And Select "Texas" in "State" dropdown
#And Type "230000" in "Price" field
#And Type "76110" in "Zip" field
#And Type "http://116.r.photoshare.ru/01161/00b12f08eaf4813add8ed0e1a4889bea46b340fc.jpg" in "Picture URL 1" field
#And Click "verify" button
#And Click "Confirm" button
#And Click "Home" link
#And Type mlsid in "Search My Listings" field
#And Click "Search" icon
#And Close popup 
#And Mouse over "Select Marketing" dropdown
#And Click "Send Direct Mail" dropdown
#And Click "Postcards" link under "Standard Property Marketing Templates" category
#And Click "Select" button under "96492" template
#And Click "Next" button
#And Verify "price" label "price" should be "230000"
Then End of test.

@c360 
Scenario Outline: Verify data entered during Listing creation is imported correctly into regular order.

#When I Start running test case "C360"
#And Click "CompanyOfficeUser" link
#And Select "ERA" in "select Company" dropdown
#And Select <office> in "select Office" dropdown
#And Click "Edit Office" button
#And Click "Use Company Preference" radio button under "Enable My Listings"
#And Click "Update Office" button
#And Navigate to "Xadmin"
#And Click "CompanyOfficeUser" link
#And Select "ERA" in "select Company" dropdown
#And Click "Edit Company" button
#And Click "Preferences" tab
#And Click "No" radio button for "Enable My Listings"
#And Click "Update Company" button
#And Impersonate "branch" user "42687DEMO4"
#And Verify "Search My Listings" label is "unavailable"
#And Impersonate "agent" user "a4758b0d58"
#And Verify "Search My Listings" label is "unavailable"
#And Navigate to "Xadmin"
#And Click "CompanyOfficeUser" link
#And Select "ERA" in "select Company" dropdown
#And Click "Edit Company" button
#And Click "Preferences" tab
#And Click "Yes" radio button for "Enable My Listings"
#And Click "Update Company" button
#And Impersonate "branch" user "42687DEMO4"
#And Verify "Search My Listings" label is "available"
#And Impersonate "agent" user "a4758b0d58"
#And Verify "Search My Listings" label is "available"
	Then End of test. 
	
	Examples: 
	
		|office						|
		|"Demo (42687DEMO4)"		|
		|"Test_agent (42687DEMO4)"	|

@c345 
Scenario: Verify Aal Disabled For Company Enabled Office
#	When I login to "Xadmin" 
#	When I Click "CompanyOfficeUser" link 
#	And Select "ERA" in "select Company" dropdown 
#	And Click "Edit Company" button 
#	And Click "Preferences" tab 
#	And Click "No" radio button for "Allow Add a listing" 
#	And Click "Update Company" button 
#	And Verify text "Account successfully updated!" is "visible" 
#	And Click "Back" button
#	And Select "1 Campus Drive (517341CAMP)" in "Select Office" dropdown
#	And Click "Edit Office" button
#	And Click "Yes" radio button for "Allow Add a listing"
#	And Click "Update Office" button
#	And Navigate to "Xadmin" 
#	And Click "Automated Programs" link 
#	And Select "ERA" in "-Select a Company-" dropdown
#	And Click "Edit" icon next to "Follow Up" 
#	And Click "Active" radio button for "Activate Program"
#	And Click "Yes" radio button for "Show XpressConnection tab"
#	And Click "Save Program" button
#	And Impersonate "branch" user "517341CAMP" 
#	And Click "Follow Up" link 
#	And Verify link "Add a Listing or Recipient" is "visible"
#	And Click "My Account" link 
#	And Verify link "Listings / Recipient Admin" is "visible"
#	And Click "Logout" link 
#	And Impersonate "company" user "261ERA4B67"
#	And Click "Account" link 
#	And Verify link "Listings / Recipient Admin" is "not visible"
#	And Click "Follow Up" link
#	And Verify link "Add a Listing or Recipient" is "not visible"
#	And Click "Logout" link 
#	And Impersonate "agent" user "453801VINC"
#	And Click "My Account" link 
#	And Verify link "Listings / Recipient Admin" is "not visible"
#	And Navigate to "Xadmin" 
#	And Click "CompanyOfficeUser" link 
#	And Select "ERA" in "select Company" dropdown 
#	And Click "Edit Company" button 
#	And Click "Preferences" tab
#	And Click "No" radio button for "Allow Add a listing" 
#	And Click "Update Company" button 
#	And Verify text "Account successfully updated!" is "visible" 
	Then End of test.
	
@c346 
Scenario: Verify if AaL is enabled for company and office it is accessible for company and office and not available for the user
#	When I login to "Xadmin" 	
#	When I Click "CompanyOfficeUser" link 
#	And Select "ERA" in "select Company" dropdown 
#	And Click "Edit Company" button 
#	And Click "Preferences" tab 
#	And Click "Yes" radio button for "Allow Add a listing" 
#	And Click "Update Company" button 
#	And Verify text "Account successfully updated!" is "visible" 
#	And Click "Back" button
#	And Select "1 Campus Drive (517341CAMP)" in "Select Office" dropdown
#	And Click "Edit Office" button
#	And Click "Yes" radio button for "Allow Add a listing"
#	And Click "Update Office" button
#	And Navigate to "Xadmin" 
#	And Click "Automated Programs" link 
#	And Select "ERA" in "-Select a Company-" dropdown
#	And Click "Edit" icon next to "Follow Up" 
#	And Click "Active" radio button for "Activate Program"
#	And Click "Yes" radio button for "Show XpressConnection tab"
#	And Click "Save Program" button
#	And Impersonate "agent" user "453801VINC" 
#	And Click "My Account" link 
#	And Verify link "Add a Listing or Recipient" is "not visible"
#	And Impersonate "company" user "261ERA4B67" 
#	And Click "My Account" link 
#	And Verify link "Add a Listing or Recipient" is "visible"
#	And Verify link "Listings / Recipient Admin" is "visible"
#	And Click "Follow Up" link
#	And Verify link "Add a Listing or Recipient" is "visible"
#	And Impersonate "branch" user "517341CAMP" 
#	And Click "My Account" link 
#	And Verify link "Add a Listing or Recipient" is "visible"
#	And Verify link "Listings / Recipient Admin" is "visible"
#	And Click "Follow Up" link
#	And Verify link "Add a Listing or Recipient" is "visible"
#	And Click "Logout" link 
	Then End of test.
	
@c355 
Scenario: Listing search can be enabled/disabled for company/office/user
#	When I login to "Xadmin" 	
#	When I Click "CompanyOfficeUser" link
#	And Select "ERA" in "select Company" dropdown 
#	And Click "Edit Company" button 
#	And Click "Preferences" tab 
#	And Click "No" radio button for "Enable My Listings" 
#	And Click "Update Company" button 
#	And Verify text "Account successfully updated!" is "visible" 
#	And Click "Back" button
#	And Select "42687DEMO4" in "Select Office" dropdown
#	And Click "Edit Office" button
#	And Click "No" radio button for "Enable My Listings"
#	And Click "Update Office" button
#	And Verify text "Account successfully updated!" is "visible" 
#	And Impersonate "branch" user "42687DEMO4"
# 	And Verify section "Search My Listings" is "not visible"	
#	And Impersonate "agent" user "a4758b0d58"
# 	And Verify section "Search My Listings" is "not visible"
#	And Navigate to "Xadmin"
#	When I Click "CompanyOfficeUser" link
#	And Select "ERA" in "select Company" dropdown 
#	And Click "Edit Company" button 
#	And Click "Preferences" tab 
#	And Click "Yes" radio button for "Enable My Listings" 
#	And Click "Update Company" button 
#	And Verify text "Account successfully updated!" is "visible" 
#	And Impersonate "company" user "261ERA4B67"
# 	And Verify section "Search My Listings" is "visible"
#	And Impersonate "branch" user "42687DEMO4"
# 	And Verify section "Search My Listings" is "not visible"
#	And Impersonate "agent" user "a4758b0d58"
# 	And Verify section "Search My Listings" is "not visible"
#	And Navigate to "Xadmin"
#	When I Click "CompanyOfficeUser" link
#	And Select "ERA" in "select Company" dropdown 
#	And Select "42687DEMO4" in "Select Office" dropdown
#	And Click "Edit Office" button 
#	And Click "Yes" radio button for "Enable My Listings" 
#	And Click "Update Office" button 
#	And Verify text "Account successfully updated!" is "visible" 
#	And Impersonate "company" user "261ERA4B67"
# 	And Verify section "Search My Listings" is "visible"
#	And Impersonate "branch" user "42687DEMO4"
# 	And Verify section "Search My Listings" is "visible"
#	And Impersonate "agent" user "a4758b0d58"
# 	And Verify section "Search My Listings" is "visible"
#	And Navigate to "Xadmin"
#	When I Click "CompanyOfficeUser" link
#	And Select "ERA" in "select Company" dropdown 
#	And Click "Edit Company" button 
#	And Click "Preferences" tab 
#	And Click "No" radio button for "Enable My Listings" 
#	And Click "Update Company" button 
#	And Verify text "Account successfully updated!" is "visible" 
#	And Impersonate "company" user "261ERA4B67"
# 	And Verify section "Search My Listings" is "not visible"
#	And Impersonate "branch" user "42687DEMO4"
# 	And Verify section "Search My Listings" is "visible"
#	And Impersonate "agent" user "a4758b0d58"
# 	And Verify section "Search My Listings" is "visible"
	Then End of test.
	
@c356 
Scenario: Info pop-up works properly 
#	When I login to "Xadmin" 	
#	When I Click "CompanyOfficeUser" link
#	And Select "ERA" in "select Company" dropdown 
#	And Click "Edit Company" button 
#	And Click "Yes" radio button for "Mylisting popup?:"
#	And Click "Preferences" tab 
#	And Click "Yes" radio button for "Allow Add a listing"
#	And Click "Yes" radio button for "Enable My Listings"
#	And Click "Update Company" button 
#	And Verify text "Account successfully updated!" is "visible"  
#	And Navigate to "Xadmin"
#	When I Click "CompanyOfficeUser" link
#	And Select "ERA" in "select Company" dropdown 
#	And Select "42687DEMO4" in "Select Office" dropdown
#	And Click "Edit Office" button 
#	And Click "Yes" radio button for "Allow Add a listing"
#	And Click "Yes" radio button for "Enable My Listings" 
#	And Click "Yes" radio button for "Mylisting popup?:"
#	And Click "Update Office" button 
#	And Click "Back" button 
#	And Select "Agent, Jane (a4758b0d58)" in "Select User" dropdown 
#	And Click "Edit User" button
#	And Click "Yes" radio button for "Mylisting popup?:"
#	And Click "Update User" button

 
#	And Impersonate "company" user "261ERA4B67"
#	And Type "12345" in "Search My Listings" field
#	And Click "Search" icon
#	And Click "Do not show me this again" link
#	And Verify "result" field in the table is equal to "results for \"12345\" "
#	And Verify text "9 results for \"12345\" " is "visible"
#	And Click "Learn More" link
#	And Verify popup "Welcome to My Listings" is "visible"
#
#
#	And Impersonate "branch" user "42687DEMO4"
#	And Type "12345" in "Search My Listings" field
#	And Click "Search" icon
#	And Verify popup "Welcome to My Listings" is "visible"
#	And Click "Do not show me this again" link
#	And Verify text "results for \\\"12345\\"" is "visible"
#	And Click "Learn More" link
#	And Verify popup "Welcome to My Listings" is "visible"
#
#
#	And Impersonate "agent" user "a4758b0d58"
#	And Type "12345" in "Search My Listings" field
#	And Click "Search" icon
#	And Verify popup "Welcome to My Listings" is "visible"
#	And Click "Do not show me this again" link
#	And Verify text "results for \"12345\"" is "visible"
#	And Click "Learn More" link
#	And Verify popup "Welcome to My Listings" is "visible"
#
#
#	And Impersonate "company" user "261ERA4B67"
#	And Type "12345" in "Search My Listings" field
#	And Click "Search" icon
#	And Verify text "results for \"12345\"" is "visible"
#	And Verify popup "Welcome to My Listings" is "not visible"
#	And Click "Logout" link
#
#
#	And Impersonate "branch" user "42687DEMO4"
#	And Type "12345" in "Search My Listings" field
#	And Click "Search" icon
#	And Verify text "results for \"12345\"" is "visible"
#	And Verify popup "Welcome to My Listings" is "not visible"
#	And Click "Logout" link
#
#
#	And Impersonate "agent" user "a4758b0d58"
#	And Type "12345" in "Search My Listings" field
#	And Click "Search" icon
#	And Verify text "results for '12345'" is "visible"
#	And Verify popup "Welcome to My Listings" is "not visible"
#	And Click "Logout" link
#
#
#	And Navigate to "Xadmin"
#	And I Click "CompanyOfficeUser" link
#	And Select "ERA" in "select Company" dropdown 
#	And Click "Edit Company" button 
#	And Verify radio button "Mylisting popup No" is "active" 
#	And Click "Yes" radio button for "Mylisting popup"
#	And Click "Update Company" button 
#	And Click "Preferences" tab 
#	And Click "Yes" radio button for "Allow Add a listing"
#	And Click "Yes" radio button for "Enable My Listings"
#	And Click "Update Company" button 
#	And Verify text "Account successfully updated!" is "visible" 
#
#
#	And Navigate to "Xadmin"
#	And Click "CompanyOfficeUser" link
#	And Select "ERA" in "select Company" dropdown 
#	And Select "42687DEMO4" in "Select Office" dropdown
#	And Click "Edit Office" button
#	And Verify radio button "Mylisting popup No" is "active" 
#	And Click "Yes" radio button for "Mylisting popup"
#	And Click "Update Office" button 
#
#
#	And Navigate to "Xadmin"
#	And Click "CompanyOfficeUser" link
#	And Select "ERA" in "select Company" dropdown 
#	And Select "42687DEMO4" in "Select Office" dropdown
#	And Select "Agent, Jane (a4758b0d58)" in "Select User" dropdown
#	And Click "Edit User" button
#	And Verify radio button "Mylisting popup No" is "active" 
#	And Click "Yes" radio button for "Mylisting popup"
#	And Click "Update User" button
#
#
#	And Impersonate "company" user "261ERA4B67"
#	And Type "12345" in "Search My Listings" field
#	And Click "Search" icon
#	And Verify text "results for \"12345\"" is "visible"
#	And Verify popup "Welcome to My Listings" is "not visible"
#	And Click "Logout" link
#
#
#	And Impersonate "branch" user "42687DEMO4"
#	And Type "12345" in "Search My Listings" field
#	And Click "Search" icon
#	And Verify text "results for \"12345\"" is "visible"
#	And Verify popup "Welcome to My Listings" is "not visible"
#	And Click "Logout" link
#
#
#	And Impersonate "agent" user "a4758b0d58"
#	And Type "12345" in "Search My Listings" field
#	And Click "Search" icon
#	And Verify text "results for '12345'" is "visible"
#	And Verify popup "Welcome to My Listings" is "not visible"
#	And Click "Logout" link
	
	Then End of test.
		 
Scenario: End of AddAListing 
	Then End of "Add A Listing" 

