Feature: Check profile feature functionality
  I want to check profile functionality

  Background: 
    Given User navigates to sigin page
    When User logins to application

  Scenario: Check the labels of profile screen
	  When User is on dashboard page
	  Then Profile name with label "Sharad Jagatap" on profile page
	  Then User zooms page
	  Then User zoom outs page
  
  Scenario: Verify list of profile pop up
    When User clicks on profile name
    Then User verifies profile pop up list
      | list                     |
      | Refer a friend           |
      | Edit Profile             |
      | Manage Subscriptions     |
      | Add / Change Credit Card | 
      | Address                  |
      | Contact                  |
      | Log Out                  |
