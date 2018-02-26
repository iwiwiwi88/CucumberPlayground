Feature: Creating a new user on the thedemosite.
 Should allow a user to create new credentials 
 with username and password with more than 4 characters.
 
Scenario: A user can set valid credentials correctly
	Given The user is on user creation page
	And Username and password is set to test and test
	| test | test |
	When The user inputs valid username and password and clicks Save button
	Then The user can see her/his credentials set correctly above the form
	| testiwi | testiwi |
 
Scenario: A user can not use username that is shorter than 4 characters

Scenario: A user can not use password that is shorter than 4 characters

Scenario: A user must input both values to set the credentials