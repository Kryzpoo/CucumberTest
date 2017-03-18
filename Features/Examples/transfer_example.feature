@exampletests
@transferexample
Feature: transfer example

  Scenario: transfer test
    Given page 'Payments and Transfers' is opened
    When user presses button "Переводы"
      Then element with text "Между своими счетами" should be displayed
    When user presses button "Между своими счетами"
      Then element "caption" : "Списать с" should be displayed
    When user presses button "Electron"
      And user presses button "Далее"
        Then element "caption" : "Зачислить на" should be displayed
    When user presses button "Maestro"
      And user presses button "Далее"
        Then element "caption" : "Сумма зачисления" should be displayed
    When user presses button "2"
      Then element with text "2482" should be displayed
    When user presses button "Далее"
      Then element "caption" : "Перевод подготовлен" should be displayed
      And element with text "Обратите внимание! Вы можете выполнить операцию без подтверждения в Контактном центре на сумму до 50 000,00 руб и с подтверждением на сумму до 500 000,00 руб." should be displayed
    When user presses button "Перевести"
      Then element "caption" : "Операция успешно завершена" should be displayed on 'OK' page
    When user presses button "Напечатать чек"
      Then check should be displayed
      Then check should contain string "идентификатор операции"
    When user presses button "Ошибка" on check
      Then element "description" : "Не удалось распечатать чек. Вы можете распечатать чек позднее, выбрав нужную операцию в разделе «История операций»" should be displayed on 'OK' page