package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.RedditHomePage;
import pom.RedditSinglePostPage;


public class RedditSinglePostPageTest extends RedditBaseTest {

    @Test
    public void singlePostPageTest() throws InterruptedException {

        driver.manage().window().maximize();
        WebElement firstPost = RedditHomePage.firstPost(driver);
        delay.until(d -> firstPost.isDisplayed());
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
