package testcase;

import core.util.Enum.OSType;
import core.util.Helper;
import core.wrapper.DriverWrapper;
import core.wrapper.driver.DriverProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void setupTest() {

        logger.info("Exit all running chromedriver before test");
        Helper.excCommand(OSType.WINDOWS, "taskkill /f /im chromedriver.exe");

        logger.info("Setup webdriver");
        DriverWrapper.setDriver(new DriverProperty());
//        DriverWrapper.setPageLoadTimeOut();
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Quit webdriver");
        DriverWrapper.closeBrowser();
    }
}
