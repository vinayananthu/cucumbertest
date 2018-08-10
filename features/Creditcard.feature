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
@CreditCard
Feature: Test Credit card scenarios.

Background:
	Given I start running the following tests
		|CaseNo		|
		|C1892		|
		|C1914		|
#	When I impersonate "Agent" user "b3d128b681"

@C1892
Scenario: Edit CC with save changes.
#When I impersonate "Agent" user "b3d128b681"
#When I Click "start a new order" link
#And Click "Flyers - One and Two Sided" link under "Brochures & Flyers" category
#And Click "Select" button under "82427" template
#And Click "Next" button
#And Click "Skip Proof" button
#And Type "500" in "Order Unaddressed Cards" field
#And Click "Next" button
#And Click "Specify ship to address" radio button
#And Add address
#And Click "Fedex Ground" radio button
#And Click "Next" button
#And Select "Pay by Credit or Debit Card ( Pay by Credit or Debit Card )" in "billing" dropdown
#And Click "Proceed to Checkout" button
#And Click "Cancel" button on "Mobile Ad pop up"
#And Verify link " Add Card" is "visible"
#And Delete existing credit card details
#And Type the following
#		|Test				|Cardholder Name	|
#		|4111111111111111	|Card Number		|
#		|500				|Card CVV			|
#		|12/20				|Expiration Date	|	
#And Click "Save Card" button
#And Click "Edit CC" button
#And Type "Test QAAuto" in "Cardholder Name2" field
#And Click "Update Card" button
#And Click "ok" button
#And Type the following
#		|Test QAAuto		|Cardholder Name2	|
#		|4111111111111111	|Card Number2		|
#		|500				|Card CVV2			|
#		|12/20				|Expiration Date2	|	
#And Click "Update Card" button
#And Click "Edit CC" button
#And Click "cancel" button
#And Click "Use Credit Card" checkbox 
#And Click "Complete Checkout" button
Then End of test.

@C1914 
Scenario: Multiple Credit Card payment with unsaved and saved Credit Cards 
#	When I impersonate "Agent" user "b3d128b681" 
#	When I Click "start a new order" link 
#	And Click "Flyers - One and Two Sided" link under "Brochures & Flyers" category 
#	And Click "Select" button under "82427" template 
#	And Click "Next" button 
#	And Click "Skip Proof" button 
#	And Type "500" in "Order Unaddressed Cards" field 
#	And Click "Next" button 
#	And Click "Specify ship to address" radio button 
#	And Click "first" radio button under "selectoraddaddress" 
#	And Click "FedEx Ground" radio button 
#	And Click "Next" button 
#	And Click "Proceed to Checkout" button 
#	And Click "Cancel" button on "Mobile Ad pop up" 
#	And Click "Click here to charge amount due to multiple cards" link 
#	And Click "Don't use multiple cards!" link 
#	And Click "Click here to charge amount due to multiple cards" link 
#	And Store "amountdue" label 
#	And Type "50.0" in "Enter Amount To Charge:" field 
#	And Click "Add Card+" link 
#	And Click "No" radio button under "Do you want to save your credit card" 
#	And Type "4242424242424242" in "creditcardnumber" field 
#	And Type "123" in "cvv" field 
#	And Type "12/20" in "expiration" field 
#	And Type "50.0" in "Enter Amount To Charge3" field
#	And Click "Complete Checkout" button 
#	And Handle the alert 
#	And Type remaining amountdue in "Enter Amount To Charge3" field 
#	And Click "Complete Checkout" button 
#	And Verify text "Thank you for your purchase! Your checkout is now complete." is "visible"
#	And Click "Order Details" link
#	And Verify "USED CREDIT CARD2" field in the table is equal to "$50.00"
#	And Verify "USED CREDIT CARD1" field in the table is equal to remaining amount
#	And Click "My Account" link 
#	And Click "Edit Credit Card" button 
#	And Verify form "*411111******1111" is "visible"
	Then End of test. 


Scenario: End of Order Main
Then End of "Credit card workflow"

