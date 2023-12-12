package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.RedditHomePage;


public class RedditHomePageTest extends RedditBaseTest {

    @Test
    public void homePageTest() {

        driver.manage().window().maximize();
        WebElement redditLogo = RedditHomePage.logo(driver);
        delay.until(d -> redditLogo.isDisplayed());
        redditLogo.click();
        WebElement redditLogoAfter = RedditHomePage.logo(driver);
        WebElement redditSearchBar = RedditHomePage.searchBar(shadow);
        WebElement redditLoginButton = RedditHomePage.loginButton(driver);
        WebElement redditPosts = RedditHomePage.posts(driver);
        Assert.assertTrue(redditLogoAfter.isDisplayed());
        Assert.assertEquals(redditSearchBar.getAttribute("placeholder"), "Search Reddit");
        Assert.assertTrue(redditLoginButton.isDisplayed());
        Assert.assertTrue(redditPosts.isDisplayed());
    }

}
