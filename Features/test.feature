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

  @pageloadtests
  Scenario: pageload tests
    Given  page 'Payments and Transfers' is opened
    When user presses button "МТС "
    Then element "caption" : "Номер телефона" should be displayed
    When user inserts "9065552233" into field (Touch)
    When user presses button "Далее"
    When user inserts "125" into field (Touch)