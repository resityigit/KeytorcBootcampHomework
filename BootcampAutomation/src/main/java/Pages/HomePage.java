package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {
    static WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(id = "btnMyAccount")
    public WebElement headerLoginBTN;
    @FindBy(linkText = "Giriş Yap")
    public WebElement dropdownLoginBTN;
    @FindBy(xpath = "//*[contains(@class,'dropdown-menu-home')]//*[text()='ÇIKIŞ ']")
    public WebElement dropdownLogOutBTN;
    @FindBy(id = "navbar-search-input")
    public WebElement searchInput;

    @FindBy(className = "search__button")
    public WebElement searchBTN;

    @FindBy(id = "suggestionSearchİtem")
    public WebElement suggestionSearch;

    @FindBy(className = "banner-accept-button")
    public WebElement acceptCookiesBTN;

    @FindBy(id = "smsComfirmCloseBtn")
    public WebElement smsCloseBTN;

    public void goToLoginPage() {
        headerLoginBTN.click();
        dropdownLoginBTN.click();
    }

    public void searchKeyword(String keyword) {
        searchInput.click();
        searchInput.sendKeys(keyword);
        searchBTN.click();
    }

    public void logOut() {
        headerLoginBTN.click();
        dropdownLogOutBTN.click();
    }

    public static WebElement waitElementClickable(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public String getText(WebElement webElement) {
        return webElement.getText();
    }
    public void acceptCookies(){
        acceptCookiesBTN.click();
    }
    public void smsClose(){
        smsCloseBTN.click();
    }
}
