package com.trend.pages;

import com.trend.core.driver.TrendWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BasketPage extends TrendPageBase {

    @FindBy(css = "[class='description basketlist-productinfo-description']")
    private WebElement productName;

    public BasketPage(TrendWebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return productName.getAttribute("title");
    }
}
