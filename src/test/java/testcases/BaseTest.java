package testcases;

import core.wrappers.DriverWrapper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod
    public void setupTest() {
        DriverWrapper.setDriver("chrome", false);
//        DriverWrapper.setPageLoadTimeOut();
    }

    @AfterMethod
    public void tearDown() {
        DriverWrapper.getDriver().quit();
    }
}
