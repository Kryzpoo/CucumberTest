package siriustest.steps;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import siriustest.LogManager;
import siriustest.manage.TestManager;

import java.io.File;

import static siriustest.manage.TestManager.PROPERTIES;

public class UserActionSteps {

    private Actions inputExecutor = TestManager.getInputExecutor();
    private WebDriverWait wait = TestManager.getWait();

    @Когда("^пользователь вводит \"([^\"]*)\"$")
    public void userInsertsIntoFieldTouch(String text) throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.className( "input_cursor" )));
        inputExecutor.sendKeys( text );
        inputExecutor.build().perform();
    }

    @Когда("^пользователь нажимает кнопку 'Backspace' \"([^\"]*)\" раз$")
    public void userClearsInsertField(int pressCount) throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.className( "input_cursor" )));
        for (int i = 0; i < pressCount; i++)
            inputExecutor.sendKeys( Keys.BACK_SPACE );
        inputExecutor.build().perform();
    }

    @Когда("^пользователь ожидает \"([^\"]*)\" секунд$")
    public void userWaitsForTimeout(int timeout) throws Throwable {
        Thread.sleep( timeout * 1000 );
    }

    @Тогда("^в логе сервера присутствует строка \"([^\"]*)\"$")
    public void serverLogShouldContainString(String searchString) throws Throwable {
        boolean found = LogManager.parseServerLog(
                new File( PROPERTIES.getProperty("log.client") ),
                new File( PROPERTIES.getProperty("log.server.folder") ),
                searchString);
        Assert.assertTrue( found );
    }

    @Тогда("^в логе клиента присутствует строка \"([^\"]*)\"$")
    public void clientLogShouldContainString(String searchString) throws Throwable {
        boolean found = LogManager.parseClientLog(
                new File(PROPERTIES.getProperty("log.client")), searchString);
        Assert.assertTrue( found );
    }

    @Тогда("^в логе эмулятора присутствует строка \"([^\"]*)\"$")
    public void emulatorLogShouldContainString(String searchString) throws Throwable {
        boolean found = LogManager.parseEmulatorLog(
                new File(PROPERTIES.getProperty("log.emulator")), searchString);
        Assert.assertTrue( found );
    }

    @Дано("^адресная строка содержит \"([^\"]*)\"$")
    public void вАдреснойСтрокеПрисутствуетСтрока(String URLsubStruing) throws Throwable {
        wait.until(ExpectedConditions.urlContains(URLsubStruing));
    }
}