package core.browser.firefox;

import core.browser.chrome.RemoteChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import core.browser.IWebDriver;
import core.wrapper.driver.DriverProperty;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteFirefoxDriver implements IWebDriver {
    private static final Logger logger = LogManager.getLogger(RemoteFirefoxDriver.class);

    /**
     * Create remote Firefox web driver from driver property
     *
     * @param property DriverProperty
     * @return WebDriver
     */
    @Override
    public WebDriver createWebDriver(DriverProperty property) {
        try {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            for (String key: property.getDesiredCapabilities().keySet()) {
                desiredCapabilities.setCapability(key, property.getDesiredCapabilities().get(key));
            }
            firefoxOptions.merge(desiredCapabilities);
            URL url = new URL(property.getRemoteUrl());

            return new RemoteWebDriver(url, firefoxOptions);
        } catch (MalformedURLException mue) {
            logger.error("Create remote Chromedriver fail: " + mue.getMessage());
            return null;
        }
    }
}
