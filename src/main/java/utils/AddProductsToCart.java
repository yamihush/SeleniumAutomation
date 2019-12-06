package utils;

import com.selenium.framework.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObjects.ProductSearchPage;
import pageObjects.productpage.LeftPanePage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddProductsToCart {

    WebDriver driver;
    public static Logger log =LogManager.getLogger(Base.class.getName());

    public AddProductsToCart(WebDriver driver) {
        this.driver = driver;
    }

    public void addAllProductsToCartByTag(String tag) throws IOException, InterruptedException {

        ProductSearchPage productSearchPage = new ProductSearchPage(driver);
        List<WebElement> srchResults = productSearchPage.getAllLists(tag);
        log.debug("get all the " + tag +" products ");

        LeftPanePage leftPanePage = new LeftPanePage(driver);

        for (int x = 0; x < srchResults.size(); x++) {
            WebElement singleElement = srchResults.get(x);

            // Store all currently open tabs in tabs
            Actions newTab = new Actions(driver);

            newTab.keyDown(Keys.CONTROL).click(productSearchPage.getProductLabel(singleElement)).keyUp(Keys.CONTROL).build().perform();

            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

            // Switch newly open Tab
            driver.switchTo().window(tabs.get(1));

            //click on add to cart button
            leftPanePage.getAddToCartButton().click();

            // Close newly open tab after performing some operations.
            driver.close();

            // Switch to old(Parent) tab.
            driver.switchTo().window(tabs.get(0));
        }
    }
}
