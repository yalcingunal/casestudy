package com.trend.pages;

import com.trend.core.configuration.AppSettings;
import com.trend.core.driver.TrendWebDriver;
import com.trend.helpers.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

abstract class TrendPageBase extends PageBase {

    @FindBy(id = "AutoCompleteBox")
    private WebElement searchTextBox;

    @FindBy(css = "[class='icon icon-header-search-button']")
    private WebElement searchButton;

    @FindBy(css = "[class='login-container']")
    private WebElement loginIcon;

    @FindBy(css = "[class='login-container']")
    private WebElement loginContainertext;

    @FindBy(css = "[class='icon icon-favorites']")
    private WebElement myFavoriteIcon;

    @FindBy(css = "[class='icon icon-basket']")
    private WebElement basketIcon;

    @FindBy(id = "basketItemCount")
    private WebElement basketItemCount;

    @FindBy(css = "[class='login']")
    private WebElement loginPopup;

    @FindBy(id = "email")
    private WebElement emailTextBox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "loginSubmit")
    private WebElement loginButton;

    @FindBy(css = "[class='homepage-popup']")
    private WebElement mainPopup;

    @FindBy(css = "[class='fancybox-item fancybox-close']")
    private WebElement mainPopupCloseButton;

    @FindBy(css = "[class='tabLink']")
    private List<WebElement> categories;

    TrendPageBase(TrendWebDriver driver) {
        super(driver);
    }

    public void navigate() throws InterruptedException {
        driver.get(String.join("/", AppSettings.Instance.BaseUrl));
        if (mainPopup.isDisplayed())
            mainPopupCloseButton.click();
        Thread.sleep(4000);
    }

    public void loginWithEmailAndPassword(String email, String password) {
        waitUntilClickable(loginIcon).click();
        waitUntilBeingWebElement(loginPopup, System.currentTimeMillis());
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        loginButton.click();
    }

    public void visitCategoryWithIndex(int categoryNum) throws InterruptedException {
        if (categoryNum == 1)
            return;
        Thread.sleep(5000);
        categories.get(categoryNum - 2).click();
    }

    public void visitToBasket() {
        basketIcon.click();
    }

    public int getCategoriesSize() {
        return categories.size();
    }

    public String getLoginContainertext() {
        return loginContainertext.getText();
    }

    public int getBasketItemCount() {
        return Integer.parseInt(basketItemCount.getText());
    }

    public boolean getBasketItemCountIsVisible() {
        return basketItemCount.isDisplayed();
    }
}
