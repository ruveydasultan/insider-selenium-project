package com.insider.interview.pages;

import com.insider.interview.helper.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PositionsPage extends BaseMethods {
    By locationFilterBy = By.id("select2-filter-by-location-container");
    By positonsBy = By.cssSelector(".position-list-item");
    private By positionsDepartmentBy = By.cssSelector(".position-department");
    private By positionLocationBy = By.cssSelector(".position-location");
    private By genericButtonLocatorBy = By.cssSelector(".btn");

    public PositionsPage(WebDriver driver) {
        super(driver);
    }

    public void setLocationFilter(String location) throws InterruptedException {
        click(locationFilterBy);
        By locationSelection = By.xpath("//*[@class='select2-results__option'][text()='" + location + "']");
        scrollToElement(locationSelection);
        click(locationSelection);
        scrollToPage();
        Thread.sleep(3000);
    }

    public boolean isThereAnyPosition() {
        List<WebElement> positions = getElements(positonsBy);
        return positions.size() > 0;
    }

    public boolean isPositionsDepartmentTrue(String expectedName) {

        List<WebElement> positionList = driver.findElements(positionsDepartmentBy);
        for (WebElement position : positionList) {
            String department = position.getText();
            boolean isTextTrue = department.contains(expectedName);
            if (!isTextTrue) {
                return false;
            }
        }

        return true;
    }

    public boolean isPositionsLocationTrue(String expectedName) {
        List<WebElement> positionList = getElements(positionLocationBy);

        for (WebElement position : positionList) {
            boolean isTextTrue = position.getText().equals(expectedName);
            if (!isTextTrue) {
                return false;
            }
        }

        return true;
    }

    public boolean isPositionsHasApplyButton() {
        List<WebElement> positions = getElements(positonsBy);

        for (WebElement position : positions) {
            List<WebElement> applyButtons = getSubElements(position, genericButtonLocatorBy);
            if (applyButtons.size() < 1) {
                return false;
            }
        }

        return true;
    }

    public LeverPage clickApplyButtonForFirstPosition() {
        List<WebElement> positions = getElements(positonsBy);
        WebElement applyButton = getSubElements(positions.get(0), genericButtonLocatorBy).get(0);
        applyButton.click();
        return new LeverPage(driver);
    }


}
