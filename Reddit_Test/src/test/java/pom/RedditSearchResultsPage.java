package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RedditSearchResultsPage extends RedditBasePage {

    public static WebElement firstTitle(WebDriver driver){

        return driver.findElement(By.xpath("/html/body/shreddit-app/search-dynamic-id-cache-controller/div/div/div[1]/div[2]/main/div/reddit-feed/faceplate-tracker[1]/post-consume-tracker/div/faceplate-tracker/a/span"));
    }

}
