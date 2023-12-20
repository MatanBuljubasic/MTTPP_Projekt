package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RedditSubredditPage extends RedditBasePage {

    @FindBy(xpath = "/html/body/shreddit-app/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[1]")
    WebElement SubredditTitle;

    @FindBy(id = "right-sidebar-container")
    WebElement AboutSidebar;

    public RedditSubredditPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(decorator, this);
    }

    public void checkSubredditTitle(String firstSubredditLink){
        Assert.assertEquals(firstSubredditLink, RedditBasePage.baseURL + '/' + SubredditTitle.getText());
    }

    public void checkAboutSidebar(){
        Assert.assertTrue(AboutSidebar.isDisplayed());
    }
}
