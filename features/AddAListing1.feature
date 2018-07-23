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
#Given I login to "Xadmin"

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
#And Click "Search" button
#And Close popup
#And Verify "Street Address" label "value" should be "1115 Forest Park" 
#And Verify "mlsid" label "value" should be "1234" 
#And Verify "city" label "value" should be "Fort Worth" 
#And Verify "zipcode" label "value" should be "76110" 
#And Verify "date sold" label "value" should be "2018-06-05" 
#And Verify "price" label "price" should be "230000" 
#And Mouse over "Select Marketing" dropdown
#And Click "Send Direct Mail" dropdown
#And Click "Postcards" link under "Standard Property Marketing Templates" category
#And Click "Select" button under "96492" template
#And Click "Next" button
#And Verify "price" label "price" should be "230000"
Then End of test.

@c360 
Scenario: Verify data entered during Listing creation is imported correctly into regular order.

When I Start running test case "C360"
#And Click "CompanyOfficeUser" link
#And Select "ERA" in "select Company" dropdown
#And Select "Demo (42687DEMO4)" in "select Office" dropdown
#And Click "Edit Office" button
#And Click "Use Company Preference" radio button under "Enable My Listings"
#And Click "Update Office" button
#And navigate to "Xadmin"
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
#And navigate to "Xadmin"
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

