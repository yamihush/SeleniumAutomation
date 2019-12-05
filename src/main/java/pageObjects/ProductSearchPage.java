package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class ProductSearchPage {

    public WebDriver driver;

    public ProductSearchPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div")
    private WebElement allLists;

    public List<WebElement> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<WebElement> searchResults) {
        this.searchResults = searchResults;
    }

    public List<WebElement> getAllLists(String text) {
        List<WebElement> list = allLists.findElements(By.xpath("//*[text()='" + text + "']")) ;
        return list;
    }

    public WebElement getProductLabel(WebElement product){

        return product.findElement(By.xpath("//*[text()='Best Seller']/ancestor::div[@class='sg-row']/following-sibling::div/descendant::h2"));
    }
}
