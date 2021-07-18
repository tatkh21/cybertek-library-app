
Feature:Library app login feature
  User Story:
  As a user I should be able to login with valid credentials
  Accounts are: librarian, student

  Background: Assuming user is on the login page
    Given user is on the login page

  Scenario: Login as librarian
    When user enters librarian username
    And user enters librarian password
    And clicks the singing button
    Then user should see the dashboard

    Scenario: Login as Student
      When user enters student username
      And user enters student password
      And clicks the singing button
      Then user should see Book Management

