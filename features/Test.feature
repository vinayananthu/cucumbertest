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
		|Test		|
#	When I login to "Xadmin"

@test
Scenario: Verify data entered during Listing creation is imported correctly into regular order.

	When I Create an order with following attributes 
		|userType			|Agent			|
		|userId				|Any			|
		|category			|Any			|
		|template			|Any			|
		|orderName			|Any			|
		|quantity			|Any			|
		|orderType			|Any			|
					 
#When Navigate to "file:///C:/Users/vananthu/Desktop/test.html"
#And Verify "USED CREDIT CARD2" field in the table is equal to "$50.00"
Then End of test.