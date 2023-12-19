package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pom.RedditHomePage;

public class RedditBaseTest {

    public WebDriver driver;
    public Shadow shadow;
    Wait<WebDriver> delay;

    @BeforeClass
    @Parameters("browser")
    public void setupTest(String browser) {

        if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        shadow = new Shadow(driver);
        driver.navigate().to(RedditHomePage.URL);
        delay = new WebDriverWait(driver, 2);
    }

    @AfterClass
    public void teardownTest() {

        driver.quit();
    }

}
