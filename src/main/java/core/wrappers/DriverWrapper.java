package core.wrappers;

import core.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class DriverWrapper extends WebDriverFactory {

    private static DriverWrapper instance = null;

    private DriverWrapper() {}

    public static DriverWrapper getInstance() {
        if(instance == null) {
            instance = new DriverWrapper();
        }
        return instance;
    }

    public static void closeBrowser() {
        driver.get().quit();
        driver.remove();
    }

    public static void switchToNewTab() {
        try {
            driver.get().switchTo().newWindow(WindowType.TAB);
        } catch (Exception e) {

        }
    }

    public static void get(String url) {
        try {
            driver.get().get(url);
        } catch (Exception e) {

        }
    }
}
