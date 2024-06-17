Feature: Check search functionality of application
  I want to check search functionality of application

  Background: 
    Given User navigates to sigin page
    When User logins to application

  Scenario: User checks error messages on search
    When User checks error messages at search
      | Input    |
      | Sharad M |
      | Jagtap   |
      | ss98899  |

  Scenario: User checks search functionality with valid input
    When User searches valid courses
      | Input    |
      | Cypress  |
      | Java     |
      | Selenium |
      | postman  |
