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
Given I impersonate "Agent" user "325DEMODEM"

@C388
Scenario: Verify data entered during Listing creation is imported correctly into regular order.
When I Start running test case "C388"
And Click "Account" link
And Click "Manage Address Lists" button
And Click "upload List" link
And Browse "1000_FOREST_PARK_BLVD-250.xls"
And Click "Upload" button
And Click "Next" button
And Store "Name your List" textbox
And Click "Approved" button
And Click "Finished" button
And Click "Edit" icon
And Click "Add New Address" link
And Type "QAAuto_Test" in "name" field
And Type "1115 Forest Park BLVD" in "address" field
And Type "Fort Worth" in "city" field
And Select "Texas" in "state" dropdown
And Type "76110" in "Zip code" field
And Click "Save" button
And Type "QAAuto_Test" in "find" field
And Click "Search" icon
Then Verify "address list" label "value" should be "Showing 1 - 1 of 1 addresses" 
Then End of test.




