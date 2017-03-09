@exampletests
@ignored
Feature: test

  Scenario Outline: params test
    Given first val "<a>" and second val "<b>"
    When i sum values
    Then i get "<result>"

    Examples:
      | a   | b   | result |
      | 1.0 | 2.0 | 3.0    |
      | 7.0 | 8.0 | 15.0   |

  Scenario: simple test
    Given something
    When i do something
    Then i see something

  Scenario: use browser
    Given opened 'Payments and Transfers' page
    Given opened 'Main Screen' page
    When I press button: "some"
    And I press button: "hello"
    When one
    Then I should see "notes": "caption"

  Scenario: test

    Given opened 'Payments and Transfers' page
    When I press button "Товары и услуги"
    Given opened 'Payments and Transfers' page
    When I press button "Демонстрация платежей наличными и картой"
    Given opened 'Payments and Transfers' page
    When I press button "Категория содержащая баги заведенные в JIRA"
    Given opened 'Payments and Transfers' page
    When I press button "Мои шаблоны и автоплатежи"
    Given opened 'Payments and Transfers' page
    When I press button "Карты, вклады и кредиты"
    Given opened 'Payments and Transfers' page
    When I press button "Платежи и переводы"
    Given opened 'Payments and Transfers' page
    When I press button "История операций"
    Given opened 'Payments and Transfers' page
    When I press button "ПОДАРИ ЖИЗНЬ"
    Given opened 'Payments and Transfers' page
    When I press button "Оплата услуг сканированием штрих-кода"
    Given opened 'Payments and Transfers' page
    When I press button "[LoadTest-9] Мобильная связь"
    Given opened 'Payments and Transfers' page
    When I press button "Категория с TEST-кейсами"
    Given opened 'Payments and Transfers' page
    When I press button "[LoadTest-1] Оплата коммунальных услуг"
    Given opened 'Payments and Transfers' page
    When I press button "Демонстрация платежей наличными и картой"
    Given opened 'Payments and Transfers' page
    When I press button "Категория содержащая баги заведенные в JIRA"
    Given opened 'Payments and Transfers' page
    When I press button "Категория содержащая тесты ИНТЕРФЕЙСА"
    Given opened 'Payments and Transfers' page
    When I press button "Описание категории #7"