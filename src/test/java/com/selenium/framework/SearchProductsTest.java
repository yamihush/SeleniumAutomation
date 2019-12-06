package com.selenium.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import utils.AddProductsToCart;

import java.io.IOException;

public class SearchProductsTest extends Base {

    public static Logger log =LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void intialize() throws IOException {
        log.info("Variable Intialized");
    }

    @Test
    public void SearchBestSellerProducts() throws IOException, InterruptedException {
        driver = intializeDriver();
        driver.get(prop.getProperty("URL"));
        log.info("Entered in to the URL :" + prop.getProperty("URL"));

        HomePage homePage = new HomePage(driver);
        homePage.search("Headphones");

        AddProductsToCart addProductsToCart = new AddProductsToCart(driver);
        addProductsToCart.addAllProductsToCartByTag("Best Seller");

        homePage.getCartButton().click();

        System.out.println(homePage.getCartButton().getText());
    }

    @AfterSuite
    public void TearDown(){
        driver.close();
    }
}
