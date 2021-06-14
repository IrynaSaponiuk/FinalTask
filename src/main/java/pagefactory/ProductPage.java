package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Under $25')]")
    private WebElement under25DollarsParameter;

    @FindBy(xpath = "//span[contains(@class,'a-price-whole')]")
    private List<WebElement> listOfWholePrice;

    @FindBy(xpath = "//a[@tabindex='-1']//span[contains(text(),'HP')]")
    private WebElement hpSelector;

    @FindBy(xpath = "//span[contains(@class,'a-size-base-plus')]")
    private List<WebElement> listOfProductNames;

    public List<WebElement> getListOfProductNames() {
        return listOfProductNames;
    }

    public List<WebElement> getListOfWholePrice() {
        return listOfWholePrice;
    }

    public By getFirstPriceOnProductPage(){
        return By.xpath("//span[contains(@class,'a-price-whole')]");
    }

    public void clickOnHpSelector(){
        Actions actions = new Actions(driver);
        actions.moveToElement(hpSelector).click().perform();
        actions.release().perform();
    }

    public void setUnder25DollarsParameter(){
        Actions actions = new Actions(driver);
        actions.moveToElement(under25DollarsParameter).click().perform();
        actions.release().perform();
    }

    public int getPriceOfRandomElement(int i) {
       return Integer.valueOf(listOfWholePrice.get(i).getText());
    }
}
