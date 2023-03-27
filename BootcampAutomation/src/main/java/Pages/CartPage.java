package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    static WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(className = "btn-success")
    public WebElement successBTN;
    @FindBy(className = "basket-ordersummary__button")
    public WebElement orderSummaryBTN;

    public By cargosAction = By.className("basket-address__cargos-action");

    public void goToOrderSummaryPage() {
        orderSummaryBTN.click();

    }
    public void goToPaymentPage(){
        successBTN.click();
    }

    public static WebElement waitElementClickable(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public void waitCargosAction(){
        waitElementClickable(cargosAction);
    }
}
