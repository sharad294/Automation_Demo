Feature: Check login functionality of OrangeHrm
  I want to check login functionality of OrangeHrm

  Background: 
    Given User navigates to sigin page

  Scenario Outline: Check the login with invalid credentials validations
    When User enters username "<unm>"
    And User clicks on login button
    Then User closed browser

    Examples: 
      | unm       |
      | King      |
      | sharad    |
      | sharad123 |
      | Sharad    |        
      |           |
      |           |        

  Scenario: User checks error messages on login page
    When User checks error messages at email
      | Email                   | Message                              |
      | Sharad M                | Please provide a valid email address |
      |                     123 | Please provide a valid email address |
      | sharadjagtap&@gmail.com | Please provide a valid email address |
      
 Scenario: Verify labels on login page
 		When Logo label "Rahul Shetty Academy" on login page
 		And Login with label "Login" on login page
 		And Email with label "Email" on login page
 		And Password with label "Password" on login page
 		And Remember me with label "Remember Me" on login page
 		And Forgot password with label "Forgot Password" on login page
 		And Need an account with label "Need an account? Sign Up" on login page
 		And Sign up with label "Sign Up" on login page 		

  Scenario: User logins with valid credentials
    When User logins to application
    Then User is on dashboard page
