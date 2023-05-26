package com.insider.interview.pages;

import com.insider.interview.helper.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamPage extends BaseMethods {
    private By btnSeeAllJobsBy = By.cssSelector(".flex-column .button-group .btn");

    public TeamPage(WebDriver driver) {
        super(driver);
    }

    public PositionsPage clickSeeAllJobsButton() {
        click(btnSeeAllJobsBy);
        return new PositionsPage(driver);
    }
}
