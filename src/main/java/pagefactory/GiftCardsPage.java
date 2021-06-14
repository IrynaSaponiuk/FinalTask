package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class GiftCardsPage extends BasePage{
    public GiftCardsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//img[@alt='eGift']")
    private WebElement eGiftButton;

    @FindBy(xpath = "//button[contains(text(),'Standard')]")
    private WebElement standardGiftCardButton;

    @FindBy(xpath = "//img[@id='gc-mini-picker-design-swatch-image-1']")
    private WebElement firstGiftCardDesignButton;

    @FindBy(xpath = "//button[contains(text(),'$150')]")
    private WebElement price150DollarsButton;

    @FindBy(xpath = "//button[contains(text(),'Email')]")
    private WebElement receiveByEmailButton;

    @FindBy(xpath = "//textarea[@placeholder='Enter an email for each recipient']")
    private WebElement enterEmailOfRecipientField;

    @FindBy(xpath = "//input[@id='gc-order-form-senderName']")
    private WebElement yourNameField;

    @FindBy(xpath = "//textarea[@id='gc-order-form-message']")
    private WebElement messageField;

    @FindBy(xpath = "//input[@id='gc-order-form-quantity']")
    private WebElement quantityField;

    @FindBy(xpath = "//input[contains(@class,'a-input-text a-c')]")
    private WebElement deliveryDateField;

    @FindBy(xpath = "//a[contains(text(),'25')]")
    private WebElement dayInCalendarButton;

    @FindBy(xpath = "//input[@id='gc-buy-box-atc']")
    private WebElement addToCartButton;

    private static final String STANDARD_GIFT_CARD = "//button[contains(text(),'Standard')]";
    private static final String RECEIVE_BY_EMAIL = "//button[contains(text(),'Email')]";
    private static final String EMAIL_OF_RECIPIENT = "//textarea[@placeholder='Enter an email for each recipient']";

    public void clickOnAddToCartButton(){
        addToCartButton.click();
    }

    public By getStandardGiftCard(){
        return By.xpath(STANDARD_GIFT_CARD);
    }

    public By getReceiveByEmail(){
        return By.xpath(RECEIVE_BY_EMAIL);
    }

    public By getEmailOfRecipient(){
        return By.xpath(EMAIL_OF_RECIPIENT);
    }

    public void clickOnStandardGiftCardButton (){
        standardGiftCardButton.click();
    }

    public void clickOnEGiftButton(){
        eGiftButton.click();
    }

    public void clickOnPrice150DollarsButton (){
        price150DollarsButton.click();
    }

    public void clickOnReceiveByEmailButton(){
        receiveByEmailButton.click();
    }

    public void enterEmailOfRecipient(String email){
        enterEmailOfRecipientField.sendKeys(email);
    }

    public void enterYourName(String name){
        yourNameField.sendKeys(name);
    }

    public void enterYourMessage(String message){
        messageField.clear();
        messageField.sendKeys(message);
    }

    public void enterQuantityOfGiftCards(String quantity){
        quantityField.sendKeys(quantity);
    }

    public void clickOnCalendarToChooseDateOfDelivery(){
        deliveryDateField.click();
    }

    public void chooseDayOfDelivery(){
        Actions actions = new Actions(driver);
        actions.moveToElement(dayInCalendarButton).click().perform();
        actions.release().perform();
    }

    public WebElement getStandardGiftCardButton() {
        return standardGiftCardButton;
    }

    public WebElement getPrice150DollarsButton() {
        return price150DollarsButton;
    }

    public WebElement getReceiveByEmailButton() {
        return receiveByEmailButton;
    }

    public WebElement getEnterEmailOfRecipientField() {
        return enterEmailOfRecipientField;
    }

    public WebElement getYourNameField() {
        return yourNameField;
    }

    public WebElement getMessageField() {
        return messageField;
    }

    public WebElement getQuantityField() {
        return quantityField;
    }

    public WebElement getDeliveryDateField() {
        return deliveryDateField;
    }




}
