package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RedditSubredditPage extends RedditBasePage{

    public static WebElement subredditTitle(WebDriver driver){

        return driver.findElement(By.xpath("/html/body/shreddit-app/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div[1]"));
    }

    public static WebElement aboutSidebar(WebDriver driver){

        return driver.findElement(By.id("right-sidebar-container"));
    }
}
