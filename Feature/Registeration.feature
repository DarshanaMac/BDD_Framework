Feature: Login Action

#Scenario: Successful Login with Valid Credentials
#	Given User is on Home Page
#	When User Navigate to registration Page
#	And User enters registration details
#	And User password should contains capital simple and numbers
#	Then Message displayed Login Successfully


Scenario: Successful Login with Valid Credentials
	Given User is on Home Page
	When User enters valid username and password
	| Username   | Password |
	| darshana | User@12345 |
	And Verify Login Success
	
	
	
#Scenario: Successful Login with Valid Credentials
#	Given User is on Home Page
#	When User enters valid username and password
#	When Click on Alfa Romeo logo
#	Then Verify URL contains make keyword