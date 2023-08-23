package testcases;

import core.wrappers.DriverWrapper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        DriverWrapper.setDriver("chrome", false);
    }

    @AfterMethod
    public void afterMethod() {
        DriverWrapper.getDriver().quit();
    }
}
