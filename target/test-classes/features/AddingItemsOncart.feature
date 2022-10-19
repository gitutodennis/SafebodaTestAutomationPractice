Feature: Add items on Cart

  Background:
    Given User is on the Login Page
    When user enters username "techsystems@safeboda.com"
    And user enter valid password "Safeboda123$"
    And user click the Login Button
    Then User gets the Title of the Page
    And Page Title should be "My account - My Store"

  @ItemsOnCart
  Scenario Outline: Items on Cart
    Given User is on the Landing Page
    When User has clicked on the Women Section
    And User Click on the Tops Menu on the Dashboard
    And User clicks on the TShirt Section
    And User is on Catalog and selects LARGE
    And  User Selects color ORANGE
    And User selects CASUAL Style
#    Then Dresses are filtered using size (Large), color(Orange) and Style (Casuals)
    And The product is displayed and User clicks on More
    And User enters the Quantity "<quantity>"
    And user enters the Size
    And User selects the color
    And User Adds the Items to the Cart
    Then The color and size should be should be  "Orange, L"
    And The Quantity is "3"
    And the Shipping Cost is "$2.00"
    And The TOTAL COST is "$51.53"
    And The quantity , size,color, total product cost, shipping cost, total cost are displayed on the Console
    And User Proceeds to Checkout
    Examples:
      | quantity |
      | 3        |

