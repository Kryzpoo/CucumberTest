@exampletests
@paramsexample
Feature: params example

  Scenario Outline: test with parameters
    Given page 'Payments and Transfers' is opened
    When user presses button "<button>"
    Then element "title" : "<page_title>" should be displayed

    Examples:
      | button                                | page_title                            |
      | Мои шаблоны и автоплатежи             | Мои автоплатежи                       |
      | Транспорт                             | Транспорт                             |
      | Оплата услуг сканированием штрих-кода | Оплата услуг сканированием штрих-кода |