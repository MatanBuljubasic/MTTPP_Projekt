package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RedditUserPage extends RedditBasePage{

    public static String URL = "https://www.reddit.com/user/Nice-Cup582";

    public static WebElement userName(WebDriver driver){

        return driver.findElement(By.xpath("/html/body/shreddit-app/div/main/div[1]/div[2]/div/div/div/div/div/h1"));
    }

    public static WebElement overviewLabel(WebDriver driver){

        return driver.findElement(By.xpath("/html/body/shreddit-app/div/main/div[2]/faceplate-tabgroup/a[1]/span/span/faceplate-tracker/span"));
    }

    public static WebElement postsLabel(WebDriver driver){

        return driver.findElement(By.xpath("/html/body/shreddit-app/div/main/div[2]/faceplate-tabgroup/a[2]/span/span/faceplate-tracker/span"));
    }

    public static WebElement commentsLabel(WebDriver driver){

        return driver.findElement(By.xpath("/html/body/shreddit-app/div/main/div[2]/faceplate-tabgroup/a[3]/span/span/faceplate-tracker/span"));
    }

    public static WebElement postKarmaLabel(WebDriver driver){

        return driver.findElement(By.xpath("/html/body/shreddit-app/div/section/div/div/div[4]/div[1]/p[2]"));
    }

}
