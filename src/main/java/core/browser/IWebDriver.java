package core.browser;

import core.wrapper.driver.DriverProperty;
import org.openqa.selenium.WebDriver;

public interface IWebDriver {

    /**
     * Create web driver from driver property
     *
     * @param property DriverProperty
     * @return WebDriver
     */
    WebDriver createWebDriver(DriverProperty property);

}
