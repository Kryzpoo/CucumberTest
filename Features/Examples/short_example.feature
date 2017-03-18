@exampletests
@shortexample
Feature: short example

  @ignored
  Scenario: short test
    Given page 'Payments and Transfers' is opened
    When user presses button "МТС "
    Then element "caption" : "Номер телефона" should be displayed
    When user inserts "9065552233"
      And user presses button "Далее"
        Then element "description" : "Сумма платежа" should be displayed
    When user inserts "125"
      And user presses button "Далее"
        Then element "caption" : "Платёж подготовлен" should be displayed
    When user presses button "Показать баланс"
      And user presses button "Оплатить"
    When user presses button "Напечатать чек"
      And user presses button "ОК" on check
      And user presses button 'HOME'


  Scenario: broken short test
    Given page 'Payments and Transfers' is opened
    When user presses button "МТС "
    Then element "caption" : "Номер телефона" should be displayed
    When user inserts "9065552233"
    And user presses button "Далее"
    Then element "description" : "Сумма платежа" should be displayed
    When user inserts "125"
    And user presses button "Далее"
    And user presses button "Редактировать"
      Then element "caption" : "Проверьте данные платежа" should be displayed
    When user presses button "Завершить обслуживание"