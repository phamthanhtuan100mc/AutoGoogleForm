package core.wrappers;

import core.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class DriverWrapper extends WebDriverFactory {

    private static DriverWrapper instance = null;

    private DriverWrapper() {}

    public static DriverWrapper getInstance() {
        if(instance == null) {
            instance = new DriverWrapper();
        }
        return instance;
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(String browser, boolean remote) {
        setWebDriver(browser, remote);
    }

}
