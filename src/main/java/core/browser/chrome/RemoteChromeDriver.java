package core.browser.chrome;

import core.browser.IWebDriver;
import core.wrapper.driver.DriverProperty;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RemoteChromeDriver implements IWebDriver {

    /**
     * Create web driver from driver property
     *
     * @param property DriverProperty
     * @return WebDriver
     */
    @Override
    public WebDriver createWebDriver(DriverProperty property) {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
