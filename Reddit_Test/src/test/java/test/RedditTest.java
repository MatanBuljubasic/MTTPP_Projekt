package test;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pom.RedditBasePageSkeletor;
import pom.RedditHomePageSkeletor;
import pom.RedditSinglePostPageSkeletor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class RedditTest {

    WebDriver driver;
    RedditHomePageSkeletor redditHomePageSkeletor;
    RedditSinglePostPageSkeletor redditSinglePostPageSkeletor;
    Capabilities capabilities;

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
        driver.navigate().to(RedditBasePageSkeletor.baseURL);
    }

    @Test
    public void testHomePage(){
        redditHomePageSkeletor = new RedditHomePageSkeletor(driver);
        redditHomePageSkeletor.checkSearchBar();
        redditHomePageSkeletor.checkLogo();
        redditHomePageSkeletor.checkLoginButton();
        redditHomePageSkeletor.checkPosts();
    }

    @Test
    public void testSinglePostPage(){
        redditHomePageSkeletor = new RedditHomePageSkeletor(driver);
        redditSinglePostPageSkeletor = new RedditSinglePostPageSkeletor(driver);
        redditHomePageSkeletor.clickFirstPost();
        redditSinglePostPageSkeletor.checkPostOptions();
        redditSinglePostPageSkeletor.checkAllComments();
        redditSinglePostPageSkeletor.checkCommentSortByText();
    }

    @AfterTest
    public void teardownTest() {
        driver.quit();
    }

}
