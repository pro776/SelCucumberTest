#Author: Pranoy Singha
Feature: feature to test login functionality

  Scenario: Check Login is successful with valid credentials
    Given user is on the Login page
    When user enters username and password
    And clicks submit
    Then user is redirected to the account page
#   Scenario Outline: Check Login is successful with valid credentials
#   Given user is on the Login page
#    When user enters <username> and <passsword>
#    And clicks submit
#    Then user is redirected to the home page
#
#    Examples: 
#      | username | password |
#      | user1    | pass1    |
#      | user2    | pass2    |
