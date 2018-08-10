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
@OrderHistory
Feature: Test Order history scenarios.

Background: 
	Given I start running the following tests
		|CaseNo		|
		|C861		|
		|C862 part1	|
		|C862 part2	|
		|C862 part3	|
		|C863		|
		|C864 part1	|
		|C864 part2	|
		|C864 part3	|
		|C866		|
		|C867		|
		|End		|
#	When I login to "Xadmin"

@C861 
Scenario: Agent And Company Level Verification 
#	When I impersonate "Agent" user "299378JEAN" 
#	And Click "My Account" link 
#	And Click "Order History" link 
#	And Click "Home" tab 
#	And Click "Order History" link 
#	And Verify "Orders" table is "available" 
#	And Click "Search Orders" button 
#	And Verify the following "text" fields 
#		|Order Name			|visible	|
#		|Property Address	|visible	|
#		|User name			|visible	|
#		|Order ID			|visible	|
#		|Cart ID			|visible	|
#		|Date Range			|visible	|
#	And Click "Search" button
#	And Click "View All Orders" button
#	And Impersonate "company" user "130COLDWEL" 
#	And Click "My Account" link 
#	And Click "Order History" link 
#	And Click "Home" tab 
#	And Click "Order History" link 
#	And Click "View All Orders" button
#	And Click "Search Orders" button
#	And Verify the following "text" fields 
#		|Order Name			|visible	|
#		|Property Address	|visible	|
#		|User name			|visible	|
#		|Order ID			|visible	|
#		|Cart ID			|visible	|
#		|Date Range			|visible	|
#	And Click "Search" button
#	And Verify "Cart ID" table is "visible" 
#	And Select "46319UNITE" in "Search by Office" dropdown
#	And Click "Search" button
#	And Verify "Cart ID" table is "available" 
#	And Verify "office" field in the table is equal to "United, Realtors"
#	And Select "446010SHIR" in "Choose User" dropdown
#	And Click "Search" button
#	And Verify "choose user" field in the table is equal to "Shirley Stephen"
#	And Select "299404NANC" in "Choose User" dropdown
#	And Click "Search" button
#	And Verify "Cart ID" table is "Not visible" 
#	And Verify text "You have no completed orders that match the above search criteria" is "visible" 
#	And Impersonate "agent" user "299404NANC" 
#	And Click "Order History" link 
#	And Verify "Cart ID" table is "Not visible" 
#	And Verify text "You have no completed orders. Please visit Pending Orders to review any incomplete orders. If you need further assistance, please contact our client services team at 1.866.977.3627." is "visible"
	And End of test.

@C862 
Scenario Outline: Agent And Company Level Verification 
#	When I impersonate <Usertype> user <id> 	
#	And Click "Order History" link
#	And Click "Search Order" button
#	And Verify the following "text" fields 
#		|Order Name			|visible	|
#		|Property Address	|visible	|
#		|User name			|visible	|
#		|Order ID			|visible	|
#		|Cart ID			|visible	|
#		|Date Range			|visible	|
#	And Type "2017-08-01" in "date_from" field
#	And Type "2017-08-01" in "date_to" field
#	And Click "Search" button
#	And Verify text "End date is before Start date." is "visible" 
#	And Type "2017-11-11" in "date_from" field
#	And Type "2017-11-011" in "date_to" field
#	And Click "Search" button
#	And Verify text "Start/end dates is incorrectEnd date is before Start date." is "visible"
#	And Type "2017-01-01" in "date_from" field
#	And Type "2017-12-12" in "date_to" field
#	And Click "Search" button
#	And Verify "Cart ID" table is "available" 
	Then End of test.
	Examples: 
		|Usertype				|id						|
		|"agent"				|"325DEMODEM"			|
		|"branch"				|"6NEWBRANCH"			|
		|"company"				|"16COLDWELLBANKERFL42"	|	



