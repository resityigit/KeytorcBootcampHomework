package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    @FindBy (id = "email")
    public WebElement emailInput;
    @FindBy (id = "pass")
    public WebElement passwordInput;
    @FindBy (id = "login-button")
    public WebElement loginBTN;


    public void enterUsernameAndPassword(String mail,String password){
        emailInput.sendKeys(mail);
        passwordInput.sendKeys(password);
        loginBTN.click();
    }

}
