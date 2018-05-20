@api
Feature: Users

  Scenario: Get All Users
  Find All Users
    Given Two users should exist in the system
    When getAllUsers service is invoked
    Then "2" users should exist
