
  @City
Feature: City module API automation


  Scenario Outline: 
    Verify User get CityList through API

    Given User add headers for to CityList
    When User add request body to get cityid "<stateId>"
    And User send "POST" request for CityList endpoint
    Then User verify the Status code is 200
    And User verify CityList response message matches "Chennai" and save City id

    Examples: 
      | stateId |
      |      35 |
