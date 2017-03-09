@exampletests
Feature: failed example

  Scenario Outline: test with parameters
    Given page 'Payments and Transfers' is opened
    When user presses button "<button>"
    Then element "caption" : "<page_caption>" should be displayed

    Examples:
      | button                                | page_caption                          |
      | Мои шаблоны и автоплатежи             | Мои автоплатежи                       |
      | Транспорт                             | Транспорт                             |
      | Оплата услуг сканированием штрих-кода | Оплата услуг сканированием штрих-кода |