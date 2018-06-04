@api
Feature: Users

  Scenario: Get All Users
  Find All Users
    Given Two users should exist in the system
    When getAllUsers service is invoked
    Then "2" users should exist

  @dropUsers
  Scenario: Adding User example
    Given User details given
      | FirstName | LastName | State |
      | Java      | OOP      | TX    |
      | .Net      | MVC      | VA    |
      | PHP       | HTML     | DC    |
    When getAllUsersExceptDefaultData service is invoked
    Then user below should exist
      | FirstName | LastName | State |
      | Java      | OOP      | TX    |
      | .Net      | MVC      | VA    |
      | PHP       | HTML     | DC    |
