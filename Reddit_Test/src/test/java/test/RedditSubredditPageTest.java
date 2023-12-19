package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.RedditHomePage;
import pom.RedditSubredditPage;

public class RedditSubredditPageTest extends RedditBaseTest {

    @Test
    public void subredditPageTest() throws InterruptedException {

        String firstSubredditLink = null;
        driver.manage().window().maximize();
        delay.until(d -> ExpectedConditions.elementToBeClickable(RedditHomePage.firstSubreddit(driver)));
        WebElement firstSubreddit = RedditHomePage.firstSubreddit(driver);
        firstSubredditLink = firstSubreddit.getAttribute("href");
        firstSubreddit.click();
        Thread.sleep(2000);
        WebElement subredditTitle = RedditSubredditPage.subredditTitle(driver);
        WebElement aboutSidebar = RedditSubredditPage.aboutSidebar(driver);
        Assert.assertEquals(firstSubredditLink, RedditHomePage.URL + '/' + subredditTitle.getText());
        Assert.assertTrue(aboutSidebar.isDisplayed());
    }

}
