package siriustest.steps;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import siriustest.manage.TestManager;

public class CheckDisplaySteps {

    private static final String translatedSymbols = "translate(text(), '\u00A0\u200B\u00AD', ' ')";
    private WebDriverWait wait = TestManager.getWait();

    @Then("^element \"([^\"]*)\" : \"([^\"]*)\" should be displayed$")
    public void elementShouldBeDisplayed(String elementType, String elementText) throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[contains(@class, '" + elementType + "_text') and " + translatedSymbols + " = '" + elementText + "']" )));
    }

    @Then("^element 'notes' : \"([^\"]*)\" should be displayed$")
    public void elementNotesShouldBeDisplayed(String notesText) throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[@class = 'description_text' and contains(" + translatedSymbols + ", '" + notesText + "')]" )));
    }

    @Then("^element 'region' : \"([^\"]*)\" should be displayed$")
    public void elementRegionShouldBeDisplayed(String regionText) throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[@class = 'btn_caption' and " + translatedSymbols + " = '" + regionText + "']" )));
    }

    @Then("^element 'support' : \"([^\"]*)\" should be displayed$")
    public void elementSupportShouldBeDisplayed(String supportText) throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[@class = 'timeout_support' and " + translatedSymbols + " = '" + supportText + "']" )));
    }

    @Then("^element 'timeout screen' should be displayed$")
    public void elementTimeoutScreenShouldBeDisplayed() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[@class = 'timeout_message']" )));
    }

    @Then("^template \"([^\"]*)\" should be displayed$")
    public void templateShouldBeAn(String templateName) throws Throwable {
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath( "//meta[@content = '" + templateName + ".html']" )));
    }

    @Then("^button \"([^\"]*)\" should be displayed$")
    public void buttonShouldBeDisplayed(String buttonText) throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[" + translatedSymbols + " = '" + buttonText + "']/..")));
    }

    @Then("^keyboard should be displayed$")
    public void userShouldSeeKeyboard() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.className("kb_all")));
    }

    @Then("^check should be displayed$")
    public void checkShouldBeDisplayed() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.className( "b-receipt" )));
    }

    @Then("^check should contain string \"([^\"]*)\"$")
    public void checkShouldContainString(String checkText) throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[contains(text(), '" + checkText + "')]" )));
    }

    @Then("^element \"([^\"]*)\" : \"([^\"]*)\" should be displayed on 'OK' page$")
    public void elementShouldBeDisplayedOnOKPage(String elementType, String elementText) throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[contains(@class, 'report_" + elementType + "') and " + translatedSymbols + " = '" + elementText + "']" )));
    }

    @Then("^element \"([^\"]*)\" : \"([^\"]*)\" should be displayed on 'Error' page$")
    public void elementShouldBeDisplayedOnErrorPage(String elementType, String elementText) throws Throwable {
        elementShouldBeDisplayedOnOKPage(elementType, elementText);
    }

    @Then("^element \"([^\"]*)\" : \"([^\"]*)\" should be displayed on 'Total' page$")
    public void elementShouldBeDisplayedOnTotalPage(String elementType, String elementText) throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[" + translatedSymbols + " = '" + elementType + "']/../..//*[" + translatedSymbols + " = '" + elementText + "']" )));
    }

    // TODO: 12.03.2017 Проверка приветствия
    @Then("^greeting \"([^\"]*)\" should be displayed$")
    public void greetingShouldBeDisplayed(String elementText) throws Throwable {
        //*[translate(text(), ' ​­', ' ') = 'Здравствуйте,']/..//*[translate(text(), ' ​­', ' ') = 'САТУРН ПЛАНЕТОВИЧ']
        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[@id=\"content\"]/div[3]/div[1]/div[2]" ))));
        //*[translate(text(), ' ​­', ' ') = 'Здравствуйте, САТУРН ПЛАНЕТОВИЧ']
    }
}