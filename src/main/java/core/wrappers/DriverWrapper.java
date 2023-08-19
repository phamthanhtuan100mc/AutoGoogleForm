package core.wrappers;

import core.factory.WebDriverFactory;

public class DriverWrapper extends WebDriverFactory {

    private DriverWrapper() {}

    private static DriverWrapper instance = new DriverWrapper();

}
