package com.insider.interview.pages;

import com.insider.interview.helper.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CareersPage extends BaseMethods {
    private By teamSectionBy = By.id("career-find-our-calling");
    private By locationsSectionBy = By.id("career-our-location");
    private By lifeAtInsiderSectionBy = By.cssSelector("[data-id='a8e7b90']");
    private By btnSeeAllTeamsBy = By.cssSelector("#career-find-our-calling .btn");

    private By btnJobTitlesBy = By.cssSelector(".job-title a h3");

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTeamSectionExist() {
        return isElementExist(teamSectionBy);
    }

    public boolean isLocationsSectionExist() {
        return isElementExist(locationsSectionBy);
    }

    public boolean isLifeAtInsiderSectionExist() {
        return isElementExist(lifeAtInsiderSectionBy);
    }

    public void clickSeeAllTeams() throws InterruptedException {
        scrollToElement(btnSeeAllTeamsBy);
        Thread.sleep(3000);
        click(btnSeeAllTeamsBy);
        Thread.sleep(3000);
    }

    public TeamPage clickTeamPage(String teamName) throws InterruptedException {
        WebElement teamElement = getElementWithTextInList(btnJobTitlesBy, teamName);
        Thread.sleep(3000);
        scrollToElement(teamElement);
        Thread.sleep(3000);
        clickWebElement(teamElement);
        return new TeamPage(driver);
    }


}
