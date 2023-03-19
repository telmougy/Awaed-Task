Feature: post operation for users
  Scenario: Verify post operation for users working normally
    Given   the user can add new record through post operation
    Then the new record should be returned when performing get operation
