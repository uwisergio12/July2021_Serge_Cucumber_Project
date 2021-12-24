@DbFeature
Feature: Login to techfios login page with data extracted from the database

@DbScenario1 
Scenario: 1 User should be able to login with valid credentials
	Given User is on Techfios login page 
	When User enters "username" from techfios database
	When User enters "password" from techfios database
	And User clicks on "signin" button 
	Then User should land on dashboard page
	And User clicks on "bankCash" button 
	And User clicks on "newAccount" button 
	And User enters "accountTitle" in accounts page 
	And User enters "description" in accounts page 
	And User enters "initialBalance" in accounts page 
	And User enters "accountNumber" in accounts page 
	And User enters "contactPerson" in accounts page 
	And User enters "Phone" in accounts page 
	And User enters "internetBankingURL" in accounts page 
	And User clicks on "submit" button 
	Then User should be able to validate account created successfully