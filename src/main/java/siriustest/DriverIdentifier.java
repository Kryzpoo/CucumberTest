package siriustest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverIdentifier {

    public static String identifyDriver ( String driverName ) {
        String driverId = "";

        switch ( driverName ) {
            case "chrome":
                driverId = "webdriver.chrome.driver";
                break;
            case "ie":
                driverId = "webdriver.ie.driver";
                break;
        }
        return driverId;
    }

    public static WebDriver getDriver ( String driverName ) {
        WebDriver driver = null;

        switch ( driverName ) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
        }
        return driver;
    }
}
