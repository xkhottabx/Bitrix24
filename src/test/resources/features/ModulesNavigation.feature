Feature: Navigation to modules and pages title verification
  User story: As a user, I should be able to see the correct titles
  when I navigate to corresponding modules.

  Background:
    Given I am on the login page
    When I login as a user


  Scenario Outline: Verify module title
    When I click a "<module>"
    Then The title should be "<title>"

    Examples:
      | module          | title                   |
      | Activity Stream | Portal                  |
      | Tasks           | My tasks                |
      | Chat and Calls  | Chat and Calls          |
      | Workgroups      | Workgroups and projects |



