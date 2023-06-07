@Login
Feature: Login module API Automation

  Scenario: Get User Logtoken from Login Endpoint
    Given User add header
    When User add base Authentication for login
    And User send "POST" request for login endpoint
    Then User Verify the status code is 200
    And User verify the login response body firstName present as "Ashok" and get the logtoken
