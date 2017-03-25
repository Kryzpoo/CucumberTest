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

import static siriustest.manage.TestManager.PROPERTIES;

public class UserActionSteps {

    private Actions inputExecutor = TestManager.getInputExecutor();
    private WebDriverWait wait = TestManager.getWait();

    @When("^user inserts \"([^\"]*)\"$")
    public void userInsertsIntoFieldTouch(String text) throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.className( "input_cursor" )));
        inputExecutor.sendKeys( text );
        inputExecutor.build().perform();
    }

    @When("^user clears insert field by pressing backspace \"([^\"]*)\" times$")
    public void userClearsInsertField(int pressCount) throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.className( "input_cursor" )));
        for (int i = 0; i < pressCount; i++)
            inputExecutor.sendKeys( Keys.BACK_SPACE );
        inputExecutor.build().perform();
    }

    @When("^user waits for timeout \"([^\"]*)\"$")
    public void userWaitsForTimeout(int timeout) throws Throwable {
        Thread.sleep( timeout * 1000 );
    }

    @Then("^log should contain string \"([^\"]*)\"$")
    public void logShouldContainString(String searchString) throws Throwable {
        boolean found = FileManager.searchInLogFile(new File( PROPERTIES.getProperty("log.client") ),
                                    new File( PROPERTIES.getProperty("log.server.folder") ),
                                    searchString);
        Assert.assertTrue( found );
    }
}