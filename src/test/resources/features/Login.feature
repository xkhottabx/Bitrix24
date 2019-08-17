@login @bit-001
Feature: Login
  User story:
  As a user I should be able to create a task from activity stream

  @smoke
  Scenario: Login as a user
    Given I am on the login page
    When I login as a 'user'
    Then I should be able to see the 'Portal' page