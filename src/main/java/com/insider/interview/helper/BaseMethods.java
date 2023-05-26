package com.insider.interview.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BaseMethods {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected String firstTab;
    protected ArrayList<String> newTab;

    public BaseMethods(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(this.driver);
        this.wait = new WebDriverWait(driver, 5);
        firstTab = driver.getWindowHandle();
    }

    public void getUrl(String url) {
        driver.get(url);
    }

    public void click(By element) {
        waitToElement(element).click();
    }
    public void clickWebElement(WebElement element) {
        element.click();
    }

    public void sendKeys(By element, String text) {
        waitToElement(element).sendKeys(text);
    }

    public String getText(By element) {
        return waitToElement(element).getText();
    }

    public WebElement waitToElement(By element) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public List<WebElement> getElements(By element) {
        return driver.findElements(element);
    }

    public List<WebElement> getSubElements(WebElement webElement, By locator) {
        return webElement.findElements(locator);
    }
    public void moveToElement(By element) {
        actions.moveToElement(driver.findElement(element)).perform();
    }
    public void scrollToPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    public void scrollToElement(By element) {
        WebElement elementToScroll = driver.findElement(element);
        scrollToElement(elementToScroll);
    }
    public void scrollToElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})", element);
    }

    public boolean isElementExist(By element) {
        return driver.findElements(element).size() > 0;
    }
    public WebElement getElementWithTextInList(By element, String name){
        List<WebElement> elements = driver.findElements(element);
        for(WebElement item : elements){
            if (item.getText().contains(name)){
                return item;
            }
        }
        return null;
    }

    public void switchToTab() {
        newTab = new ArrayList<>(driver.getWindowHandles());
        newTab.remove(firstTab);
        driver.switchTo().window(newTab.get(0));
    }


    public void closeToTab() {
        driver.close();
        driver.switchTo().window(firstTab);
    }
}
