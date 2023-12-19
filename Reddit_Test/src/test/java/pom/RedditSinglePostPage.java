package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RedditSinglePostPage extends RedditBasePage{

    public static WebElement allComments(WebDriver driver){

        return driver.findElement(By.id("comment-tree"));
    }

    public static WebElement commentSortByText(WebDriver driver){

        return driver.findElement(By.xpath("/html/body/shreddit-app/div/main/shreddit-async-loader[2]/comment-body-header/shreddit-async-loader/div/span"));
    }

    public static WebElement postOptions(WebDriver driver){

        return driver.findElement(By.xpath("/html/body/shreddit-app/div/main/shreddit-post/div[1]/span[2]/shreddit-async-loader[2]"));
    }


}
