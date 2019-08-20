
Feature: Login
  User story:
  As a user I should be able to log in and see Home Page

  @login
  Scenario: Login as a user
    Given I am on the login page
    When I login as a user
    Then I should be able to see the user name on the Home Page
