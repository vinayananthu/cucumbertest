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
@LoginAndSignup
Feature: Test Login and Sign up scenarios

Background:
	Given I start running the following tests
		|CaseNo		|
		|C7908		|
#	When I login to "Xadmin"

@C7908
Scenario: Verification of 'Sign up' functionality with settings - 'require office'=NO; default office=Selected; 'allow sign up to create new office'=NO.
#When I Click "CompanyOfficeUser" link
#And Select "Stampin' Up!" in "select Company" dropdown
#And Click "Edit Company" button
#And Click "Signup" tab
#And Click "Require Office" radio button
#And Click "AllowSignuptoCreateNewOffice" radio button
#And Select "Stampin' Up! Independent Demonstrators-ALL (97849d0c6e)" in "Default Branch" dropdown
#And Click "Update Company" button
#And Navigate to "http://www.stage.xpressdocs.com/next/landing/index.php?path=stampinup" url
#And Click "Create An Account" button
#And Type "Test Name" in "First Name" field
#And Type "QA AutoTest" in "Last Name" field
#And Type unique "email" in "email" field
#And Type "temp1234" in "Password" field
#And Type "temp1234" in "Reenter Password" field
#And Type "12232435456" in "Phone" field
#And Type "111111" in "Office Zip" field
#And Select "Other" in "How did you hear about us" dropdown
#And Select "In what city were you born?" in "Security Question one" dropdown
#And Type "test" in "Security Question #1 Answer" field
#And Select "What is your primary industry?" in "Security Question two" dropdown
#And Type "test" in "Security Question #2 Answer" field
#And Click "Next" button
#And Click "Stampin Up! Independent Demonstrators-ALL" link
#And Click "Next" button
#And Click "Next" button
#And Click "SignMeUp" checkbox
#And Click "Finish" button
#And Close popup
#And Click "Account" link
#And Click "Edit" button under "General Information:"
Then End of test.

Scenario: End of Login And Signup
Then End of "Login And Signup"


