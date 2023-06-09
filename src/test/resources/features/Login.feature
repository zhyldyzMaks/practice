Feature: As an admin, user should be able to login

  Background:
    Given User navigates to the webpage and user validates the title 'Login'

  Scenario Outline: Happy Path Login
    When User enters valid username and valid password
    And User chooses location '<location>'
    And User clicks the login button
    Then User validates the header contains text '<user>'
    And User validates the header which contains text '<location>'
    And User clicks on logout button
    Examples:
      | location          | user  |
      | Inpatient Ward    | admin |
      | Isolation Ward    | admin |
      | Laboratory        | admin |
      | Outpatient Clinic | admin |
      | Pharmacy          | admin |
      | Registration Desk | admin |


  Scenario Outline: User should not be able to login with valid username but invalid password
    When User enters username '<username>' and password '<password>'
    And User chooses a location 'Inpatient Ward' and clicks the login button
    Then User validates the error message 'Invalid username/password. Please try again.'
    Examples:
      | username | password  |
      | Admin    | blablabla |
      | ahmet    | Admin123  |
      | ahmet    | blablabla |
      | Admin    |           |
      |          | Admin123  |
      |          |           |


  #Scenario: User should not be able to login with invalid both username and password
  #Scenario: User should not be able to login with valid username but no password
  #Scenario: User should not be able to login with no username but valid password
  #Scenario: User should not be able to login with no both username and password