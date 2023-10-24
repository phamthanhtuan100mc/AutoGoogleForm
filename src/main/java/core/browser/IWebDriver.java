package core.browser;

import org.openqa.selenium.WebDriver;

import core.wrapper.driver.DriverProperty;

public interface IWebDriver {

    /**
     * Create web driver from driver property
     *
     * @param property DriverProperty
     * @return WebDriver
     */
    WebDriver createWebDriver(DriverProperty property);

}
