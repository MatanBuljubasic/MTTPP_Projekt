package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RedditSinglePostPage extends RedditBasePage {

    @FindBy(id = "comment-tree")
    WebElement AllComments;
    @FindBy(xpath = "/html/body/shreddit-app/div/main/shreddit-async-loader[2]/comment-body-header/shreddit-async-loader/div/span")
    WebElement CommentSortByText;
    @FindBy(xpath = "/html/body/shreddit-app/div/main/shreddit-post/div[1]/span[2]/shreddit-async-loader[2]")
    WebElement PostOptions;

    public RedditSinglePostPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(decorator, this);
    }

    public void checkAllComments(){
        Assert.assertTrue(AllComments.isDisplayed());
    }

    public void checkCommentSortByText(){
        Assert.assertTrue(CommentSortByText.isDisplayed());
    }

    public void checkPostOptions(){
        Assert.assertTrue(PostOptions.isDisplayed());
    }

}
