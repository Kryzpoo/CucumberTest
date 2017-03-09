package siriustest.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import siriustest.DriverIdentifyer;
import siriustest.PropertiesLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class StepDefs {

    private static final Properties PROPERTIES = PropertiesLoader.getProperties();
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty(DriverIdentifyer.identifyDriver(PROPERTIES),
                System.getProperty( "user.dir" )
                        + File.separator
                        + "Drivers"
                        + File.separator
                        + PROPERTIES.getProperty( "driver.filename" ));
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Integer.parseInt( PROPERTIES.getProperty( "setting.timeout" ) ));
        driver.manage().timeouts().pageLoadTimeout( Integer.parseInt( PROPERTIES.getProperty( "setting.timeout" ) ), TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed())
            scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
        driver.quit();
    }

    @When("^page 'Payments and Transfers' is opened$")
    public void openedPaymentsAndTransfersPage() throws Throwable {
        Thread.sleep( 1000 );
        driver.get( PROPERTIES.getProperty( "page.url" ) + "/mq" );
    }

    @Given("^page 'Main Screen' is opened$")
    public void openedMainScreenPage() throws Throwable {
        Thread.sleep( 1000 );
        driver.get( PROPERTIES.getProperty( "page.url" ) + "/mq?scenario=main_menu" );
    }

    @When("^user presses button \"([^\"]*)\"$")
    public void iPressesButton(String buttonText) throws Throwable {
        // Замена нечитаемых символов (символы нулевой ширины и неразрывные пробелы) на человеческие
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[translate(text(), '\u00A0\u200B\u00AD', ' ') = '" + buttonText + "']/..")));
        button.click();
    }

    // TODO: 07.03.2017 NOTES внутри description, доделать: использовать внутренний метод checkNotes
    @Then("^element \"([^\"]*)\" : \"([^\"]*)\" should be displayed$")
    public void elementShouldBeDisplayed(String elementType, String elementText) throws Throwable {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath( "//*[contains(@class, '" + elementType + "_text') and translate(text(), '\u00A0\u200B\u00AD', ' ') = '" + elementText + "']" )));
        Assert.assertTrue(element.isDisplayed());
    }
    //*[contains(@class, 'description_text')]

    @And("^user presses button HOME$")
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

    @And("^user presses button HELP$")
    public void userPressesButtonHELP() throws Throwable {
        WebElement helpButton = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@class = 'help_button']")));
        helpButton.click();
    }

    @Then("^template should be an \"([^\"]*)\"$")
    public void templateShouldBeAn(String templateName) throws Throwable {
        /*if (driver.findElements(By.xpath("//meta[@content='" + templateName + ".html']")).size() <= 0)
            throw new NoSuchElementException( "Incorrect template" );*/
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath( "//meta[@class = '" + templateName + ".html'" )));
    }

    @Then("^button \"([^\"]*)\" should be displayed$")
    public void buttonShouldBeDisplayed(String buttonText) throws Throwable {
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[translate(text(), '\u00A0\u200B\u00AD', ' ') = '" + buttonText + "']/..")));
        Assert.assertTrue(button.isDisplayed());
    }

    @When("^user inserts \"([^\"]*)\" into field \\(Touch\\)$")
    public void userInsertsIntoFieldTouch(String text) throws Throwable {
        // TODO: 10.03.2017 Вынести jsExecutor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        while (!jsExecutor.executeScript("return document.readyState").toString().equals("complete")) {
            Thread.sleep(1000);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id( "input" )));
        Actions actions = new Actions(driver);
        actions.sendKeys( text );
        actions.build().perform();
    }

    // TODO: 07.03.2017 Класс будет отличаться, проверить
    @When("^user inserts \"([^\"]*)\" into field \\(FDK\\)$")
    public void userInsertsIntoFieldFDK(String text) throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id( "input" )));
        Actions actions = new Actions(driver);
        actions.sendKeys( text );
        actions.build().perform();
    }

    @When("^user waits for timeout \"([^\"]*)\"$")
    public void userWaitsForTimeout(int timeout) throws Throwable {
        Thread.sleep( timeout * 1000 );
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

    @Then("^user should see keyboard$")
    public void userShouldSeeKeyboard() throws Throwable {
        WebElement keyboard = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("kb_all")));
        Assert.assertTrue(keyboard.isDisplayed());
    }

    @Then("^element 'region' : \"([^\"]*)\" should be displayed$")
    public void elementRegionShouldBeDisplayed(String regionText) throws Throwable {
        WebElement region = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath( "//*[@class = 'btn_caption' and translate(text(), '\u00A0\u200B\u00AD', ' ') = '" + regionText + "']" )));
        Assert.assertTrue(region.isDisplayed());
    }

    @Then("^element 'support' : \"([^\"]*)\" should be displayed$")
    public void elementSupportShouldBeDisplayed(String supportText) throws Throwable {
        WebElement support = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath( "//*[@class = 'timeout_support' and translate(text(), '\u00A0\u200B\u00AD', ' ') = '" + supportText + "']" )));
        Assert.assertTrue(support.isDisplayed());
    }

    @Then("^element 'timeout screen' should be displayed$")
    public void elementTimeoutScreenShouldBeDisplayed() throws Throwable {
        String timeoutText = "Планируете\n" +
                "продолжить операцию?";
        WebElement supportText = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath( "//*[@class = 'timeout_message' and translate(text(), '\u00A0\u200B\u00AD', ' ') = '" + timeoutText + "']" )));
        Assert.assertTrue(supportText.isDisplayed());
    }

    @When("^user presses button \"([^\"]*)\" on check$")
    public void userPressesButtonOnCheck(String buttonText) throws Throwable {
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[translate(text(), '\u00A0\u200B\u00AD', ' ') = '" + buttonText + "']")));
        button.click();
    }
}