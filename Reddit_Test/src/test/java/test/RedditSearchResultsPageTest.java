package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pom.RedditHomePage;


public class RedditSearchResultsPageTest extends RedditBaseTest{

    @Test
    public void singlePostPageTest() throws InterruptedException {

        driver.manage().window().maximize();
        WebElement searchBar = RedditHomePage.searchBar(driver);
        delay.until(ExpectedConditions.elementToBeClickable(searchBar));
        searchBar.click();
        searchBar.sendKeys("bitcoin");
        searchBar.submit();
        Thread.sleep(2000);

    }
}
