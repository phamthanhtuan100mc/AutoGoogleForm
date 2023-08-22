package core.wrappers;

import core.utils.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementWrapper {
    private String _xpath;
    private final int _elementTimeout = Constant.WAIT_TIMEOUT; //In second
    private By _by;
    private WebDriver driver = DriverWrapper.getInstance().getDriver();
    private Actions action;
    private WebElement _element;

//    public ElementWrapper(By by) {
//        this._by = by;
//    }

    public ElementWrapper(String locator, Object... args) {
        if (args != null && args.length > 0) {
            locator = String.format(locator, args);
        }

        this._xpath = locator;
        this._by = By.xpath(this._xpath);
        this._element = driver.findElement(this._by);
    }

    public String getElementXpath() {
        return this._xpath;
    }

    public WebElement getElement() {
        return this._element;
    }
}
