package Test;

import Pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WebTest extends BaseTest {
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
    CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
    PaymentPage paymentPage = PageFactory.initElements(driver, PaymentPage.class);

    @Test
    public void webTestCase() {
        String searchKeyword = "Telefon";

        homePage.goToLoginPage();
        loginPage.enterUsernameAndPassword("fortestautomation34@gmail.com", "7p14flyw");
        Assertions.assertTrue(homePage.getText(homePage.headerLoginBTN).contains("HESABIM"), "Does not match");
        homePage.searchKeyword(searchKeyword);
        Assertions.assertTrue(homePage.getText(homePage.suggestionSearch).contains(searchKeyword), "Does no match");
        Select sortSelect = new Select(productPage.sortDropdown);
        sortSelect.selectByValue(ProductPage.sortOrders.UP.toString());
        productPage.selectCheapestProduct(0);
        productPage.addBasket();
        String price = productPage.getProductPrice();
        productPage.modalGoToBasket();
        cartPage.goToOrderSummaryPage();
        cartPage.waitCargosAction();
        cartPage.goToPaymentPage();
        String paymentPrice = paymentPage.paymentPrice();
        Assertions.assertTrue(paymentPrice.contains(price),"Price did not match");
        paymentPage.goToHomePage();
        homePage.smsClose();
        homePage.logOut();
    }

}
