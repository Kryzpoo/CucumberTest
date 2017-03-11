package siriustest.steps;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import siriustest.manage.TestManager;

public class CheckDisplaySteps {

    private static final String translatedSymbols = "translate(text(), '\u00A0\u200B\u00AD', ' ')";
    private WebDriverWait wait = TestManager.getWait();

    // TODO: 07.03.2017 NOTES внутри description, доделать: использовать внутренний метод checkNotes
    @Then("^element \"([^\"]*)\" : \"([^\"]*)\" should be displayed$")
    public void elementShouldBeDisplayed(String elementType, String elementText) throws Throwable {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath( "//*[contains(@class, '" + elementType + "_text') and " + translatedSymbols + " = '" + elementText + "']" )));
        Assert.assertTrue(element.isDisplayed());
    }

    @Then("^element 'region' : \"([^\"]*)\" should be displayed$")
    public void elementRegionShouldBeDisplayed(String regionText) throws Throwable {
        WebElement region = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath( "//*[@class = 'btn_caption' and " + translatedSymbols + " = '" + regionText + "']" )));
        Assert.assertTrue(region.isDisplayed());
    }

    @Then("^element 'support' : \"([^\"]*)\" should be displayed$")
    public void elementSupportShouldBeDisplayed(String supportText) throws Throwable {
        WebElement support = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath( "//*[@class = 'timeout_support' and " + translatedSymbols + " = '" + supportText + "']" )));
        Assert.assertTrue(support.isDisplayed());
    }

    @Then("^element 'timeout screen' should be displayed$")
    public void elementTimeoutScreenShouldBeDisplayed() throws Throwable {
        WebElement timeoutScreen = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[@class = 'timeout_message']" )));
        Assert.assertTrue(timeoutScreen.isDisplayed());
    }

    @Then("^template \"([^\"]*)\" should be displayed$")
    public void templateShouldBeAn(String templateName) throws Throwable {
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath( "//meta[@content = '" + templateName + ".html']" )));
    }

    @Then("^button \"([^\"]*)\" should be displayed$")
    public void buttonShouldBeDisplayed(String buttonText) throws Throwable {
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[" + translatedSymbols + " = '" + buttonText + "']/..")));
        Assert.assertTrue(button.isDisplayed());
    }

    @Then("^keyboard should be displayed$")
    public void userShouldSeeKeyboard() throws Throwable {
        WebElement keyboard = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("kb_all")));
        Assert.assertTrue(keyboard.isDisplayed());
    }
}
