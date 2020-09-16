#Author: Pranoy Singha
Feature: feature to test error identification in FB register process

  Scenario: Check user is redirected to register page
    Given User is on FB home page
    When User clicks on the "Create New Account" button
    Then User is redirected to Register page

  Scenario Outline: Check if Error is prompted with invalid data
    Given User is at the register page
    When User enters "<First Name>", "<Surname>", "<Mobile number or email address>", "<New Password>", "<Day>", "<Month>", "<Year>" and "<Gender Value>"
    And User clicks the "Sign Up" button
    Then User should capture the error message if any

    Examples: Sign Up data
      | First Name | Surname | Mobile number or email address | New Password | Day | Month | Year | Gender Value |
      | Pranoy     | Singha  | mail@mail@mail.com             | pass1        |   1 |     2 | 1996 |            1 |
      |            | Singha  |                                | pass1        |   1 |     2 | 1996 |            1 |
      | Pranoy     |         | hello world                    | password     |   1 |     2 | 1996 |            1 |
      |       1234 |    5678 |                           0000 | abcd         |   1 |     2 | 1997 |            2 |
      | user3      | pass3   | abcd                           | pass3        |   1 |     2 | 1998 |            2 |
