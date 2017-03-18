package siriustest.steps;

import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import siriustest.manage.TestManager;

public class PressButtonSteps {

    private static final String translatedSymbols = "translate(normalize-space(), ' \u00A0\u200B\u00AD', '')";
    private static final String translatedSymbolsText = "translate(text(), ' \u00A0\u200B\u00AD', '')";
    private WebDriverWait wait = TestManager.getWait();

    @When("^user presses button \"([^\"]*)\"$")
    public void userPressesButton(String buttonText) throws Throwable {
        buttonText = buttonText.replaceAll(" ", "");
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[" + translatedSymbols + " = '" + buttonText + "' or " + translatedSymbolsText + " = '" + buttonText + "']/text()/..")));
        button.click();
    }

    @When("^user presses button 'HOME'$")
    public void userPressesButtonHOME() throws Throwable {
        WebElement homeButton = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath( "//*[@class = 'b-btn b-btn-menu-dual' or @class = 'tabs_item ndc']" )));
        homeButton.click();
    }

    @When("^user presses button 'HELP'$")
    public void userPressesButtonHELP() throws Throwable {
        WebElement helpButton = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@class = 'help_button']")));
        helpButton.click();
    }

    @When("^user presses button \"([^\"]*)\" on check$")
    public void userPressesButtonOnCheck(String buttonText) throws Throwable {
        buttonText = buttonText.replaceAll(" ", "");
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[" + translatedSymbols + " = '" + buttonText + "']")));
        button.click();
    }

    @When("^user presses 'calendar switcher previous' button$")
    public void userPressesButtonCalendarSwitcherPrev() throws Throwable {
        WebElement calendarSwitcherButton = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.className("switcher_prev")));
        calendarSwitcherButton.click();
    }

    @When("^user presses 'calendar switcher next' button$")
    public void userPressesButtonCalendarSwitcherNext() throws Throwable {
        WebElement calendarSwitcherButton = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.className("switcher_next")));
        calendarSwitcherButton.click();
    }

    @When("^user scrolls down \"([^\"]*)\" times$")
    public void userScrollsDown(int count) throws Throwable {
        WebElement scrollButton = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[contains(@class, 'scroll-bar_next') and not(contains(@style, 'display::none'))][not(ancestor::div[contains(@style,'display:none')])]")));
        for ( int i = 0; i < count; i++ )
            scrollButton.click();
    }

    @When("^user scrolls up \"([^\"]*)\" times$")
    public void userScrollsUp(int count) throws Throwable {
        WebElement scrollButton = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[contains(@class, 'scroll-bar_prev') and not(contains(@style, 'display::none'))][not(ancestor::div[contains(@style,'display:none')])]")));
        for ( int i = 0; i < count; i++ )
            scrollButton.click();
    }
}
