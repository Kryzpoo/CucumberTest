package siriustest.steps;

import cucumber.api.java.ru.Дано;
import org.openqa.selenium.WebDriver;
import siriustest.manage.TestManager;

import static siriustest.manage.TestManager.PROPERTIES;

public class OpenPageSteps {

    private WebDriver driver = TestManager.getDriver();

    @Дано("^страница 'Платежи и переводы' открыта$")
    public void openedPaymentsAndTransfersPage() throws Throwable {
        driver.get( PROPERTIES.getProperty( "page.url" ) + "/mq" );
    }

    @Дано("^страница 'Главный экран' открыта$")
    public void openedMainScreenPage() throws Throwable {
        driver.get( PROPERTIES.getProperty( "page.url" ) + "/mq/start?scenario=card_main_menu_start" );
    }
}
