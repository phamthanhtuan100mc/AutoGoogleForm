package core.browser.firefox;

import core.browser.IWebDriver;
import core.wrapper.driver.DriverProperty;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalFirefoxDriver implements IWebDriver {

    /**
     * Create local Firefox web driver from driver property
     *
     * @param property DriverProperty
     * @return WebDriver
     */
    @Override
    public WebDriver createWebDriver(DriverProperty property) {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