@C863 
Scenario: Find Order By Property Address 
#	When I impersonate "company" user "261ERA4B67" 
#	And Click "Order History" link
#	And Click "Search Order" button
#	And Verify the following "text" fields 
#		|Order Name			|visible	|
#		|Property Address	|visible	|
#		|User name			|visible	|
#		|Order ID			|visible	|
#		|Cart ID			|visible	|
#		|Date Range			|visible	|
#	And Type "123 sdfgdsfg" in "Property Address" field
#	And Click "Search" button
#	And Verify text "You have no completed orders that match the above search criteria" is "visible" 
#	And Type "" in "Property Address" field
#	And Click "Search" button
#	And Verify text "You have no completed orders that match the above search criteria" is "not visible"
#	And Type "Forest Park" in "Property Address" field
#	And Click "Search" button
#	And Verify "Cart ID" table is "available"	
	Then End of test.

@C864 
Scenario Outline: Find order by orderName
#	When I impersonate <Usertype> user <id>	
#	And Click "Order History" link
#	And Click "Search Order" button
#	And Verify the following "text" fields 
#		|Order Name			|visible	|
#		|Property Address	|visible	|
#		|User name			|visible	|
#		|Order ID			|visible	|
#		|Cart ID			|visible	|
#		|Date Range			|visible	|
#	And Type "456" in "Order Name" field
#	And Click "Search" button
#	And Verify text "You have no completed orders that match the above search criteria" is "visible"
#	And Type "" in "Order Name" field
#	And Click "Search" button
#	And Verify "Cart ID" table is "available"
#	And Type "test" in "Order Name" field
#	And Click "Search" button
#	And Verify "Cart ID" table is "available"
	Then End of test.
	Examples: 
		|Usertype				|id						|
		|"agent"				|"325DEMODEM"			|
		|"branch"				|"6NEWBRANCH"			|
		|"company"				|"16COLDWELLBANKERFL42"	|
		
@C866
Scenario: Find order by orderId and cartId
#When I impersonate "Agent" user "214922NANN"
#And Click "Order History" link
#And Click "Search order" button
#And Type "4455" in "Order ID" field
#And Click "Search" button
#And Verify text "You have no completed orders that match the above search criteria" is "visible"
#And Type "4455t" in "Order ID" field
#And Click "Search" button
#And Click "Ok" link
#And Type "4815660" in "Order ID" field
#And Click "Search" button
#And Verify "Cart ID" table is "available"
#And Verify "Order ID" field in the table is equal to "4815660"
#And Type "4455" in "Cart ID" field
#And Click "Search" button
#And Verify text "You have no completed orders that match the above search criteria" is "visible"
#And Type "4455t" in "Cart ID" field
#And Click "Search" button
#And Click "Ok" link
#And Type "3064623" in "Cart ID" field
#And Click "Search" button
#And Verify "Cart ID" table is "available"
#And Type "4815660" in "Order ID" field
#And Type "3064623" in "Cart ID" field
#And Click "Search" button
#And Verify "Cart ID" table is "available"
#And Verify "Order ID" field in the table is equal to "4815660"
Then End of test.

@C867
Scenario: Find order by orderId and cartId
#When I impersonate "Company" user "261ERA4B67"
#And Click "Order History" link
#And Click "Search order" button
#And Type "2013-10-01" in "Date_from" field
#And Type "2011-09-26" in "Date_to" field
#And Type "123456789" in "Property Address" field
#And Click "Search" button
#And Verify text "Error! End date is before Start date." is "visible"
#And Verify text "You have no completed orders that match the above search criteria" is "visible"
#And Type "2013-10-01" in "Date_from" field
#And Type "2011-09-26" in "Date_to" field
#And Type "Forest Park BLVD" in "Property Address" field
#And Click "Search" button
#And Verify text "Error! End date is before Start date." is "visible"
#And Verify text "You have no completed orders that match the above search criteria" is "visible"
#And Type "2011-09-26" in "Date_from" field
#And Type "2017-10-01" in "Date_to" field
#And Type "123456789" in "Property Address" field
#And Click "Search" button
#And Verify text "You have no completed orders that match the above search criteria" is "visible"
#And Type "2017-01-01" in "Date_to" field
#And Type "Forest Park" in "Property Address" field
#And Click "Search" button
#And Verify text "You have no completed orders that match the above search criteria" is "not visible"
Then End of test.

Scenario: End of Order History
Then End of "Order History workflow"