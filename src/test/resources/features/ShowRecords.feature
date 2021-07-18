@wip
Feature: show records functionality

  Scenario: Verify default value on Book Management Page
    Given user is on the login page
    And user login as Librarian
    When user clicks on Users link
    Then Show records default value should be 10
    And show records should have following options
    |5|
    |10|
    |15|
    |50|
    |100|
    |200|
    |500|



