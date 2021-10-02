@all @changePassword
Feature: Verify Change Password

  To verify Change Password functionality
  @happyPath      
  Scenario Outline: To verify Change Password functionality
    # Creating new Account
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
    # Logging in via new account
    And Clicks on Login
    When User Enters user name as "<validUserName>" and password as "<validPassword>"
    And Clicks on Sign in Button
    Then User should be navigated to orderdevURL
    And User Closes Delivery Popup
		When User Clicks on Settings
		# Changing Password
    And User Clicks on Change Password
    And User Enters existing password as "<validPassword>"
    And User Enters new password as "<newPassword>" and confirm password as "<confirmPassword>"
    And User Clicks on Confirm
    Then Password Changed Popup Should Appear
    # Password Changed Pop-up appeared
    And User Clicks Logout
    # Re-verifing by loggin in with new password
    And Clicks on Login
    When User Enters user name as "<validUserName>" and password as "<newPassword>"
    And Clicks on Sign in Button
    Then User should be navigated to orderdevURL
    
   Examples:
   		|browser|orderdevURL												|validUserName				|validPassword|phoneNumber|region|referralCode|newPassword|confirmPassword|
   		|chrome	|https://orderdev.tastemeta.com/home|abcd@random.abcd.abcd|Abcd1###			|9999999999	|India |  					|Abcd2###		|Abcd2###				|