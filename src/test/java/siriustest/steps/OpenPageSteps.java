package siriustest.steps;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import siriustest.manage.TestManager;

import java.util.Properties;

public class OpenPageSteps {

    private final Properties PROPERTIES = TestManager.getProperties();
    private WebDriver driver = TestManager.getDriver();

    @Given("^page 'Payments and Transfers' is opened$")
    public void openedPaymentsAndTransfersPage() throws Throwable {
        driver.get( PROPERTIES.getProperty( "page.url" ) + "/mq" );
    }

    @Given("^page 'Main Screen' is opened$")
    public void openedMainScreenPage() throws Throwable {
        driver.get( PROPERTIES.getProperty( "page.url" ) + "/mq/start?scenario=card_main_menu_start" );
    }
}
