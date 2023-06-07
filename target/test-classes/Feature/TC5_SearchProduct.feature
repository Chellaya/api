
@Product
Feature: Grocery module API Automation

  Scenario Outline: 
    Verify  user search Product  through API

    Given User add header for search products
    When User add request body for search Product "<productName>"
    And User send "POST" request for searchProduct endpoint
        Then User Verify the status code is 200
    And User verify the searchProdct response message matches "OK"

    Examples: 
      | productName |
      | Nuts |
