Feature: Login
	As user, i want to be able to login into revature
	under different roles with username and password
	
	Scenario: Login as Developer
		Given user is on the login page
		Then user logs in as Developer
		And user verifies that 'Dashboard' page subtitle is displayed