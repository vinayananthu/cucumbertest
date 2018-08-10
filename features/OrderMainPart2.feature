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
@orderMainPart2 
Feature: Order Main Agent work flow  for Coldwell Bank Florida. 

Background: 
	Given I start running the following tests
		|CaseNo		|
		|C709		|
		|C2649		|
#	When I impersonate "Agent" user "8be5e8364e" 
@C709
Scenario: Verify Business Card Address
#	When I impersonate "Agent" user "8be5e8364e" 
#	When I Click "start a new order" link 
#	And Close popup 
#	And Click "SIR Foil Business Cards" link under "Business Cards" category 
#	And Click "Select" button under "159597" template 
#	And Click "Next" button 
#	And Type "INTL 1 Line Address FS" in "Name This Order" field
#	And Store the following textboxes 
#		|Agent Name		|
#		|Company Name	|
#		|Company Name 2	|
#		|Address		|
#		|Address2		|
#		|Email			|
#		|Website		|
#	And Click "Skip Proof" button 
#	And Store "Order_ID" label
#	And Click "back" button
#	And Click "back" button
#	And Click "Save & Exit" button
#	And Click "Pending Order" link 
#	And Click "Place/Edit" link
#	And Verify "Agent Name" textbox with stored value
#	And Verify the following textboxes with stored values 
#		|Agent Name		|
#		|Company Name	|
#		|Company Name 2	|
#		|Address		|
#		|Address2		|
#		|Email			|
#		|Website		|
#	And Click "Continue" button
#	And Click "View Larger" icon on the "bottom"
#	And Click "close" icon
#	And Click "Logout" link
	Then End of test.

@C2649 
Scenario: Verify Business Card Address 
#	When I impersonate "Company" user "102SOTHEBYSINTERNATI" 
#	And Click "start a new order" link 
#	And Close popup 
#	And Click "SIR Standard Business Cards" link under "Business Cards" category 
#	And Click "Select" button under "89117" template 
#	And Click "Next" button 
#	And Select "7341DEMOBR" in "Select Office" dropdown
#	And Select "86930JANER" in "Select User" dropdown
#	And Verify "Agent Name" textbox is set to "Jane Realtor"
#	And Select "12de0a8c9b" in "Select User" dropdown
#	And Verify "Agent Name" textbox is set to "Full Name Last Name"
#	And Verify "Company Name" textbox is set to "Demo Branch"
#	And Verify "Company Name2" textbox is set to "Sotheby's International Realty"
#	And Verify "Address" textbox is set to "1234 Here Street "
#	And Verify "Address2" textbox is set to "This Town, TX 76110"
Then End of test.
	
Scenario: End of Order Main Part2
Then End of "OrderMain Part2"