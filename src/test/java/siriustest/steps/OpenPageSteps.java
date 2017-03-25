package siriustest.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.ru.Дано;
import org.openqa.selenium.WebDriver;
import siriustest.manage.TestManager;

import static siriustest.manage.TestManager.PROPERTIES;

public class OpenPageSteps {

    private WebDriver driver = TestManager.getDriver();

    @Given("^page 'Payments and Transfers' is opened$")
    public void openedPaymentsAndTransfersPage() throws Throwable {
        driver.get( PROPERTIES.getProperty( "page.url" ) + "/mq" );
    }

    @Given("^page 'Main Screen' is opened$")
    @Дано("^страница 'Главный экран' открыта$")
    public void openedMainScreenPage() throws Throwable {
        driver.get( PROPERTIES.getProperty( "page.url" ) + "/mq/start?scenario=card_main_menu_start" );
    }
}
