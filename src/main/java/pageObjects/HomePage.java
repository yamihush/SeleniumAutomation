package pageObjects;

import com.selenium.framework.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;


public class HomePage {

    public WebDriver driver;
    public static Logger log =LogManager.getLogger(Base.class.getName());

    public HomePage(WebDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(css = "#twotabsearchtextbox" )
     WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"nav-search\"]/form/div[2]/div/input" )
    WebElement searchButton;

    @FindBy(id = "nav-cart-count")
    WebElement cartButton;

    public WebElement getCartButton() {
        return cartButton;
    }

    public void setCartButton(WebElement cartButton) {
        this.cartButton = cartButton;
    }

    public WebElement getSearchBox() {
        return searchBox;
    }

    public void setSearchBox(WebElement searchBox) {
        this.searchBox = searchBox;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(WebElement searchButton) {
        this.searchButton = searchButton;
    }

    public void search(String item){
        getSearchBox().sendKeys(item);
        getSearchButton().click();
        log.debug("Clicked the search button Link ");
    }
}
