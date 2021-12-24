@OtherLoginFeature @Regression
Feature: TechFios login functionality validation

@OtherScenario1 
Scenario Outline: User should be able to login with valid credentials
	Given User is on Techfios login page  
	When User enters password as "<username>"
	When User enters username as "<password>" 
	And User clicks on signin button
	Then User should land on dashboard page
	
	Examples:
	| username | password |
	|demo@techfios.com | abc123 |
	|demo@techfios.com | abc124 |
	|demo2@techfios.com | abc123 |
	|demo2@techfios.com | abc124 |

@OtherScenario2	
Scenario: User should not be able to login with invalid password
	Given User is on Techfios login page  
	When User enters password as "abc124"
	When User enters username as "demo@techfios.com" 
	And User clicks on signin button
	Then User should land on dashboard page
	
@OtherScenario3 
Scenario: User should not be able to login with invalid username
	Given User is on Techfios login page  
	When User enters password as "abc123"
	When User enters username as "demo2@techfios.com" 
	And User clicks on signin button
	Then User should land on dashboard page
	
@OtherScenario4 
Scenario: User should not be able to login with invalid username and password
	Given User is on Techfios login page  
	When User enters password as "abc124"
	When User enters username as "demo2@techfios.com" 
	And User clicks on signin button
	Then User should land on dashboard page	