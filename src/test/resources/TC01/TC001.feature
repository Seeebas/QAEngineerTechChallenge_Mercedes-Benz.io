Feature: TC001
  Scenario: Validate A Class models price are between £15,000 and £60,000.
    Given The url and the browserName
    |url|https://www.mercedes-benz.co.uk/|
    |browserName|Firefox|
    When I select the model, mouse over, click build car and select fuel
      |selectModel|Hatchbacks|
      |mouseOver|A-Class|
      |click|Build your car|
      |scrollTo|Fuel|
      |selectFuel|Diesel|
    Then Save the value £ of the highest and lowest price results in a text file
      |maxValueToValidate|60.000|
      |minValueToValidate|15.000|