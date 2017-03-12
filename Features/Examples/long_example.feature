@exampletests
@longexample
Feature: long example

  Scenario: long test
    Given page 'Payments and Transfers' is opened
    When user presses button "МТС "
    Then element "caption" : "Номер телефона" should be displayed
      And element "title" : "Оплата услуг оператора мобильной связи" should be displayed
    When user inserts "906555"
      Then element "description" : "Пожалуйста, укажите ровно 10 цифр, начиная с кода города (без 8). Например, 9023219867." should be displayed
    When user presses button "Далее"
    Then template "atm_input_phone" should be displayed
    When user inserts "2233"
      And user waits for timeout "50"
        Then element 'timeout screen' should be displayed
    When user presses button "Да"
      And user presses button "Далее"
        Then element "caption" : "Сумма" should be displayed
        And element "description" : "Сумма платежа" should be displayed
        And element "title" : "Оплата услуг оператора мобильной связи" should be displayed
    When user inserts "125"
      And user presses button "Далее"
        Then template "atm_total" should be displayed
        And element "caption" : "Платёж подготовлен" should be displayed
    When user presses button "Показать баланс"
      And user presses button "Оплатить"
        Then template "atm_ok" should be displayed
    When user presses button "Напечатать чек"
      And user presses button "ОК" on check
      And user presses button 'HOME'