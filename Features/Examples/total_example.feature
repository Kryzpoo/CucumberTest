@exampletests
@totalexample
Feature: total example

  Scenario: total test
    Given page 'Payments and Transfers' is opened
    When user presses button "МТС "
    Then element "caption" : "Номер телефона" should be displayed
    When user inserts "9065552233"
      And user presses button "Далее"
    When user inserts "125"
      And user presses button "Далее"
      And element "caption" : "Платёж подготовлен" should be displayed
    When user presses button "Показать баланс"
    Then element "Наименование" : "МТС" should be displayed on 'Total' page
    And element "Списать со счета" : " 4279 99** **** 7759" should be displayed on 'Total' page
    And element "Списать со счета" : " 4279 99** **** 6759" should be displayed on 'Total' page

