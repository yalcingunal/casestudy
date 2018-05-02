package com.trend.pages;

import com.trend.core.driver.TrendWebDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends TrendPageBase {

    @FindBy(css = "[class='btn dropdown-toggle bs-placeholder variant-picker-button']")
    private WebElement productSizeDropDown;

    @FindBy(css = "[data-original-index='1']")
    private WebElement firstSizeOption;

    @FindBy(css = "[class='add-to-basket-text']")
    private WebElement addToBasketButton;

    @FindBy(css = "[class='product-name-text']")
    private WebElement productName;

    public ProductPage(TrendWebDriver driver) {
        super(driver);
    }

    public String getProductName(){
        return productName.getText();
    }

    public void selectFirstSize() {
        try {
            productSizeDropDown.click();
            waitUntilClickable(firstSizeOption).click();
        } catch (NoSuchElementException e) {
            return;
        }

    }

    public void addToBasket() {
        waitUntilVisibleWebElement(addToBasketButton).click();
    }
}
