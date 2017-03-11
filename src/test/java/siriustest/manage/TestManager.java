package siriustest.manage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import siriustest.DriverIdentifyer;
import siriustest.PropertiesLoader;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestManager {

    private static final Properties PROPERTIES = PropertiesLoader.getProperties();
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions inputExecutor;

    @Before
    public void setUp() {
        System.setProperty(DriverIdentifyer.identifyDriver(PROPERTIES),
                System.getProperty( "user.dir" )
                        + File.separator
                        + "Drivers"
                        + File.separator
                        + PROPERTIES.getProperty( "driver.filename" ));
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout( Integer.parseInt( PROPERTIES.getProperty( "setting.timeout" ) ), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt( PROPERTIES.getProperty( "setting.timeout" ) ));
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

    public static Actions getInputExecutor() {
        return inputExecutor;
    }

    public static Properties getProperties() {
        return PROPERTIES;
    }

}
