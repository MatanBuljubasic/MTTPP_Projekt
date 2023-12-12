package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pom.RedditHomePage;

public class RedditBaseTest {

    public WebDriver driver;
    Wait<WebDriver> delay;

    @BeforeClass
    public void setupTest() {

        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(RedditHomePage.URL);
        delay = new WebDriverWait(driver, 2);
    }

    @AfterClass
    public void teardownTest() {

        driver.quit();
    }

}
