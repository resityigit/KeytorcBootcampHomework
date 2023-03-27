package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "sortOptionsDesktop")
    public WebElement sortDropdown;
    @FindAll(@FindBy(css = "#productsLoad .product-list"))
    public List<WebElement> productList;
    @FindBy(className = "basketBTN")
    public WebElement addCartBTN;
    @FindBy(className = "goToBasket")
    public WebElement goToBasketBTN;

    @FindBy(css = ".fancy-modal-header .product-list__price")
    public WebElement productPrice;


    public enum sortOrders {
        UP, // Fiyata göre artan
        PU, // Fiyata Göre Azalan
        RA, // Değerlendirme Puanına Göre
        EY, // Eskiden Yeniye
        YE  // Yeniden Eskiye
    }

    public void selectCheapestProduct(int index) {
        productList.get(index).click();
    }

    public void addBasket() {
        addCartBTN.click();

    }

    public void modalGoToBasket() {
        goToBasketBTN.click();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }




}
