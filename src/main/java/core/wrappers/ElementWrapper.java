package core.wrappers;

import core.util.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import core.util.Timer;

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

    public ElementWrapper(WebElement element) {
        this._element = element;
    }

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

    public List<WebElement> getElementList() {
        try {
            return driver.findElements(this._by);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void waitForDisplay(int timeOut) {
        try {
            new WebDriverWait(this.driver, Duration.ofSeconds(timeOut))
                    .until(ExpectedConditions.visibilityOfElementLocated(this._by));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void waitForDisplay() {
        this.waitForDisplay(this._elementTimeout);
    }

    public void clear() {
        this.waitForDisplay();
        try {
            this.getElement().clear();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void type(String value, boolean isWait) {
        if (!isWait) {
            Timer.sleep(1000);
        } else {
            this.waitForDisplay();
        }
        try {
            this.getElement().sendKeys(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void type(String value) {
        this.type(value, true);
    }

    public void enter(String value) {
        this.clear();
        this.type(value);
    }


}
