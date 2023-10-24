package core.wrapper.element;

import core.wrapper.driver.DriverWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import core.util.common.Constant;
import core.util.common.StopWatch;
import core.util.common.Timer;

public class ElementWrapper implements WebElement {
    private static final Logger logger = LogManager.getLogger(ElementWrapper.class);
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
        this._element = this.findElement(this._by);
    }

    public String getElementXpath() {
        return this._xpath;
    }

    public WebElement getElement() {
        return this._element;
    }

    @Override
    public SearchContext getShadowRoot() {
        return WebElement.super.getShadowRoot();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return this._driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        try {
            return this._driver.findElement(this._by);
        } catch (NoSuchElementException | InvalidSelectorException e) {
//            log.error(nsee.getMessage());
//            throw new RuntimeException(nsee);
            return null;
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public ElementWrapper findElement(String locator) {
        return new ElementWrapper(this.findElement(By.xpath(locator)));
    }

    public List<ElementWrapper> getElementList() {
        List<ElementWrapper> elementList = new ArrayList<>();
        try {
            int count = findElements(this._by).size();
            for (int i = 1; i <= count; i++) {
                elementList.add(new ElementWrapper(this._xpath + "[%d]", i));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
//            throw new RuntimeException(e);
        }
        return elementList;
    }

    public void waitForDisplay(int timeOut) {
        try {
            new WebDriverWait(this._driver, Duration.ofSeconds(timeOut))
                    .until(ExpectedConditions.visibilityOfElementLocated(this._by));
        } catch (Exception e) {
            logger.error(e.getMessage());
//            throw new RuntimeException(e);
        }
    }

    public void waitForDisplay() {
        this.waitForDisplay(this._elementTimeout);
    }

    public void scrollIntoView() {
        this.waitForDisplay();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) this._driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", this.getElement());
    }

    public void clear() {
        this.waitForDisplay();
        try {
            this.getElement().clear();
        } catch (Exception e) {
            logger.error(e.getMessage());
//            throw new RuntimeException(e);
        }
    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getDomProperty(String name) {
        return WebElement.super.getDomProperty(name);
    }

    @Override
    public String getDomAttribute(String name) {
        return WebElement.super.getDomAttribute(name);
    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public String getAriaRole() {
        return WebElement.super.getAriaRole();
    }

    @Override
    public String getAccessibleName() {
        return WebElement.super.getAccessibleName();
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public void click() {

    }

    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        this._element.sendKeys(keysToSend);
    }

    public void type(String value, boolean isWait) {
        if (!isWait) {
            Timer.sleep(1000);
        } else {
            this.waitForDisplay();
        }
        try {
            this.sendKeys(value);
        } catch (Exception e) {
            logger.error(e.getMessage());
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

    @Override
    public boolean isDisplayed() {
        return this.isDisplayed(this._elementTimeout);
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    public boolean isDisplayed(long timeOut) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.startClock();
        boolean isDisplay = false;

        while (stopWatch.getTimeLeftInSecond(timeOut) >= 0 && !isDisplay) {
            try {
                isDisplay = this.getElement().isDisplayed();
            } catch (NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
                logger.error(e.getMessage());
//            throw new RuntimeException(e);
            }
            Timer.sleep(500);
        }

        return isDisplay;
    }


    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
