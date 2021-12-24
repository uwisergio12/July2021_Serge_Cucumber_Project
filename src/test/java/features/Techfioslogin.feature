@LoginFeature @Regression
Feature: TechFios login functionality validation

Background:
	Given User is on Techfios login page  

@Scenario1 @smoke
Scenario: 1 User should be able to login with valid credentials
	
	When User enters password as "abc123"
	When User enters username as "demo@techfios.com" 
	And User clicks on signin button
	Then User should land on dashboard page
	
@Scenario2 
Scenario: 2 User should not be able to login with invalid password
	When User enters password as "abc124"
	When User enters username as "demo@techfios.com" 
	And User clicks on signin button
	Then User should land on dashboard page
	
@Scenario3 @smoke
Scenario: 3 User should not be able to login with invalid username
	When User enters password as "abc123"
	When User enters username as "demo2@techfios.com" 
	And User clicks on signin button
	Then User should land on dashboard page
	
