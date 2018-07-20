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
Given I login to "Xadmin"

@C2671 @Sample
Scenario: Verify data entered during Listing creation is imported correctly into regular order.

When I Start running test case "C2671"
#And Click "CompanyOfficeUser" link
#And Select "ERA" in "select Company" dropdown
#And Click "Edit Company" button
#And Click "Preferences" tab
#And Click "Yes" radio button for "Enable My Listings"
#And Click "Update Company" button
#And Impersonate "company" user "261ERA4B67"

Then end of test.

