package siriustest.steps;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import siriustest.manage.TestManager;

public class CheckDisplaySteps {

    private static final String translatedSymbols = "translate(normalize-space(), ' \u00A0\u200B\u00AD', '')";
    private WebDriverWait wait = TestManager.getWait();
    private WebDriverWait shortWait = TestManager.getShortWait();

    @Then("^element \"([^\"]*)\" : \"([^\"]*)\" should be displayed$")
    public void elementShouldBeDisplayed(String elementType, String elementText) throws Throwable {
        elementText = elementText.replaceAll(" ", "");
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[contains(@class, '" + elementType + "_text') and " + translatedSymbols + " = '" + elementText + "' ]" )));
    }

    @Then("^element 'notes' : \"([^\"]*)\" should be displayed$")
    public void elementNotesShouldBeDisplayed(String notesText) throws Throwable {
        notesText = notesText.replaceAll(" ", "");
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[@class = 'description_text']/..//*[contains(" + translatedSymbols + ", '" + notesText + "')]" )));
    }

    @Then("^element 'region field' : \"([^\"]*)\" should be displayed$")
    public void elementRegionFieldShouldBeDisplayed(String regionText) throws Throwable {
        regionText = regionText.replaceAll(" ", "");
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[@class = 'btn_caption']/..//*[" + translatedSymbols + " = '" + regionText + "']" )));
    }

    @Then("^element 'support' : \"([^\"]*)\" should be displayed$")
    public void elementSupportShouldBeDisplayed(String supportText) throws Throwable {
        supportText = supportText.replaceAll(" ", "");
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[@class = 'timeout_support']/..//*[" + translatedSymbols + " = '" + supportText + "']" )));
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

    @Then("^element with text \"([^\"]*)\" should be displayed$")
    public void elementShouldBeDisplayed(String elementText) throws Throwable {
        elementText = elementText.replaceAll(" ", "");
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[" + translatedSymbols + " = '" + elementText + "']")));
    }

    @Then("^keyboard should be displayed$")
    public void userShouldSeeKeyboard() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.xpath("//*[@class = 'b-numpad' or @class = 'kb_all']")));
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
        elementText = elementText.replaceAll(" ", "");
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath( "//*[@class = 'report_" + elementType + "']/..//*[" + translatedSymbols + " = '" + elementText + "']" )));
    }

    @Then("^element \"([^\"]*)\" : \"([^\"]*)\" should be displayed on 'Error' page$")
    public void elementShouldBeDisplayedOnErrorPage(String elementType, String elementText) throws Throwable {
        elementShouldBeDisplayedOnOKPage(elementType, elementText);
    }

    @Then("^element \"([^\"]*)\" : \"([^\"]*)\" should be displayed on 'Total' page$")
    public void elementShouldBeDisplayedOnTotalPage(String elementCaption, String elementText) throws Throwable {
        elementCaption = elementCaption.replaceAll(" ", "");
        elementText = elementText.replaceAll(" ", "");
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath( "//*[" + translatedSymbols + " = '" + elementCaption + "']/../..//*[" + translatedSymbols + " = '" + elementText + "']" )));
    }

    @Then("^greeting \"([^\"]*)\" should be displayed$")
    public void greetingShouldBeDisplayed(String elementText) throws Throwable {
        elementText = elementText.replaceAll(" ", "");
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[@class = 'btn_caption' and " + translatedSymbols + " = '" + elementText + "']" )));
    }

    @Then("^element with text \"([^\"]*)\" should not be displayed$")
    public void elementWithTextShouldNotBeDisplayed(String elementText) throws Throwable {
        elementText = elementText.replaceAll(" ", "");
        shortWait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfAllElementsLocatedBy
                (By.xpath("//*[" + translatedSymbols + " = '" + elementText + "']"))));
    }

    @Then("^scrollbar should be displayed$")
    public void scrollbarShouldBeDisplayed() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[contains(@class, 'b-scroll-bar') and not(contains(@style, 'display::none'))][not(ancestor::div[contains(@style,'display:none')])]" )));
    }

    @Then("^element 'help_notes' : \"([^\"]*)\" should be displayed$")
    public void elementHelp_notesShouldBeDisplayed(String elementText) throws Throwable {
        elementText = elementText.replaceAll(" ", "");
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[" + translatedSymbols + " = '" + elementText + "']")));
    }
}