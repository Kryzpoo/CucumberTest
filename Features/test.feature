@alltests
@smoketests
@browsertests
Feature: test

  @ignored
  Scenario: test1
    Given page 'Payments and Transfers' is opened
    When user presses button "Товары и услуги"
    When user presses button "Меню"
    When user presses button "Мои шаблоны и автоплатежи"
    When user presses button "Подключить автоплатеж"


    And user presses button HOME
    And user presses button HELP

    Then template should be an "atm_menu"
    Then button "Вернуться в меню" should be displayed
    When user inserts "123d" into field (Touch)
    When user inserts "123d" into field (FDK)
    When user presses 'calendar switcher previous' button
    When user presses 'calendar switcher next' button
    When user waits for timeout "12"


    Then user should see check
    Then user should see keyboard
    Then element "region" : "" should be displayed
    Then element "" : "" should be displayed on error page  //class: report_caption, report_description
    Then element on TOTAL should be
    Then user should see keyboard

    Then element "support" : "" should be displayed
    Then element 'timeout screen' should be displayed
    Then element "caption" : "description" should be displayed


  Scenario: long test
    Given page 'Payments and Transfers' is opened
    When user presses button "МТС "
    Then element "caption" : "Номер телефона" should be displayed
      And element "title" : "Оплата услуг оператора мобильной связи" should be displayed
    When user inserts "906555" into field (Touch)
      Then element "description" : "Пожалуйста, укажите ровно 10 цифр, начиная с кода города (без 8). Например, 9023219867." should be displayed
      When user presses button "Далее"
        Then template should be an "atm_input_phone"
    When user inserts "2233" into field (Touch)
      And user waits for timeout "50"
      Then element 'timeout screen' should be displayed
    When user presses button "Да"
      And user presses button "Далее"
      Then element "caption" : "Сумма" should be displayed
      And element "description" : "Сумма платежа" should be displayed
      And element "title" : "Оплата услуг оператора мобильной связи" should be displayed
    When user inserts "125" into field (Touch)
    And user presses button "Далее"
      Then template should be an "atm_total"
      And element "caption" : "Платёж подготовлен" should be displayed
    When user presses button "Показать баланс"
      And user presses button "Оплатить"
      Then template should be an "atm_ok"
    When user presses button "Напечатать чек"
      And user presses button "ОК" on check
      And user presses button HOME


  Scenario: short test
    Given page 'Payments and Transfers' is opened
    When user presses button "МТС "
    When user inserts "906555" into field (Touch)
    When user presses button "Далее"
    When user inserts "2233" into field (Touch)
    And user presses button "Далее"
    When user inserts "125" into field (Touch)
    And user presses button "Далее"
    And element "caption" : "Платёж подготовлен" should be displayed
    When user presses button "Показать баланс"
    And user presses button "Оплатить"
    When user presses button "Напечатать чек"
    And user presses button "ОК" on check
    And user presses button HOME

  Scenario: failed test
    Given page 'Payments and Transfers' is opened
    When user presses button "МТС"
    When user inserts "906555" into field (Touch)
    When user presses button "Далее"
    When user inserts "2233" into field (Touch)
    And user presses button "Далее"
    When user inserts "125" into field (Touch)
    And user presses button "Далее"
    And element "caption" : "Платёж подготовлен" should be displayed
    When user presses button "Показать баланс"
    And user presses button "Оплатить"
    When user presses button "Напечатать чек"
    And user presses button "ОК" on check
    And user presses button HOME

  Scenario Outline: test with parameters
    Given page 'Payments and Transfers' is opened
    When user presses button "<button>"
    Then element "title" : "<page_title>" should be displayed

  Examples:
    | button                                | page_title                            |
    | Мои шаблоны и автоплатежи             | Мои автоплатежи                       |
    | Транспорт                             | Транспорт                             |
    | Оплата услуг сканированием штрих-кода | Оплата услуг сканированием штрих-кода |