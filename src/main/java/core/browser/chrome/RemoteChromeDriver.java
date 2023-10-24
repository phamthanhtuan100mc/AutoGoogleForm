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
        logger.info("Exit all running Chromedriver");
        Helper.excCommand(OSType.WINDOWS, Constant.COMMAND_END_RUNNING_CHROMEDRIVER);

        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
