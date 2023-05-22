Feature: Search and place the order for products

Scenario: Search experience for product search in both home page and offers page

Given user is on GreenCart landing page
When user searched with short name "Tom" and extracted actual name of the product
Then user searched for "Tom" shortname in offers page 
And validate product name in offers page matches with the landing page