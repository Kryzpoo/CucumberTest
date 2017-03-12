package siriustest.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import siriustest.FileManager;
import siriustest.manage.TestManager;

import java.io.File;
import java.util.Properties;

public class UserActionSteps {

    private final Properties PROPERTIES = TestManager.getProperties();
    private Actions inputExecutor = TestManager.getInputExecutor();
    private WebDriverWait wait = TestManager.getWait();

    @When("^user inserts \"([^\"]*)\"$")
    public void userInsertsIntoFieldTouch(String text) throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.className( "input_view" )));
        inputExecutor.sendKeys( text );
        inputExecutor.build().perform();
        //System.out.println(driver.findElement(By.xpath("//*[@class = 'input_view']")).getText());
    }

    @When("^user clears insert field by pressing backspace \"([^\"]*)\" times$")
    public void userClearsInsertField(int pressCount) throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.className( "input_view" )));
        for (int i = 0; i < pressCount; i++)
            inputExecutor.sendKeys( Keys.BACK_SPACE );
        inputExecutor.build().perform();
    }

    @When("^user waits for timeout \"([^\"]*)\"$")
    public void userWaitsForTimeout(int timeout) throws Throwable {
        Thread.sleep( timeout * 1000 );
    }

    // TODO: 12.03.2017 Проверка лога
    @Then("^log should contain string \"([^\"]*)\"$")
    public void logShouldContainString(String logString) throws Throwable {
        File serverLogFile = new File ( PROPERTIES.getProperty( "log.server" ) );
        String pattern = FileManager.getPattern(new File( PROPERTIES.getProperty( "log.client" )));

        Assert.assertTrue(FileManager.searchInLogFile(serverLogFile, pattern, logString));
    }
}