package utils;

import base.TestBase;
import constants.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class BrowserUtil extends TestBase {
    public static WebElement getWebElement(WebElement referenceElement, FindBy findBy, String locatorPath) {
        return referenceElement.findElement(by(findBy, locatorPath));
    }

    public static WebElement getWebElement(FindBy findBy, String locatorPath) {
        return webDriver.findElement(by(findBy, locatorPath));
    }

    public static List<WebElement> getWebElements(FindBy findBy, String locatorPath) {
        return webDriver.findElements(by(findBy, locatorPath));
    }

    public List<WebElement> getWebElements(WebElement element, FindBy findBy, String locatorPath) {
        return element.findElements(by(findBy, locatorPath));
    }

    private static By by(FindBy findBy, String locatorPath) {
        switch (findBy) {
            case ID: {
                return By.id(locatorPath);
            }
            case NAME: {
                return By.name(locatorPath);
            }
            case XPATH: {
                return By.xpath(locatorPath);
            }
            case CSS: {
                return By.cssSelector(locatorPath);
            }
            case CLASS_NAME: {
                return By.className(locatorPath);
            }
            case TAG_NAME: {
                return By.tagName(locatorPath);
            }
            case LINK_TEXT: {
                return By.linkText(locatorPath);
            }
        }
        return null;
    }

    public static void sendText(FindBy findBy, String locatorPath, String value) {
        WebElement element = getWebElement(findBy, locatorPath);
        element.clear();
        element.sendKeys(value);
    }

    public boolean isTextPresentInBody(String search) {
        WebElement body = getWebElement(FindBy.TAG_NAME, "body");
        if (body.getText().contains(search))
            return true;
        return false;
    }

    public static void sendText(WebElement referenceElement, FindBy findBy, String locatorPath, String value) {
        WebElement element = getWebElement(referenceElement, findBy, locatorPath);
        element.clear();
        element.sendKeys(value);
    }

    public static void sendText(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public static void clickElement(FindBy findBy, String locatorPath) {
        WebElement element = getWebElement(findBy, locatorPath);
        element.click();
    }

    public void clickElement(WebElement parentElement, FindBy findBy, String childLocatorPath) {
        WebElement childElement = getWebElement(parentElement, findBy, childLocatorPath);
        childElement.click();
    }



}
