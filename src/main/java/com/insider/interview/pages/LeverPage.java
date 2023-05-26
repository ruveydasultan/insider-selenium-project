package com.insider.interview.pages;

import com.insider.interview.helper.BaseMethods;
import org.openqa.selenium.WebDriver;

public class LeverPage extends BaseMethods {
    private String URL = "lever.co";

    public LeverPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLeverPageOpened() throws InterruptedException {
        Thread.sleep(3000);
        return driver.getCurrentUrl().contains(URL);
    }

    public void switchLeverTab() {
        switchToTab();
    }
}
