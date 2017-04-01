@exampletests
@log_example
Feature: log example

  Scenario: log example
    Given client log should contain string "запрос отправлен на сервер: POST http://127.0.0.1:9080/gate/xml HTTP/1.1"
    Given server log should contain string "WSVR0041I: Stopping EJB jar: configurations-ejb-8.2.1-SNAPSHOT.jar"
