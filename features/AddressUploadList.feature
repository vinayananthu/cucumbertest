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
@AddressUpload
Feature: Test upload addresses process.

Background:
	Given I start running the following tests
		|CaseNo		|
		|C388		|
		|C365		|
#	When I impersonate "Agent" user "325DEMODEM"

@C388 
Scenario: Upload a List: verify that there is only ONE record added by one time 
#	When I impersonate "Agent" user "325DEMODEM"
#	When I Click "Account" link 
#	And Click "Manage Address Lists" button 
#	And Click "upload List" link 
#	And Browse "1000_FOREST_PARK_BLVD-250.xls" 
#	And Click "Upload" button 
#	And Click "Next" button 
#	And Store "Name your List" textbox 
#	And Click "Approved" button 
#	And Click "Finished" button 
#	And Click "Edit" icon 
#	And Click "Add New Address" link 
#	And Type "QAAuto_Test" in "name" field 
#	And Type "1115 Forest Park BLVD" in "address" field 
#	And Type "Fort Worth" in "city" field 
#	And Type "76110" in "zip" field 
#	And Select "Texas" in "state" dropdown 
#	And Click "Add" button 
#	And Type "QAAuto_Test" in "find" field 
#	And Click "Search" icon 
#	And Verify the following table values 
#		|Address		|1115 Forest Park BLVD	|
#		|City			|FORT WORTH				|
#		|Zip			|76110					|
#		|State			|TX						|
#	And Verify text "Showing 1 - 1 of 1 addresses" is "visible" 
	Then End of test. 

@C365
Scenario: Upload address list: verify unsupported formats.
#When I Click "My account" link
#And Click "Manage Address Lists" button
#And Click "Upload List" icon
#And Browse "test.html"
#And Click "Upload" button
#And Verify text " The file you uploaded is not in the correct format for our system." is "visible"
#And Browse "test.doc"
#And Click "Upload" button
#And Verify text " The file you uploaded is not in the correct format for our system." is "visible"
#And Browse "test.sxc"
#And Click "Upload" button
#And Verify text " The file you uploaded is not in the correct format for our system." is "visible"
#And Browse "test.jpg"
#And Click "Upload" button
#And Verify text " The file you uploaded is not in the correct format for our system." is "visible"
#And Browse "Empty1.xls"
#And Click "Upload" button
#And Verify text " we were unable to read the file you uploaded" is "visible"
#Then Verify "next/account/address_upload/assistance.php" page should be displayed.
Then End of test.

Scenario: End of Order Main
Then End of "Address Upload workflow"



