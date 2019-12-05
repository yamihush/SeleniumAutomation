package com.selenium.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ProductSearchPage;
import pageObjects.productpage.LeftPanePage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        HomePage hp = new HomePage(driver);
        hp.getSearchBox().sendKeys("Headphones");
        hp.getSearchButton().click();
        log.debug("Clicked the search button Link ");

        ProductSearchPage productSearchPage = new ProductSearchPage(driver);
        List<WebElement> srchResults  = productSearchPage.getAllLists("Best Seller");
        log.debug("get all the Best Seller products ");

        LeftPanePage leftPanePage = new LeftPanePage(driver);

        for (int x = 0; x < srchResults.size(); x++) {
            WebElement singleElement = srchResults.get(x);

            // Store all currently open tabs in tabs
            Actions newTab = new Actions(driver);

            newTab.keyDown(Keys.CONTROL).click(productSearchPage.getProductLabel(singleElement)).keyUp(Keys.CONTROL).build().perform();

            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());

            // Switch newly open Tab
            driver.switchTo().window(tabs.get(1));

            //click on add to cart button
            leftPanePage.getAddToCartButton().click();

            Thread.sleep(2000);  //For Test Purpose
            // Close newly open tab after performing some operations.
            driver.close();

            // Switch to old(Parent) tab.
            driver.switchTo().window(tabs.get(0));
        }

        hp.getCartButton().click();

        Thread.sleep(2000);  //For Test Purpose
        System.out.println(hp.getCartButton().getText());

    }

}
