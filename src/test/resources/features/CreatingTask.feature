Feature: Create a task from Activity Stream
  User story:
  As a user I should be able to create new task by clicking on tasks on activity
  stream.

  Background:
    Given I am on the login page
    When I login as a user


  Scenario:User should be able to create new task by clicking on tasks on activity stream.
    When I click on Activity stream
    Then I should be able to see the New Task Window

  @wip
  Scenario: User should be able to upload a file and image or link or add checklist
  regarding to new task.
    When I click on New Task
    And I click on Upload Files
    Then I see four options to upload files
    When I click on Link
    Then Link window should appear
    When I click on Checklist
    Then Checklist window should appear

