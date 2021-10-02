@all @userRegistration
Feature: Verify User Registration

  To verify User Registration functionality

  @happyPath  
  Scenario Outline: To verify User Account Creation functionality
    # Creating new account
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
    Then User should be navigated to orderdevURL
    And Delivery Address pop up should appear
    
    Examples:
   		|browser|orderdevURL												|validUserName				|validPassword|phoneNumber|region|referralCode|
   		|chrome	|https://orderdev.tastemeta.com/home|abcd@random.abcd.abcd|Abcd1###			|9999999999	|India |						|
   		#|firefox|https://orderdev.tastemeta.com/home|abcd@random.abcd.abcd|Abcd1###			|9999999999	|India |						|
   		