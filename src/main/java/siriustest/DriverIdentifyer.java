package siriustest;

import java.util.Properties;

public class DriverIdentifyer {
    public static String identifyDriver(Properties PROPERTIES) {
        String driverId = "";

        switch (PROPERTIES.getProperty( "driver.name" )) {
            case "chrome":
                driverId = "webdriver.chrome.driver";
                break;
            case "ie":
                driverId = "webdriver.ie.driver";
                break;
        }
        return driverId;
    }
}
