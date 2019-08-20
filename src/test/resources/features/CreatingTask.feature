Feature: Create a task from Activity Stream
  User story:
  As a user I should be able to create new task by clicking on tasks on activity
  stream.



  Scenario:User should be able to create new task by clicking on tasks on activity stream.
    Given I am on the login page
    When I login as a user
    And I click on New Task
    Then I should be able to see the New Task Window

  @wip
  Scenario: User should be able to upload a file and image or link or add checklist
  regarding to new task.
    Given I am on the login page
    When I login as a user
    And I click on New Task
    When I click on Upload Files
    Then I see four options to upload files