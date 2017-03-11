package siriustest.steps;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import siriustest.manage.TestManager;

import java.util.Properties;

public class OpenPageSteps {

    private final Properties PROPERTIES = TestManager.getProperties();
    private WebDriver driver = TestManager.getDriver();

    // TODO: 11.03.2017 Найти способ избавитьься от sleep()
    @Given("^page 'Payments and Transfers' is opened$")
    public void openedPaymentsAndTransfersPage() throws Throwable {
        Thread.sleep( 1000 );
        driver.get( PROPERTIES.getProperty( "page.url" ) + "/mq" );
        System.out.println();
    }

    @Given("^page 'Main Screen' is opened$")
    public void openedMainScreenPage() throws Throwable {
        Thread.sleep( 1000 );
        driver.get( PROPERTIES.getProperty( "page.url" ) + "/mq?scenario=main_menu" );
    }
}
