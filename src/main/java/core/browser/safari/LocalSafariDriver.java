package core.browser.safari;

import core.browser.IWebDriver;
import core.wrapper.driver.DriverProperty;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LocalSafariDriver implements IWebDriver {
    /**
     * Create local Safari web driver from driver property
     *
     * @param property DriverProperty
     * @return WebDriver
     */
    @Override
    public WebDriver createWebDriver(DriverProperty property) {
        WebDriverManager.safaridriver().setup();
        return new SafariDriver();
    }
}
