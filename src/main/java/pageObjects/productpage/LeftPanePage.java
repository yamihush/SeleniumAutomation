package pageObjects.productpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LeftPanePage {

    public WebDriver driver;

    public LeftPanePage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "add-to-cart-button")
    WebElement addToCartButton;

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public void setAddToCartButton(WebElement addToCartButton) {
        this.addToCartButton = addToCartButton;
    }
}
