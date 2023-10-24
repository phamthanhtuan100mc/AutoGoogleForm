package core.browser.edge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import core.browser.IWebDriver;
import core.wrapper.driver.DriverProperty;

public class RemoteEdgeDriver implements IWebDriver {
    /**
     * Create remote Edge web driver from driver property
     *
     * @param property DriverProperty
     * @return WebDriver
     */
    @Override
    public WebDriver createWebDriver(DriverProperty property) {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
