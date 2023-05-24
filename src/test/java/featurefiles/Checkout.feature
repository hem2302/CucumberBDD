Feature: place the order for products

Scenario Outline: Search experience for product search in both home page and offers page

Given user is on GreenCart landing page
When user searched with short name <Name> and extracted actual name of the product
Then user added "3" of the selected product to the cart
And user proceeds to Checkout and validate the <Name> items in the cart page
And verify user had ability enter promo code and place the order
Examples:
|Name|
|Tom|
|Beet|	