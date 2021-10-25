@GetRequestForColourLoversAPI
Feature: Get request for numViews values
  Make a GET request to colourlovers api http://www.colourlovers.com/api/patterns 
  and write an assertion for <numViews> (from response) to be greater than 4000
  
  @GetValuesOfnumViews
  Scenario Outline: numView is greater than 4000
    Given I want to go to <colourLovers> API
    When I send <Get> request for any <attribute> 
    Then I validate the outcome to be more than this <value>
 
  Examples:  
  |colourLovers |Get |attribute|value|
   |"http://www.colourlovers.com/api" |"/patterns"|"patterns.pattern.numViews"|4000|

