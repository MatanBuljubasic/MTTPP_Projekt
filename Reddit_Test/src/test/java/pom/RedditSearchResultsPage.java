package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

public class RedditSearchResultsPage extends RedditBasePage {

    @FindBy(xpath = "/html/body/shreddit-app/search-dynamic-id-cache-controller/div/div/div[1]/div[2]/main/div/reddit-feed/faceplate-tracker[1]/post-consume-tracker/div/faceplate-tracker[1]/a")
    WebElement FirstTitle;

    public RedditSearchResultsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(decorator, this);
    }

    public void checkFirstTitle(){
        Assert.assertTrue(containsIgnoreCase(FirstTitle.getAttribute("aria-label"),"bitcoin"));
    }
}
