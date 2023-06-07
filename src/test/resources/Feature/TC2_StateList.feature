
@State
Feature: State module API automation

  @tag1
  Scenario: Verify User get StateList through API
    Given User add headers for to StateList
    When User send "GET" request for StateList endpoint
    Then User verify the Status code is 200
    And User verify StateList response message matches "Tamil Nadu" and save State id
 