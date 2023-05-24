Feature: Search and place the order for products

Scenario Outline: Search experience for product search in both home page and offers page

Given user is on GreenCart landing page
When user searched with short name <Name> and extracted actual name of the product
Then user searched for <Name> shortname in offers page 
And validate product name in offers page matches with the landing page

Examples:
|Name|
|Tom|
|Beet|