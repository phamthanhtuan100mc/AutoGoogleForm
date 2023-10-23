package core.wrapper.element;

import core.util.common.Constant;
import core.util.common.StopWatch;
import core.wrapper.driver.DriverWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import core.util.common.Timer;

public class ElementWrapper {
    private static final Logger log = LogManager.getLogger(ElementWrapper.class);
    private String _xpath;
    private final int _elementTimeout = Constant.WAIT_TIMEOUT; //In second
    private By _by;
    private final WebDriver _driver = DriverWrapper.getInstance().getDriver();
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
        this._element = getElement();
    }

    public String getElementXpath() {
        return this._xpath;
    }

    public WebElement findElement(By by) {
        return _driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return this._driver.findElements(by);
    }

    public WebElement getElement() {
        try {
            return findElement(this._by);
        } catch (NoSuchElementException | InvalidSelectorException e) {
//            log.error(nsee.getMessage());
//            throw new RuntimeException(nsee);
            return null;
        }
    }

    public List<ElementWrapper> getElementList() {
        List<ElementWrapper> elementList = new ArrayList<>();
        try {
            int count = findElements(this._by).size();
            for (int i = 1; i <= count; i++) {
                elementList.add(new ElementWrapper(this._xpath + "[%d]", i));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
//            throw new RuntimeException(e);
        }
        return elementList;
    }

    public void waitForDisplay(int timeOut) {
        try {
            new WebDriverWait(this._driver, Duration.ofSeconds(timeOut))
                    .until(ExpectedConditions.visibilityOfElementLocated(this._by));
        } catch (Exception e) {
            log.error(e.getMessage());
//            throw new RuntimeException(e);
        }
    }

    public void waitForDisplay() {
        this.waitForDisplay(this._elementTimeout);
    }

    public void scrollIntoView() {
        this.waitForDisplay();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) this._driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement());
    }

    public void clear() {
        this.waitForDisplay();
        try {
            this.getElement().clear();
        } catch (Exception e) {
            log.error(e.getMessage());
//            throw new RuntimeException(e);
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
            log.error(e.getMessage());
//            throw new RuntimeException(e);
        }
    }

    public void type(String value) {
        this.type(value, true);
    }

    public void enter(String value) {
        this.clear();
        this.type(value);
    }

    public boolean isDisplayed() {
        return this.isDisplayed(this._elementTimeout);
    }

    public boolean isDisplayed(long timeOut) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.startClock();
        boolean isDisplay = false;

        while (stopWatch.getTimeLeftInSecond(timeOut) >= 0 && !isDisplay) {
            try {
                isDisplay = this.getElement().isDisplayed();
            } catch (NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
                log.error(e.getMessage());
//            throw new RuntimeException(e);
            }
            Timer.sleep(500);
        }

        return isDisplay;
    }


}
