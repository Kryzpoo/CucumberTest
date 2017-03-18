Структура и требования
    Подробнее в гугле: язык gherkin
    Файл должен иметь расширение .feature и находиться в папке Features
    Файл начинается с названия фичи (Feature: ...)
    Фича содержит сценарии, которые и являются тестами (Scenario: ...)
    Сценарий содержит шаги, начинающиеся со слов Given (дано), When (действия), Then (результат), And (дополнительные шаги в рамках одного этапа - любого из предыдущих)
    Файл со сценариями должен иметь кодировку UTF-8

Запуск тестов
    mvn clean install -Dcucumber.options="--tags @alltests --tags ~@ignored"

Отчеты
    1. Кратко, понятно, с результатами шагов:
    	target/reports-pretty/index.html
    Примечание: при при каждом запуске тестов этот отчет перезатирается

    2. Красиво, с крутыми графиками и процентными показателями:
    	Reports/.../cucumber-html-reports/overview-features.html
    Примечание: ну очень крутой отчет :)

Теги
    Тесты нужно помечать тегами, их может быть несколько. При этом можно помечать тегами как фичи так и отдельные сценарии в них.
    Предлагаемые теги:
    	@alltests - все тесты
    	@smoketests - смоуки
    	@newtests - используется для запуска тестов в целях проверки (или отладки)
    	@ignored - при наличии этого тега фича не будет запущена
    Пример 1: фича помечена тегами @alltests и @ignored - при запуске всех тестов (тег @alltests) эта фича не будет запущена.
    Пример 2: фича помечена тегом @alltests, но один сценарий в ней - тегом @ignored. В этом случае будут выполнены все сценарии кроме него.
    Пример 3: отдельный сценарий внутри фичи помечен тегом @test, при исполнении команды mvn clean install -Dcucumber.options="--tags @test" будет выполнен только один сценарий. По существу, эта роль отводится тегу @newtests.
    Теги можно создавать самостоятельно, даже указанные выше теги не являются обязательными, но для порядка лучше всего придерживаться единой системы обозначений.

Тесты с набором параметров:
    Тест начинается не со слова "Scenario: ...", как обычно, а с "Scenario Outline: ..."
    Параметры должны быть заключены в кавычки и угловые скобки.

Шаги:
    В настоящий момент можно использовать следующие шаги (в независимости от этапа Given/When/Then/And):
        page 'Payments and Transfers' is opened
                  page 'Main Screen' is opened
                  user inserts "<text>"
                  user clears insert field by pressing backspace "<nember>" times
                  user waits for timeout "<number>"
                  user presses 'calendar switcher next' button
                  user presses 'calendar switcher previous' button
                  user presses button "<button_name>" on check
                  user presses button 'HELP'
                  user presses button 'HOME'
                  user presses button "<button_name>"
                  user scrolls up "<number>" times
                  user scrolls down "<number>" times
                  log should contain string "<string>"
                  element with text "<element_text>" should not be displayed
                  greeting "<element_text>" should be displayed
                  check should contain string "<element_text>"
                  check should be displayed
                  keyboard should be displayed
                  scrollbar should be displayed
                  template "<template_name>" should be displayed
                  element with text "<element_text>" should be displayed
                  element 'timeout screen' should be displayed
                  element 'support' : "<element_text>" should be displayed
                  element 'region field' : "<element_text>" should be displayed
                  element 'notes' : "<element_text>" should be displayed
                  element 'help_notes' : "<element_text>" should be displayed
                  element "<text_left>" : "<text_right>" should be displayed on 'Total' page
                  element "<element_type>" : "<element_text>" should be displayed on 'Error' page
                  element "<element_type>" : "<element_text>" should be displayed on 'OK' page
                  element "<element_type>" : "<element_text>" should be displayed

        * Пробелы игнорируются
        * Кавычки " " обязательны в шаге, а угловые скобки < > - описывают переменную.
          В шагах, где присутствуют кавычки одиночные ' ' без угловых скобок < > не допускаются другие переменные, например:
              user presses button "<button_name>" - означает, что можно ввести название кнопки самостоятельно: When user presses button "Платежи"
              user presses button 'HOME' - означает, что этот шаг не использует переменные, это просто нажатие кнопки HOME
          Эти нюансы связаны с неудобными названиями элементов в коде страницы или с отсутствием явной надписи на кнопке, как в случае с "домиком"
