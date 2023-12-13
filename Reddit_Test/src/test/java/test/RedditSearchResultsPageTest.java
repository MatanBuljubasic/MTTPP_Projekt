package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.RedditHomePage;
import pom.RedditSearchResultsPage;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;


public class RedditSearchResultsPageTest extends RedditBaseTest{

    @Test
    public void searchResultsPageTest() throws InterruptedException {

        driver.manage().window().maximize();
        WebElement searchBar = RedditHomePage.searchBar(shadow);
        delay.until(ExpectedConditions.elementToBeClickable(searchBar));
        searchBar.sendKeys("bitcoin");
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement firstTitle = RedditSearchResultsPage.firstTitle(driver);
        Assert.assertTrue(containsIgnoreCase(firstTitle.getAttribute("aria-label"), "bitcoin"));

    }
}
