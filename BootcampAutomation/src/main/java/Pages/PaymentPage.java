package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage {
    WebDriver driver;
    public PaymentPage(WebDriver driver) {
        this.driver=driver;
    }
    @FindBy(css = ".basket-cart__product-price span")
    public WebElement paymentProductPrice;
    @FindBy(className = "navbar-brand")
    public WebElement homePageIcon;

    public String paymentPrice() {
        return paymentProductPrice.getText();
    }
    public void goToHomePage(){
        homePageIcon.click();
    }
}
