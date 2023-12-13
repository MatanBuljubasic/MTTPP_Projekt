package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.RedditHomePage;
import pom.RedditSinglePostPage;
import pom.RedditUserPage;

public class RedditUserPageTest extends RedditBaseTest{

    @Test
    public void userPageTest() throws InterruptedException {

        String postAuthorName = null;
        driver.manage().window().maximize();
        WebElement firstPost = RedditHomePage.firstPost(driver);
        delay.until(d -> firstPost.isDisplayed());
        firstPost.click();
        Thread.sleep(2000);
        WebElement postAuthor = RedditSinglePostPage.postAuthor(driver);
        postAuthorName = postAuthor.getText();
        postAuthor.click();
        Thread.sleep(2000);
        WebElement userName = RedditUserPage.userName(driver);
        WebElement overviewLabel = RedditUserPage.overviewLabel(driver);
        WebElement postsLabel = RedditUserPage.postsLabel(driver);
        WebElement commentsLabel = RedditUserPage.commentsLabel(driver);
        WebElement postKarmaLabel = RedditUserPage.postKarmaLabel(driver);
        Assert.assertEquals(postAuthorName, userName.getText());
        Assert.assertTrue(overviewLabel.isDisplayed());
        Assert.assertTrue(postsLabel.isDisplayed());
        Assert.assertTrue(commentsLabel.isDisplayed());
        Assert.assertEquals(postKarmaLabel.getText(), "Post Karma");
    }
}
