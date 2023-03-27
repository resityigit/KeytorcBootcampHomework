package Test;

import Pages.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

public class BaseTest {

    static WebDriver driver;
    @BeforeAll
    public static void beforeAll(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")
                +"//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-plugins");
        driver = new ChromeDriver(options);
        driver.get("https://www.vatanbilgisayar.com");
        driver.manage().window().maximize();
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.acceptCookies();

    }

    @AfterAll
    public static void afterAll(){
        driver.quit();
    }
}
