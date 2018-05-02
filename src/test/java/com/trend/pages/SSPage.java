package com.trend.pages;

import com.trend.core.driver.TrendWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SSPage extends TrendPageBase {

    @FindBy(css = "[class='butik-large-image']")
    private List<WebElement> boutiqueList;

    @FindBy(css = "[class='product-box']")
    private List<WebElement> productList;

    public SSPage(TrendWebDriver driver) {
        super(driver);
    }

    public int getBoutiqueSize() {
        return boutiqueList.size();
    }

    public void visitBoutiqueWithIndex(int index) {
        boutiqueList.get(index).click();
    }

    public int getProductSize() {
        return productList.size();
    }

    public void visitProductWithIndex(int index) {
        productList.get(index).click();
    }

    public boolean checkBoutiqueImageStatus() throws InterruptedException {
        Thread.sleep(5000);
        boolean imageUploadFail = false;
        for (WebElement boutiqueRow : boutiqueList) {
            scrollToElement(boutiqueRow);
            System.out.print(boutiqueRow.findElement(By.cssSelector("[class='butik-img-size']")).getAttribute("title"));
            if (boutiqueRow.findElements(By.cssSelector("[class='bigBoutiqueImage lazy-load-trigger loaded']")).size() == 1)
                System.out.println("--> image uploaded");
            else {
                imageUploadFail = true;
                System.out.println("--> image not uploaded");
            }

        }
        return imageUploadFail;
    }

    public boolean checkProductImageStatus() throws InterruptedException {
        Thread.sleep(5000);
        boolean imageUploadFail = false;
        for (WebElement product : productList) {
            scrollToElement(product);
            if (product.findElements(By.cssSelector("[lazy='loaded']")).size() == 1)
                System.out.println("--> image uploaded");
            else {
                imageUploadFail = true;
                System.out.println("--> image not uploaded");
            }
        }
        return imageUploadFail;
    }
}
