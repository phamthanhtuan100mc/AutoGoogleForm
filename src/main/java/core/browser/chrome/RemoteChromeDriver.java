package core.browser.chrome;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import core.browser.IWebDriver;
import core.util.common.Constant;
import core.util.enums.OSType;
import core.util.helper.Helper;
import core.wrapper.driver.DriverProperty;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RemoteChromeDriver implements IWebDriver {
    private static final Logger logger = LogManager.getLogger(RemoteChromeDriver.class);

    /**
     * Create remote Chrome web driver from driver property
     *
     * @param property DriverProperty
     * @return WebDriver
     */
    @Override
    public WebDriver createWebDriver(DriverProperty property) {
        try {
            ChromeOptions chromeOptions = new ChromeOptions();
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            for (String key: property.getDesiredCapabilities().keySet()) {
                desiredCapabilities.setCapability(key, property.getDesiredCapabilities().get(key));
            }
            chromeOptions.merge(desiredCapabilities);
            URL url = new URL(property.getRemoteUrl());

            return new RemoteWebDriver(url, chromeOptions);
        } catch (MalformedURLException mue) {
            logger.error("Create remote Chromedriver fail: " + mue.getMessage());
            return null;
        }
    }
}
