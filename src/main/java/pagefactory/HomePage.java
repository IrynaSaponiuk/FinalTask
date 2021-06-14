package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='nav-line-2 ']//span[@class='nav-icon nav-arrow']")
    private WebElement accountsAndListsButton;

    @FindBy(xpath = "//a[@rel='nofollow']//span[contains(text(),'Sign in')]")
    private WebElement signInButton;

    @FindBy(xpath = "//span[contains(text(),'Sign Out')]")
    private WebElement signOutButton;

    @FindBy(xpath = "//a[text()='Sign in securely']")
    private WebElement signInSecurelyButton;

    @FindBy(xpath = "//span[@id='nav-your-amazon-text']")
    private WebElement yourAmazonText;

    @FindBy(xpath = "//a[@id='nav-global-location-popover-link']")
    private WebElement deliverToButton;

    @FindBy(xpath = "//span[@class='a-button-inner']//span[@role='radiogroup']")
    private WebElement chooseYourCountryButton;

    @FindBy(xpath = "//a[contains(text(),'Turkey')]")
    private WebElement chooseTurkeyFromTheList;

    @FindBy(xpath = "//span[@id='glow-ingress-line2']")
    private WebElement countryBoxOnTheTop;

    @FindBy(xpath = "//a[@id='nav-hamburger-menu']")
    private WebElement menuAll;

    @FindBy(xpath = "//a[@data-menu-id='5']")
    private WebElement electronicButton;

    @FindBy(xpath = "//a[contains(text(),'Headphones')]")
    private WebElement headphonesButton;

    @FindBy(xpath = "//a[@data-menu-id='6']")
    private WebElement computersButtonInMenu;

    @FindBy(xpath = "//a[contains(text(),'Monitors')]")
    private WebElement monitorsButtonInMenu;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchField;

    @FindBy(xpath = "//div[contains(text(),'Arts & Crafts')]")
    private WebElement artsAndCraftsButtonInMenu;

    @FindBy(xpath = "//a[contains(text(),'Painting,')]")
    private WebElement paintingDrawingArtSuppliesButtonInMenu;

    @FindBy(xpath = "//a[contains(text(),'Gift Cards')]")
    private WebElement giftCardsButton;

    private static final String GIFT_CARDS = "//a[contains(text(),'Gift Cards')]";

    private static final String ARTS_AND_CRAFTS = "//div[contains(text(),'Arts & Crafts')]";

    private static final String CHOOSE_COUNTRY = "//span[@class='a-button-inner']//span[@role='radiogroup']";

    private static final String DELIVER_TO = "//span[contains(text(),'Deliver to')]";

    private static final String DRAWING_ART_SUPPLIES = "//a[contains(text(),'Painting,')]";

    private static final String MONITORS_BUTTON = "//a[contains(text(),'Monitors')]";

    public void openHomePage(String url) {
        driver.get(url);
    }

    public By getGiftCards(){
        return By.xpath(GIFT_CARDS);
    }

    public void clickOnArtsAndCraftsButtonInMenu(){
        artsAndCraftsButtonInMenu.click();
    }

    public By getArtsAndCraftesButton(){
        return By.xpath(ARTS_AND_CRAFTS);
    }

    public By getPaintingDrawingArtSuppliesButtonInMenu(){
        return By.xpath(DRAWING_ART_SUPPLIES);
    }

    public void clickOnPaintingDrawingArtSuppliesButtonInMenu(){
        paintingDrawingArtSuppliesButtonInMenu.click();
    }

    public void searchByKeyword(String keyword){
        searchField.sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnComputersButtonInMenu(){
        computersButtonInMenu.click();
    }
    public void clickOnMonitorsButtonInMenu(){
        monitorsButtonInMenu.click();
    }

    public void clickOnMenuOnHomePage(){
        menuAll.click();
    }

    public void clickOnElectronicsButton(){
        electronicButton.click();
    }

    public void clickOnHeadphonesButton(){
        headphonesButton.click();
    }

    public void clickOnSignInField(){
        signInSecurelyButton.click();
    }

    public void clickOnGiftCardsButton(){
        giftCardsButton.click();
    }


    public void clickOnDeliverToButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(deliverToButton).click().perform();
        actions.release().perform();
    }

    public  By getChooseCountryButton(){
        return By.xpath(CHOOSE_COUNTRY);
    }

    public By getDeliverToButton(){
        return By.xpath(DELIVER_TO);
    }

    public void clickOnChooseYourCountryButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(chooseYourCountryButton).click().perform();
        actions.release().perform();
    }

    public void chooseTurkeyFromTheList(){
        Actions actions = new Actions(driver);
        actions.moveToElement(chooseTurkeyFromTheList).click().perform();
        actions.release().perform();
    }

    public String getNameOfTheCountryToDeliver(){
        return countryBoxOnTheTop.getText();
    }

    public void refreshHomePage(){
        driver.navigate().refresh();
    }

    public By getMonitorsButton(){
        return By.xpath(MONITORS_BUTTON);
    }
}
