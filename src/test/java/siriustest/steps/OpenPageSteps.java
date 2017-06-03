package siriustest.steps;

import cucumber.api.java.ru.Дано;
import org.openqa.selenium.WebDriver;
import siriustest.manage.TestManager;

import static siriustest.manage.TestManager.PROPERTIES;

public class OpenPageSteps {

    private WebDriver driver = TestManager.getDriver();

    @Дано("^страница 'Платежи и переводы' открыта$")
    public void openedPaymentsAndTransfersPage() throws Throwable {
        driver.get( PROPERTIES.getProperty( "page.url" ) );
    }

    @Дано("^страница 'Главный экран' открыта$")
    public void openedMainScreenPage() throws Throwable {
        driver.get( PROPERTIES.getProperty( "page.url" ) + "/start?scenario=card_main_menu_start" );
    }

    @Дано("^страница 'Платежи наличными' открыта$")
    public void openedCashPayPage() throws Throwable {
        driver.get( PROPERTIES.getProperty( "page.url" ) + "/start?scenario=cash_pay_start" );
    }

    @Дано("^страница 'NFC ПиП' открыта$")
    public void openedNFCPaymentsPage() throws Throwable {
        driver.get( PROPERTIES.getProperty( "page.url" ) + "/start?scenario=nfc_card_pay_payments_start" );
    }

    @Дано("^страница 'Самоинкассация' открыта$")
    public void openedSAMOPage() throws Throwable {
        driver.get( PROPERTIES.getProperty( "page.url" ) + "/start?scenario=self_encashment_start" );
    }

    @Дано("^страница 'iPAS' открыта$")
    public void openediPASPage() throws Throwable {
        driver.get( PROPERTIES.getProperty( "page.url" ) + "/start?scenario=card_ipas_start" );
    }
}
