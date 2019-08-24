Feature: HR app db and UI data verification
    @HRAppDB
  Scenario: Department data UI an DB verification
    Given I am on Dept page
    When Search for dep_id "<number>"
    And I query Db with SQL "SELECT department_name, manager_id, location_id from departments where department_id=10"
    Then UI data and DB data must match


