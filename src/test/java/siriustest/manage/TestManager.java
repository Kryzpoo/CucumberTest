package siriustest.manage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import siriustest.DriverIdentifier;
import siriustest.PropertiesLoader;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestManager {

    private static final Properties PROPERTIES = PropertiesLoader.getProperties();
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static WebDriverWait shortWait;
    private static Actions inputExecutor;

    @Before
    public void setUp() {
        String driverName = PROPERTIES.getProperty( "driver.name" );
        String driverFilename = PROPERTIES.getProperty( "driver.filename" );
        String driverTimeout = PROPERTIES.getProperty( "setting.timeout" );

        System.setProperty(DriverIdentifier.identifyDriver( driverName ),
                System.getProperty( "user.dir" )
                        + File.separator
                        + "Drivers"
                        + File.separator
                        + driverFilename );
        driver = DriverIdentifier.getDriver( driverName );
        driver.manage().timeouts().pageLoadTimeout( Integer.parseInt( driverTimeout ), TimeUnit.SECONDS );
        wait = new WebDriverWait(driver, Integer.parseInt( driverTimeout ));
        shortWait = new WebDriverWait(driver, 5);
        inputExecutor = new Actions(driver);
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed())
            scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static WebDriverWait getShortWait() {
        return shortWait;
    }

    public static Actions getInputExecutor() {
        return inputExecutor;
    }

    public static Properties getProperties() {
        return PROPERTIES;
    }
}
