Feature: Use the website to find restaurants and order food

 
  Scenario: Search for restaurants in an area 
    Given I want food in AR51 1AA
    When I search for restaurants in AR51 1AA
    Then I should see some restaurants in AR51 1AA
    And close window
    
  Scenario: Choose the Indian restaurant option from the All Cuisines A-Z from left side Menu
    Given I want food in AR51 1AA
    When I search for restaurants in AR51 1AA
    Then I should see some restaurants in AR51 1AA
    When I click View more chevron from the All Cuisines A-Z from left side Menu
    Then I should see all the Cuisines list
    When I choose and click Indian restaurant 
    Then I should see Indian restaurants list
    And close window
    
  Scenario: Choose one Indian restaurant and proceed order until Go to Payment section
    Given I want food in AR51 1AA
    When I search for restaurants in AR51 1AA
    Then I should see some restaurants in AR51 1AA
    When I click View more chevron from the All Cuisines A-Z from left side Menu
    Then I should see all the Cuisines list
    When I choose and click Indian restaurant 
    Then I should see Indian restaurants list
    When I choose Nitin’s Test Restaurant
    Then I should see Nitin’s Test Restaurant navigation page with Menu
    When I click on Menu Items
    Then I should see  Add to order window
    When I click Add to order button
    Then I should see the selected items are added in Your Order section
    When I click Go to Payment button
    Then I should see the page is navigated to Checkout as a guest section
    And close window
    