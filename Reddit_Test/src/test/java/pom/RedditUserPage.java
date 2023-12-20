package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RedditUserPage extends RedditBasePage {

    @FindBy(xpath = "/html/body/shreddit-app/div/main/div[1]/div[2]/div/div/div/div/div/h1")
    WebElement UserName;

    @FindBy(xpath = "/html/body/shreddit-app/div/main/div[2]/faceplate-tabgroup/a[1]/span/span/faceplate-tracker/span")
    WebElement OverviewLabel;

    @FindBy(xpath = "/html/body/shreddit-app/div/main/div[2]/faceplate-tabgroup/a[2]/span/span/faceplate-tracker/span")
    WebElement PostsLabel;

    @FindBy(xpath = "/html/body/shreddit-app/div/main/div[2]/faceplate-tabgroup/a[3]/span/span/faceplate-tracker/span")
    WebElement CommentsLabel;

    @FindBy(xpath = "/html/body/shreddit-app/div/section/div/div/div[4]/div[1]/p[2]")
    WebElement PostKarmaLabel;

    public static String URL = "https://www.reddit.com/user/Nice-Cup582";

    public RedditUserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(decorator, this);
    }

    public void checkUserName(String givenUserName){
        Assert.assertEquals(givenUserName, UserName.getText());
    }

    public void checkOverViewLabel(){
        Assert.assertTrue(OverviewLabel.isDisplayed());
    }

    public void checkPostsLabel(){
        Assert.assertTrue(PostsLabel.isDisplayed());
    }

    public void checkCommentsLabel(){
        Assert.assertTrue(CommentsLabel.isDisplayed());
    }

    public void checkPostKarmaLabel(){
        Assert.assertEquals(PostKarmaLabel.getText(), "Post Karma");
    }
}
