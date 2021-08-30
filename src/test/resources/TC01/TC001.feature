Feature: TC001
  Scenario: Validate A Class models price are between £15,000 and £60,000.
    Given The url "https://www.mercedes-benz.co.uk"
    When I select the model, mouse over, click build car and select fuel
      |selectModel|Hatchbacks|
      |mouseOver|A-Class Hatchbacks|
      |click|Build your car|
      |selectFuel|Diesel|
      |saveCarValue|   |
    Then Save the value "£" of the highest and lowest price results in a text file