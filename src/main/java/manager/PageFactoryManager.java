package manager;

import org.openqa.selenium.WebDriver;
import pagefactory.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return new HomePage(driver);
    }

    public SearchPage getSearchPage(){
        return new SearchPage(driver);
    }

    public SignInPage getSignInPage(){
        return new SignInPage(driver);
    }

    public SignUpPage getSignUpPage(){
        return new SignUpPage(driver);
    }

    public AddToCartPage getAddToCartPage(){
        return new AddToCartPage(driver);
    }

    public ProductPage getProductPage(){
        return new ProductPage(driver);
    }

    public GiftCardsPage getGiftCardsPage(){
        return new GiftCardsPage(driver);
    }
}
