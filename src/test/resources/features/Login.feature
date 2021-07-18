
Feature:Library app login feature
  User Story:
  As a user I should be able to login with valid credentials
  Accounts are: librarian, student

  Background: Assuming user is on the login page
    Given user is on the login page

  Scenario: Login as librarian
    When user login as Librarian
    Then user should see the dashboard

    Scenario: Login as Student
      When user login as Student
      Then user should see Book Management

