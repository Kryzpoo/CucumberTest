package siriustest.steps;

import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import siriustest.manage.TestManager;

import java.util.ArrayList;
import java.util.List;

public class PressButtonSteps {

    private static final String translatedSymbols = "translate(text(), '\u00A0\u200B\u00AD', ' ')";
    private WebDriverWait wait = TestManager.getWait();
    private WebDriver driver = TestManager.getDriver();

    @When("^user presses button \"([^\"]*)\"$")
    public void userPressesButton(String buttonText) throws Throwable {
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[" + translatedSymbols + " = '" + buttonText + "']/..")));
        button.click();
    }

    @When("^user presses button HOME$")
    public void userPressesButtonHOME() throws Throwable {
        List<String> homeButtonSelectorList = new ArrayList<>(2);
        homeButtonSelectorList.add("//*[@class = 'b-btn b-btn-menu-dual']");
        homeButtonSelectorList.add(("//*[@class = 'tabs_item ndc']"));

        for ( String homeButtonSelector : homeButtonSelectorList ) {
            if ( driver.findElements(By.xpath( homeButtonSelector )).size() > 0 ) {
                WebElement button = driver.findElement(By.xpath( homeButtonSelector ));
                button.click();
                return;
            }
        }
    }

    @When("^user presses button HELP$")
    public void userPressesButtonHELP() throws Throwable {
        WebElement helpButton = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@class = 'help_button']")));
        helpButton.click();
    }


    @When("^user presses button \"([^\"]*)\" on check$")
    public void userPressesButtonOnCheck(String buttonText) throws Throwable {
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[" + translatedSymbols + " = '" + buttonText + "']")));
        button.click();
    }

    @When("^user presses 'calendar switcher previous' button$")
    public void userPressesButtonCalendarSwitcherPrev() throws Throwable {
        WebElement calendarSwitcherButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("switcher_prev")));
        calendarSwitcherButton.click();
    }

    @When("^user presses 'calendar switcher next' button$")
    public void userPressesButtonCalendarSwitcherNext() throws Throwable {
        WebElement calendarSwitcherButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("switcher_next")));
        calendarSwitcherButton.click();
    }
}
