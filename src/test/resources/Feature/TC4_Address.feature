@Address
Feature: Address module API Automation

  Scenario Outline: Verify add user address to the application through API
    Given User add header and Bearer Authorization for accessing address endpoint
    When User add request body for add new address  "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<address_type>"
    And User send "POST" request for addUserAddress endpoint
    Then User Verify the status code is 200
    And User verify the addUserAddress response message matches "Address added successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address            | address_type |
      | Akash      | Khundra   | 1234567898 | apartment |    33 | 3378 |     101 |  202020 | 64/63 partap nagar | home         |

  Scenario Outline: Verify Update user address to the application through API
    Given User add header and Bearer Authorization for accessing address endpoint
    When User add request body for add update address  "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<address_type>"
    And User send "PUT" request for updateUserAddress endpoint
    Then User Verify the status code is 200
    And User verify the updateUserAddress response message matches "Address updated successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address | address_type |
      | Ashok      | chellaya  | 7401570806 | VK        |    35 | 3659 |     101 |  606202 | Chennai | home         |

  Scenario Outline: Verify Get User Address To The Appliation Through API
    Given User add header and Bearer Authorization for accessing address endpoint
    And User send "GET" request for getUserAddress endpoint
        Then User Verify the status code is 200
        And User verify the GetUserAddress response message matches "OK"
    

  Scenario Outline: Verify Delete user address to the application through API
    Given User add header and Bearer Authorization for accessing address endpoint
    When User add request body for delete address  "<address_id>"
    And User send "DELETE" request for deleteUserAddress endpoint
    Then User Verify the status code is 200
    And User verify the  response message matches "Address Deleted successfully"

    Examples: 
      | address_id |
      |       1774 |
