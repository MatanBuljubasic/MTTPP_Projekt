package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.RedditHomePage;
import pom.RedditSubredditPage;

public class RedditSubredditPageTest extends RedditBaseTest {

    @Test
    public void subredditPageTest() throws InterruptedException {

        String firstSubredditTitle = null;
        driver.manage().window().maximize();
        WebElement firstSubreddit = RedditHomePage.firstSubreddit(driver);
        delay.until(d -> firstSubreddit.isDisplayed());
        firstSubredditTitle = firstSubreddit.getAttribute("href");
        firstSubreddit.click();
        Thread.sleep(2000);
        WebElement subredditTitle = RedditSubredditPage.subredditTitle(driver);
        WebElement aboutSidebar = RedditSubredditPage.aboutSidebar(driver);
        Assert.assertEquals(firstSubredditTitle, RedditHomePage.URL + '/' + subredditTitle.getText());
        Assert.assertTrue(aboutSidebar.isDisplayed());
    }

}
