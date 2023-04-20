Feature: Testing login account feature

	Background: User is logged in
		Given user should be on login page

	@Edubridge
	Scenario: Test login account with valid credentials
		When user enter valid username "satishgangwani19" and valid password "Sati1234$"
		Then user should be able to login
		And close the browser
		
	Scenario Outline: Test login account with invalid credentials
		When user enter the username <un> and password <pw>
		Then user should not be able to login
		And close the browser
	Examples:
	|un|pw|
	|"satishgangwani19"|"Sati1234"|
	|"satish4572897"|"Sati1234$"|
	|"satish4572897"|"Sati1234"|
	