package test;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pom.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class RedditTest {

    WebDriver driver;
    RedditHomePage redditHomePage;
    RedditSinglePostPage redditSinglePostPage;
    RedditSearchResultsPage redditSearchResultsPage;
    RedditSubredditPage redditSubredditPage;
    RedditUserPage redditUserPage;
    Capabilities capabilities;
    String firstSubredditLink;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws MalformedURLException {
        if(browser.equalsIgnoreCase("chrome")){
            capabilities = new ChromeOptions();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            capabilities = new FirefoxOptions();
        }
        driver = new RemoteWebDriver(new URL("http://localhost:4444/"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void redirectToHomePage(){
        driver.navigate().to(RedditBasePage.baseURL);
    }

    @Test
    public void testHomePage(){
        redditHomePage = new RedditHomePage(driver);
        redditHomePage.checkSearchBar();
        redditHomePage.checkLogo();
        redditHomePage.checkLoginButton();
        redditHomePage.checkPosts();
    }

    @Test
    public void testSinglePostPage(){
        redditHomePage = new RedditHomePage(driver);
        redditSinglePostPage = new RedditSinglePostPage(driver);
        redditHomePage.clickFirstPost();
        redditSinglePostPage.checkPostOptions();
        redditSinglePostPage.checkAllComments();
        redditSinglePostPage.checkCommentSortByText();
    }

    @Test
    public void testSearchResultsPage(){
        redditHomePage = new RedditHomePage(driver);
        redditSearchResultsPage = new RedditSearchResultsPage(driver);
        redditHomePage.inputSearchBar();
        redditSearchResultsPage.checkFirstTitle();
    }

    @Test
    public void testSubredditPage(){
        redditHomePage = new RedditHomePage(driver);
        redditSubredditPage = new RedditSubredditPage(driver);
        firstSubredditLink = redditHomePage.getFirstSubredditLink();
        redditHomePage.clickFirstSubreddit();
        redditSubredditPage.checkSubredditTitle(firstSubredditLink);
        redditSubredditPage.checkAboutSidebar();
    }

    @Test
    public void testUserPage(){
        String postAuthorName = "Nice-Cup582";
        redditUserPage = new RedditUserPage(driver);
        driver.navigate().to(RedditUserPage.URL);
        redditUserPage.checkUserName(postAuthorName);
        redditUserPage.checkCommentsLabel();
        redditUserPage.checkOverViewLabel();
        redditUserPage.checkPostsLabel();
        redditUserPage.checkPostKarmaLabel();
    }

    @AfterTest
    public void teardownTest() {
        driver.quit();
    }

}
