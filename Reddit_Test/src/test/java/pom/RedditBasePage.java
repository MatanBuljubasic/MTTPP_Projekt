package pom;

import io.github.sukgu.support.ElementFieldDecorator;
import io.github.sukgu.support.FindElementBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class RedditBasePage {

    public static String baseURL = "https://www.reddit.com";
    WebDriver driver;
    ElementFieldDecorator decorator;

    @FindBy(id = "reddit-logo")
    WebElement Logo;

    @FindBy(id = "login-button")
    WebElement LoginButton;

    @FindElementBy(css = "input[name='q']")
    WebElement SearchBar;

    public RedditBasePage(WebDriver driver){
        this.driver = driver;
        decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));
        PageFactory.initElements(decorator, this);
    }

}
