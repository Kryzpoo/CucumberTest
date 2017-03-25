@exampletests
@greetingexample

Feature: greeting example

  Scenario: greeting test
    Given page 'Main Screen' is opened
    Then greeting "Здравствуйте, САТУРН ПЛАНЕТОВИЧ" should be displayed
    And element with text "Завершить обслуживание" should be displayed