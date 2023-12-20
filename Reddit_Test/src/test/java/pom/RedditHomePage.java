package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RedditHomePage extends RedditBasePage {

    @FindBy(xpath = "/html/body/shreddit-app/div/div[1]/div[2]/main/shreddit-feed")
    WebElement Posts;

    @FindBy(xpath = "/html/body/shreddit-app/div/div[1]/div[2]/main/shreddit-feed/article[1]/shreddit-post")
    WebElement FirstPost;

    @FindBy(xpath = "/html/body/shreddit-app/div/div[1]/div[2]/section/section/div/div/li/ul/li[1]/a")
    WebElement FirstSubreddit;

    public RedditHomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(decorator, this);
    }

    public void clickFirstPost(){
        FirstPost.click();
    }

    public void checkPosts(){
        Assert.assertTrue(Posts.isDisplayed());
    }

    public void checkLogo(){
        Assert.assertTrue(Logo.isDisplayed());
    }

    public void checkSearchBar(){
        Assert.assertEquals(SearchBar.getAttribute("placeholder"), "Search Reddit");
    }
    public void inputSearchBar(){
        SearchBar.sendKeys("bitcoin");
        SearchBar.sendKeys(Keys.ENTER);
    }

    public void checkLoginButton(){
        Assert.assertTrue(LoginButton.isDisplayed());
    }

    public String getFirstSubredditLink(){
        return FirstSubreddit.getAttribute("href");
    }

    public void clickFirstSubreddit(){
        FirstSubreddit.click();
    }

}
