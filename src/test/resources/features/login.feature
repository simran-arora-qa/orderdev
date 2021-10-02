@all @login
Feature: Verify Login

  To verify login functionality
Background:

  Scenario Outline: To verify login functionality - Invalid Credentials
  	Given User Navigates to orderdevURL on "<browser>"
    And Clicks on Login
    And Login Screen Should Appear
  	When User Enters user name as "<invalidUserName>" and password as "<invalidPassword>"
    And Clicks on Sign in Button
    Then An error pop-up should apper with message "<invalidCredentialMessage>"
    And User should not be able to login
    
	Examples:
   		|browser					|invalidUserName					|invalidPassword|invalidCredentialMessage					|
   		|chrome 					|abcd@abcd.abcd						|deff						|Invalid Email address or Password|
   	#	|firefox 					|abcd@abcd.abcd						|deff						|Invalid Email address or Password|
   	#	|internetExplorer |abcd@abcd.abcd						|deff						|Invalid Email address or Password|

  @happyPath  
  Scenario Outline: To verify login functionality - Valid Credentials
  	# Creation new account
  	Given User Navigates to orderdevURL on "<browser>"
  	And Clicks on Login
 		And Login Screen Should Appear
  	And User Clicks on Create an Account
  	And User Account Creation Screen Should Appear
    When User Enters user name as "<firstName>" and last name as "<lastName>"
    And User selects "<region>" from Phone number Region drop down
    And User enters phone number as "<phoneNumber>"
    And User enters email address as "<validUserName>"
    And User enters password as "<validPassword>"
    And User enters referrel code as "<referralCode>"
    And User checks Agree to META terms checkbox
    And Clicks on Create an Account Button
    And User should be navigated to orderdevURL
    And User Closes Delivery Popup
    And User Clicks Logout
    # Tring to login via newly created account
    And Clicks on Login
    When User Enters user name as "<validUserName>" and password as "<validPassword>"
    And Clicks on Sign in Button
    Then User should be navigated to orderdevURL
		
   Examples:
   		|browser|orderdevURL												|validUserName				|validPassword|phoneNumber|region|referralCode|
   		|chrome	|https://orderdev.tastemeta.com/home|abcd@random.abcd.abcd|Abcd1###			|9999999999	|India |						|
   		#|firefox|https://orderdev.tastemeta.com/home|abcd@random.abcd.abcd|Abcd1###			|9999999999	|India |						|
   		