@exampletests
@all_steps_touch_example
Feature: all steps touch example

  Scenario: all steps touch example
    Given page 'Payments and Transfers' is opened
    When user presses button "ЕИРЦ"
      Then keyboard should be displayed
      And element "caption" : "Код плательщика" should be displayed
    When user presses button "Далее"
      Then element "caption" : "Код плательщика" should be displayed
    When user inserts "1234567890"
      Then element with text "1234567890" should be displayed
    When user clears insert field by pressing backspace "7" times
      Then element with text "1234567890" should not be displayed
      And element with text "123" should be displayed
    When user inserts "4567890"
    When user waits for timeout "40"
      Then element 'timeout screen' should be displayed
      And element 'support' : "КОНТАКТНЫЙ ЦЕНТР - 900, 8 (800) 555-55-50" should be displayed
    When user presses button "Да"
      Then element 'notes' : "Введите код плательщика - 10 цифр" should be displayed
    And user presses button "Далее"
    Then template "atm_input_month" should be displayed
    When user presses 'calendar switcher next' button
      Then element with text "Март 2018" should be displayed
    When user presses 'calendar switcher previous' button
      And user presses 'calendar switcher previous' button
        Then element with text "Март 2016" should be displayed
    When user presses button "Май"
      Then element with text "Май 2016" should be displayed
    When user presses button "Далее"
      Then element with text "Вклады" should be displayed
    When user scrolls down "1" times
      And user scrolls up "1" times
      And user scrolls down "1" times
      And user presses button "40817810838123731213"
      And user presses button "Далее"
        Then scrollbar should be displayed
        And element "Информация по получателю средств" : "В адрес этого поставщика Вы можете оплатить улуги ЖКХ по ЕПД" should be displayed on 'Total' page
        And element "Период оплаты" : "11/2013" should be displayed on 'Total' page
    When user presses button "Меню"
      Then element 'region field' : "Мурманская область г Мурманск" should be displayed
    When user presses button "Оплата услуг сканированием штрих-кода"
      Then element "title" : "Оплата услуг сканированием штрих-кода" should be displayed
    When user presses button "Назад"
      Then element with text "Поиск услуг и организаций" should be displayed
    When user presses button "Поиск услуг и организаций"
      Then element "description" : "Введите наименование услуги или организации, ИНН или номер расчетного счета" should be displayed
      And keyboard should be displayed
    When user inserts "мос"
      And user presses button "Найти"
        Then element with text "ЕИРЦ (нал со сдачей)" should not be displayed
    When user presses button 'HELP'
      Then element 'help_notes' : "Поиск может быть выполнен при вводе минимум 3-х символов" should be displayed
    When user presses button 'HELP'
      Then element with text "Поиск может быть выполнен при вводе минимум 3-х символов" should not be displayed
    When user presses button "Меню"
      Then element with text "Переводы" should be displayed
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
    When user presses button "Платежи и переводы"
      Then element with text "История операций" should not be displayed
    When user presses button "Транспорт"
      Then element "caption" : "Выберите поставщика" should be displayed
    When user presses button "Парковочные технологии"
      Then element "caption" : "Сервис временно недоступен. Ошибка 216." should be displayed on 'Error' page
      And element "description" : "Повторите операцию позже или обратитесь в службу поддержки" should be displayed on 'Error' page
    When user waits for timeout "10"
      And page 'Main Screen' is opened
        Then greeting "Здравствуйте, САТУРН ПЛАНЕТОВИЧ" should be displayed