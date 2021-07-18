
Feature:Library app login feature
  User Story:
  As a user I should be able to login with valid credentials
  Accounts are: librarian, student

  Background: Assuming user is on the login page
    Given user is on the login page

  Scenario: Login as librarian
    When user enters "librarian13@library" username and "9rf6axdD" password
    Then user should see the dashboard
    And there should be 5564 users

  Scenario: Login as Student
    When user enters "student11@library" username and "tScBPCUr" password
    Then user should see Book Management

