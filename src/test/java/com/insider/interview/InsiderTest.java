package com.insider.interview;

import listener.ScreenshotListener;
import com.insider.interview.pages.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class InsiderTest extends BaseTest {
    @Test
    public void insiderTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        homePage.clickMenuInNavigationBar("More");
        CareersPage careersPage = homePage.clickSubitemInDropdownMenu("Careers");

        Assert.assertTrue(careersPage.isTeamSectionExist(), "Teams Section is not visible");
        Assert.assertTrue(careersPage.isLocationsSectionExist(), "Locations Section is not visible");
        Assert.assertTrue(careersPage.isLifeAtInsiderSectionExist(), "Life at Insider section is not visible");

        careersPage.clickSeeAllTeams();
        TeamPage teamPage = careersPage.clickTeamPage("Quality Assurance");

        PositionsPage positionsPage = teamPage.clickSeeAllJobsButton();
        positionsPage.setLocationFilter("Istanbul, Turkey");

        Assert.assertTrue(positionsPage.isThereAnyPosition(), "There is no position");
        Assert.assertTrue(positionsPage.isPositionsDepartmentTrue("Quality Assurance"), "Positions Department name is incorrect");
        Assert.assertTrue(positionsPage.isPositionsLocationTrue("Istanbul, Turkey"), "Positions Location is incorrect");
        Assert.assertTrue(positionsPage.isPositionsHasApplyButton(), "Positions has no apply button");

        LeverPage leverPage = positionsPage.clickApplyButtonForFirstPosition();
        leverPage.switchLeverTab();
        Assert.assertTrue(leverPage.isLeverPageOpened(), "Lever page is not opened");

    }
}
