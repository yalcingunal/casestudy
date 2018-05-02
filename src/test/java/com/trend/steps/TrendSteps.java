package com.trend.steps;

import com.trend.pages.BasketPage;
import com.trend.pages.ProductPage;
import com.trend.pages.SSPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Random;


public class TrendSteps {
    private SSPage ssPage;
    private ProductPage productPage;
    private BasketPage basketPage;

    private String currentProduct;

    public TrendSteps(SSPage ssPage, ProductPage productPage, BasketPage basketPage) {
        this.ssPage = ssPage;
        this.productPage = productPage;
        this.basketPage = basketPage;
    }

    @Given("^Customer is on the HomePage$")
    public void iVisitSsHomepage() throws Throwable {
        ssPage.navigate();
    }


    @And("^Customer login with \"([^\"]*)\" email and \"([^\"]*)\" password$")
    public void customerLoginWithEmailPassword(String email, String password) {
        ssPage.loginWithEmailAndPassword(email, password);
    }

    @Then("^Customer should see \"([^\"]*)\" text on UserIcon$")
    public void customerShouldSeeTextOnUserIcon(String name) throws Throwable {
        Thread.sleep(2000);
        Assert.assertEquals("Customer can not sign in", name, ssPage.getLoginContainertext());
    }

    @When("^Customer visits \"([^\"]*)\" main category$")
    public void customerVisitsMainCategory(int categoryNum) throws Throwable {
        ssPage.visitCategoryWithIndex(categoryNum);
    }

    @Then("^Customer should see all images on Category$")
    public void customerShouldSeeAllImagesOnCategory() throws Throwable {
        Assert.assertEquals(ssPage.checkBoutiqueImageStatus(), false);
    }

    @And("^Customer visits random main category$")
    public void customerVisitsRandomMainCategory() throws Throwable {
        ssPage.visitCategoryWithIndex(1 + new Random().nextInt(ssPage.getCategoriesSize()));
    }

    @And("^Customer visits random Boutique$")
    public void customerVisitsRandomBoutique() throws Throwable {
        ssPage.visitBoutiqueWithIndex(new Random().nextInt(ssPage.getBoutiqueSize()));
    }

    @Then("^Customer should see all images on Boutique$")
    public void customerShouldSeeAllImagesOnBoutique() throws Throwable {
        Assert.assertEquals(ssPage.checkProductImageStatus(), false);
    }

    @When("^Customer adds to basket a random product$")
    public void customerAddsToBasketARandomProduct() throws Throwable {
        ssPage.visitProductWithIndex(new Random().nextInt(ssPage.getProductSize()));
        productPage.selectFirstSize();
        productPage.addToBasket();
        currentProduct = productPage.getProductName();
    }

    @Then("^Customer should see selected product in the basket$")
    public void customerShouldSeeSelectedProductInTheBasket() throws Throwable {
        ssPage.visitToBasket();
        Assert.assertEquals(basketPage.getProductName(), currentProduct);
    }

//    @After
//    public void tearDown() {
//        if (ssPage.getBasketItemCountIsVisible())
//            System.out.println("---------teardown---------");
//    }
}
