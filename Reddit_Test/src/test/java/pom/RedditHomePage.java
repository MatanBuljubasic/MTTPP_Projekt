package pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RedditHomePage extends RedditBasePage{

    public static String URL = "https://www.reddit.com";

    public static WebElement posts(WebDriver driver){

        return driver.findElement(By.xpath("/html/body/shreddit-app/div/div[1]/div[2]/main/shreddit-feed"));
    }

    public static WebElement firstPost(WebDriver driver){

        return driver.findElement(By.xpath("/html/body/shreddit-app/div/div[1]/div[2]/main/shreddit-feed/article[1]/shreddit-post"));
    }

}
