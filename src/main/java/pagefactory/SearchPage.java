package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
    private WebElement sortingByButton;

    @FindBy(xpath = "//a[contains(text(),'Price: Low to High')]")
    private WebElement ascendantOrderOfPriceButton;

    @FindBy(xpath = "//span[contains(@class,'a-price-whole')]")
    private List<WebElement> listOfWholePrice;

    public void clickOnSortingByButton(){
        sortingByButton.click();
    }

    public void clickOnAscendantOrderOfPriceButton(){
        ascendantOrderOfPriceButton.click();
    }

    public List<WebElement> getListOfWholePrice() {
        return listOfWholePrice;
    }

    public int getPriceOfElementOnSearchPage(int i) {
        return Integer.valueOf(listOfWholePrice.get(i).getText());
    }

}
