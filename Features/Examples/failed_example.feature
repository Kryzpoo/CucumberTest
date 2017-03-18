@exampletests
@failedexample
Feature: failed example

  Scenario: failed test
    Given page 'Payments and Transfers' is opened
    When user presses button "NO_BUTTON"
    When user inserts "906555"
    When user presses button "Далее"
    When user inserts "2233"
    And user presses button "Далее"
    When user inserts "125"
    And user presses button "Далее"
    And element "caption" : "Платёж подготовлен" should be displayed
    When user presses button "Показать баланс"
    And user presses button "Оплатить"
    When user presses button "Напечатать чек"
    And user presses button "ОК" on check
    And user presses button 'HOME'