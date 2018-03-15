Feature: Login page on the thedemosite. 
	Should allow a user to login correctly to the page.

@positive 
Scenario: A user can login with valid credentials correctly 
	Given The user is on CreateUser page 
	And Username and password is set to: 
		| username 	| password 	|
		| testiwi   | testiwi   |
	And LP The user is on Login page 
	When LP The user inputs username and password:
		| username | password |
		| testiwi  | testiwi  |
	And LP The user clicks Login button
	Then The Success message appears
	
@negative 
Scenario: A user can not login with invalid username 
	Given The user is on CreateUser page 
	And Username and password is set to: 
		| username 	| password 	|
		| testiwi   | testiwi   |
	And LP The user is on Login page 
	When LP The user inputs username and password: 
		| username 	   | password  |
		| testinvalid  | testiwi   |
	And LP The user clicks Login button
	Then The Failure message appears
	
@negative 
Scenario: A user can not login with invalid password 
	Given The user is on CreateUser page 
	And Username and password is set to: 
		| username 	| password 	|
		| testiwi   | testiwi   |
	And LP The user is on Login page 
	When LP The user inputs username and password:  
		| username | password    |
		| testiwi  | testinvalid |
	And LP The user clicks Login button
	Then The Failure message appears
	