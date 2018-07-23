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
@orderMain
Feature: Order Main Agent work flow  for Coldwell Bank Florida.

Background:
#Given I impersonate "Agent" user "325DEMODEM"

@C701 @Sample
  Scenario: Verify that if pdf download function is unchecked - it will not be available at the order complete page.
#  When I Start running test case "C701"
#  And Click "start a new order" link
#  And Click "Property Postcards" link under "Property Marketing" category
#  And Click "Select" button under "4862" template
#  And Click "Next" button
#  And Click "Skip Proof" button
#  And Click "Ship Order to me" radio button
#  And Click "Next" button
#  And Verify "radio" button "Do NOT add addresses to my cards" is "selected" 
#  And Click "Next" button
#  And Type "0" in "Order Unaddressed Cards" field
#  And Click "Next" button
#  Then Verify error "Error!Your order requires a minimum quantity of at least 25 items."
#  And Verify "textbox" "Order Unaddressed Cards" should be "25"
#  And Click "Next" button
#  And Click "Next" button
#  Then Verify "qty" "value" should be "25" in Order Summary
#  And Click "Options" link
#  And Verify "radio" button "Ship Order to me" is "selected"
#  And Click "Next" button
#  And Click "Radius List" link
#  And Type "1115 Forest Park" in "property address" field
#  And Type "76110" in "zip code" field
#  And Select "Single and Multi-family" in "address type" dropdown
#  And Type "24" in "search quantity" field
#  And Click "search" button
#  And Verify "Manage Your Address List" label is "present"
#  And Verify "approved" button is "inactive"
#  And Click "I agree to the terms and conditions" "checkbox"
#  And Verify "approved" button is "active"
#  And Click "approved" button
#  And Verify "Select Address Lists" checkbox is "selected"
#  And Click "Next" button
#  And Type "0" in "Order additional cards" field
#  And Click "Next" button
#  And Verify "textbox" "Order Unaddressed Cards" should be "1"
#  And Type "2" in "Order additional cards" field
#  And Click "Next" button
#  And Click "Next" button
#  Then Verify "qty" "value" should be "26" in Order Summary
  Then End of test.

 
  @C698 @Sample
  Scenario: User can not proceed further from build.php if valid info is not entered. 
  When I Start running test case "C698"
#  And Click "start a new order" link
#  And Click "Property Postcards" link under "Property Marketing" category
#  And Click "Select" button under "4862" template
#  And Click "Next" button
#  And Click "Continue" button
#  Then Verify error "Error!Your order does not contain the number of photos required to place this order."
  Then End of test.
 
  @C700
  Scenario: Verify that if pdf download function is unchecked - it will not be available at the order complete page.
  When I Start running test case "C700"
#  And Click "start a new order" link
#  And Click "Property Postcards" link under "Property Marketing" category
#  And Click "Select" button under "4862" template
#  And Click "Next" button
#  And Click "Skip Proof" button
#  And Click "Pickup" radio button
#  And Click "Next" button
#  And Click "Next" button
#  And Click "No" radio button under "PDF Download"
#  And Click "Next" button
#  And Select "Pay by Credit or Debit Card ( Pay by Credit or Debit Card )" in "Billing" dropdown
#  And Click "Proceed to Checkout" button
#  And Click "Order Details" link
#  And Delete existing credit card details
#  And Click "No" radio button for "Do you want to save your credit card"
#  And Type "4111111111111111" in "cardnumber" field
#  And Type "123" in "cardcvv" field
#  And Type "12/20" in "expirationdate" field
#  And Type amountdue in "AMOUNT DUE FOR THIS ORDER" field
#  And Click "Complete Checkout" button
#  And Click "Order Details" link
#  And Click "Logout" button
#  Then Verify "/next/landing/index.php" page should be displayed.
  Then End of test.
  
 Scenario: End of Execution
  When End of Execution