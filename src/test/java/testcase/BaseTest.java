package testcase;

import core.util.Enum;
import core.util.Helper;
import core.wrapper.DriverWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void setupTest() {

        logger.info("Exit all running chromedriver before test");
        Helper.excCommand(Enum.OSType.WINDOWS, "taskkill /f /im chromedriver.exe");

        logger.info("Setup webdriver");
        DriverWrapper.setDriver("chrome", false);
//        DriverWrapper.setPageLoadTimeOut();
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Quit webdriver");
        DriverWrapper.closeBrowser();
    }
}
