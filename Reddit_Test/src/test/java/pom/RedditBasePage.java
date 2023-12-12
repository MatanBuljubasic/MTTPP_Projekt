package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RedditBasePage {

    public static WebElement logo(WebDriver driver){

        return driver.findElement(By.id("reddit-logo"));
    }

    public static WebElement searchBar(WebDriver driver){

        return driver.findElement(By.name("q"));
    }

    public static WebElement loginButton(WebDriver driver){

        return driver.findElement(By.id("login-button"));
    }

}
