package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddToCartPage extends BasePage{
    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@id='nav-cart']")
    private WebElement goToCartButton;

    @FindBy(xpath = "//input[@value='Compare with similar items']")
    private WebElement compareWithOtherItemsButton;

    @FindBy(xpath = "//span[contains(@class,'a-spacing-top-small ')]//input[@class='a-button-input']")
    private List<WebElement> listOfComparingProducts;

    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//h2[contains(text(),'Your Amazon Cart is empty')]")
    private WebElement textInEmptyCart;

    public WebElement getTextAddedToCart() {
        return textAddedToCart;
    }

    @FindBy(xpath = "//h1[contains(text(),'Added to Cart')]")
    private WebElement textAddedToCart;

    private static final String ADDED_TO_CART = "//h1[contains(text(),'Added to Cart')]";

    public By getAddedToCart(){
        return By.xpath(ADDED_TO_CART);
    }

    public WebElement getTextInEmptyCart(){
        return textInEmptyCart;
    }

    public void clickOnDeleteButton(){
        deleteButton.click();
    }

    public List<WebElement> getListOfComparingProducts() {
        return listOfComparingProducts;
    }

    public void clickOnCompareWithOtherItemsButton(){
        compareWithOtherItemsButton.click();
    }

    public void clickOnAddToCartButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButton).click().perform();
        actions.release().perform();
    }

    public void clickOnGoToCartButton(){
        goToCartButton.click();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

}
