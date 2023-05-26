package com.insider.interview.pages;

import com.insider.interview.helper.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BaseMethods {

    private String homePageUrl = "https://useinsider.com/";
    private By navigationBarMenusBy = By.id("mega-menu-1");
    private By sectionsInDropDowmMenuBy = By.cssSelector(".dropdown-item .flex-row a h5");
    private By btnAcceptCookiesBy = By.id("wt-cli-accept-all-btn");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage() {
        getUrl(homePageUrl);
        click(btnAcceptCookiesBy);
    }

    public void clickMenuInNavigationBar(String menuName) {
        clickWebElement(getElementWithTextInList(navigationBarMenusBy, menuName));
    }

    public CareersPage clickSubitemInDropdownMenu(String sectionName) {
        clickWebElement(getElementWithTextInList(sectionsInDropDowmMenuBy, sectionName));
        return new CareersPage(driver);
    }
}
