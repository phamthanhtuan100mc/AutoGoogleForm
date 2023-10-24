package core.browser.chrome;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import core.browser.IWebDriver;
import core.util.common.Constant;
import core.util.enums.OSType;
import core.util.helper.Helper;
import core.wrapper.driver.DriverProperty;

public class LocalChromeDriver implements IWebDriver {
    private static final Logger logger = LogManager.getLogger(LocalChromeDriver.class);

    /**
     * Create local Chrome web driver from driver property
     *
     * @param property DriverProperty
     * @return WebDriver
     */
    @Override
    public WebDriver createWebDriver(DriverProperty property) {
        logger.info("Exit all running Chromedriver");
        Helper.excCommand(OSType.WINDOWS, Constant.COMMAND_END_RUNNING_CHROMEDRIVER);

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments(property.getArguments());

        DesiredCapabilities capabilities = new DesiredCapabilities();

        options.merge(capabilities);

        return new ChromeDriver(options);
    }
}
