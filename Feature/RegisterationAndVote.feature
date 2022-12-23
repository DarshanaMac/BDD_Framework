Feature:  As a visitor, I want to be able to register in the website So that I can vote for a sport car

Scenario: Successful Login with Valid Credentials
	Given User is on Home Page
	When User Navigate to registration Page
	And User enters registration details
	| loginname   | firstname |lastname|password|confirmpassword|
	| darshana1006 | darshana1006 |konara|User@12345|User@12345|
	
	Then Message displayed Login Successfully


Scenario: Successful Login with Valid Credentials
	Given User is on Home Page
	When User enters valid username and password
	| Username   | Password |
	| darshana | User@12345 |
	And Verify Login Success


Scenario: Successful Login with Valid Credentials and vote
	Given User is on Home Page
	When User enters valid username and password
	| Username   | Password |
	| darshana1000 | User@12345 |
	And Click on Alfa Romeo logo
	And Vote to car