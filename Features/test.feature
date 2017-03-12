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


    And user presses button 'HOME'
    And user presses button 'HELP'

    Then template "atm_menu" should be displayed
    Then button "Вернуться в меню" should be displayed
    When user inserts "123d" into field (Touch)
    When user inserts "123d" into field (FDK)
    When user presses 'calendar switcher previous' button
    When user presses 'calendar switcher next' button
    When user waits for timeout "12"
    When user clears insert field by pressing backspace "50" times

    Then check should be displayed
    Then check should contain string ""
    Then element 'region' : "" should be displayed
    Then element 'notes' : "" should be displayed
    Then element "" : "" should be displayed on 'OK' page
    Then element "" : "" should be displayed on 'Total' page
    Then element "" : "" should be displayed on 'Error' page
    Then keyboard should be displayed
    Then greeting "" should be displayed

    Then element "support" : "" should be displayed
    Then element 'timeout screen' should be displayed
    Then element "caption" : "description" should be displayed
    Then log should contain string ""

  @pageloadtests
  Scenario: pageload tests
    Given  page 'Payments and Transfers' is opened
    When user presses button "МТС "
    Then element "caption" : "Номер телефона" should be displayed
    When user inserts "9065552233" into field (Touch)
    When user presses button "Далее"
    When user inserts "125" into field (Touch)