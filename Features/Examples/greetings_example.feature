@exampletests
@greetingexample
Feature: greeting example

  Scenario: greeting test
    Given page 'Main Screen' is opened
    Then greeting "" should be displayed