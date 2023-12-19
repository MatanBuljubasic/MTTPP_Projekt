package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.RedditHomePage;
import pom.RedditSinglePostPage;


public class RedditSinglePostPageTest extends RedditBaseTest {

    @Test
    public void singlePostPageTest() throws InterruptedException {

        driver.manage().window().maximize();
        delay.until(d -> ExpectedConditions.elementToBeClickable(RedditHomePage.firstPost(driver)));
        WebElement firstPost = RedditHomePage.firstPost(driver);
        firstPost.click();
        Thread.sleep(2000);
        WebElement postOptions = RedditSinglePostPage.postOptions(driver);
        WebElement allComments = RedditSinglePostPage.allComments(driver);
        WebElement commentSortByText = RedditSinglePostPage.commentSortByText(driver);
        Assert.assertTrue(allComments.isDisplayed());
        Assert.assertTrue(commentSortByText.isDisplayed());
        Assert.assertTrue(postOptions.isDisplayed());
    }

}
