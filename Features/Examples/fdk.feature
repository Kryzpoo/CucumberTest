@fdkexampletests
@fdkexample
Feature: fdk example

  Scenario: fdk test
    Given page 'Payments and Transfers' is opened
    When user presses button "МТС"
    Then element "caption" : "Номер телефона" should be displayed
    When user inserts "9065552233"
    And user presses button "Далее"
      Then element "caption" : "Сумма" should be displayed
      And element "description" : "Сумма платежа" should be displayed
    When user inserts "125"
    And user presses button "Ввести заново"
    And user presses button "Далее"
    Then element "caption" : "Платёж подготовлен" should be displayed
    And element "Наименование" : "МТС" should be displayed on 'Total' page
    And element "Услуга" : "Мобильная связь" should be displayed on 'Total' page
    And element "Комиссия" : "0" should be displayed on 'Total' page
    When user waits for timeout "50"
      Then element 'timeout screen' should be displayed
    When user presses button "Да"
      Then element "caption" : "Платёж подготовлен" should be displayed
    When user presses button "Оплатить"
      Then element "caption" : "Операция успешно завершена" should be displayed on 'OK' page
    When user presses button "Напечатать чек"
      Then check should be displayed
    When user presses button "ОК" on check
      Then element "caption" : "Операция успешно завершена" should be displayed on 'OK' page
    When user presses button "Платежи и переводы"
      Then element "caption" : "Платежи и переводы" should be displayed